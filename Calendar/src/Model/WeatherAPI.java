package Model;

import Enums.Weather;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * API for getting weather from a specified weatherstation
 * 
 * Not done:
 * 
 * Currently hardcoded but I will fix this so its dynamic via some sort
 * of IP-check if its possible.
 *  * 
 * Right now I did it so that you can have windy and sunny at the same time
 * rather than working with mutually exclusive enums, I think this is a better
 * idea but I am open for suggestions.
 * 
 * @author Kristian
 */
public class WeatherAPI {
    
    private HttpDataReaderService reader;
    private final WeatherStation weatherStation = WeatherStations.ALL.get("INORDRHE72");
    private double maxTemp;
    private double minTemp;
    private double avgTemp;
    private String weatherURLAddress = "http://weather.yahooapis.com/forecastrss?w=908572";
    
    /**
     * Default constructor, initializes the reader and sets the hardcoded 
     * weatherStation
     */
    public WeatherAPI(){
        reader = new HttpDataReaderService();
        reader.setWeatherStation(weatherStation);
    }
    
    /**
     * Sets the reader object's weather date so the correct weather will
     * get retrieved. Also sets all the weather instances to their values
     * accordingly
     * @param date 
     */
    public void setWeather(GregorianCalendar date){
        reader.setWeatherDate(date.getTime());
        //setMaxTemp();
        //setMinTemp();
        setAvgTemp();
    }  
    
    
    /**
     * For testing the api only, SHOULD BE REMOVED FOR FINAL VERSION!!!!!
     * @param args 
     */
    public static void main(String[] args){
        WeatherAPI api = new WeatherAPI();
        api.setWeather(new GregorianCalendar());
        
        try {
            System.out.println(api.getWeatherCode());
        } 
        catch(MalformedURLException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(IOException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(api.getCity());
    }
    
    /**
     * Function that reads the rss-feed and returns a list of raw, unparsed, data
     */
    private ArrayList<Integer> getWeatherCode() throws MalformedURLException, IOException{
        RSSReader reader = new RSSReader(weatherURLAddress);
        ArrayList<String> list = reader.readRSS();
        
        return parseList(list);        
    }
    
    public int getAvgTemp(GregorianCalendar cal) throws MalformedURLException, IOException{
        RSSReader reader = new RSSReader(weatherURLAddress);
        ArrayList<String> list = reader.readRSS();
        
        if(Utilities.isSpecficDay(cal, 0)){
            this.avgTemp = getTemperature(list).get(1);
        }
        else if(Utilities.isSpecficDay(cal,1)){
            this.avgTemp = getTemperature(list).get(2);
        }       
        
        return (int)this.avgTemp; 
    }
    
    
    public ArrayList<Integer> getTemperature(ArrayList<String> list){
        Iterator iterator = list.iterator();
        String line;
        ArrayList<Integer> temperatures = new ArrayList();  
        int low;
        int high;
        int avg;
        char pos1;
        char pos2;
        
        while(iterator.hasNext()){
            line = iterator.next().toString();
            if(line.contains("code=")){
                String[] temp;
                String temp2;
                
                temp = line.split("low=");
                temp2 = temp[1];
                
                pos1 = temp2.charAt(1);
                pos2 = temp2.charAt(2);
                low = Character.digit(pos1, 10)*10+Character.digit(pos2, 10);
                
                temp = line.split("high=");
                temp2 = temp[1];
                
                pos1 = temp2.charAt(1);
                pos2 = temp2.charAt(2);
                high = Character.digit(pos1, 10)*10+Character.digit(pos2, 10);
                
                avg = (low+high)/2;
                
                temperatures.add(Utilities.fahrenheitToCelcius(avg));
            }
            
            
        }
        
        System.out.println(temperatures.size());
        return temperatures;
    }
    
    /**
     * Parse the data thats been retrieved from the RSS-feed of yahoo weather
     * page. Return this as an arraylist of weather codes.
     * @param list List of source code from the rss-feed
     * @return List of codes for given days
     */
    private ArrayList<Integer> parseList(ArrayList<String> list) {
        Iterator iterator = list.iterator();
        String line;
        ArrayList<Integer> codes = new ArrayList();  
        
        while(iterator.hasNext()){
            line = iterator.next().toString();
            if(line.contains("code=")){
                String[] temp;
                String temp2;
                
                temp = line.split("code=");
                temp2 = temp[1];
                
                char pos1 = temp2.charAt(1);
                char pos2 = temp2.charAt(2);
                
                codes.add(Character.digit(pos1, 10)*10+(Character.digit(pos2, 10)));
            }
            
            
        }
        return codes;
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
        
    private void setAvgTemp(){
        this.avgTemp = (maxTemp+minTemp)/2;
    }
        
        
    public double getMinTemp(){
        return this.minTemp;
    }

    public String getCity() {
        return this.weatherStation.getCity();
    }
    
    /**
     * Function that gets the weather for the specified day, given
     * the rss feed used presently only today's and tomorrow's weather
     * can be retrieved.
     * @param cal Date to retrieve weather for
     * @return Weather description as weather enum value
     * @throws MalformedURLException
     * @throws IOException 
     */
    public Weather getWeather(GregorianCalendar cal) throws MalformedURLException, IOException{
        int code;
        
        if(Utilities.isSpecficDay(cal,1)){
            code = getWeatherCode().get(2);
        }
        else if(Utilities.isSpecficDay(cal, 0)){
            code = getWeatherCode().get(1);
        }
        else{
            code = -1;
        }
        
        switch(code){
            default:
                return Weather.UNKNOWN;
            case 28:
                return Weather.CLOUDY;
            case 11:
                return Weather.RAINY;
            case 12:
                return Weather.RAINY;
            case 13:
                return Weather.SNOWY;
            case 16:
                return Weather.SNOWY;
            case 31:
                return Weather.SUNNY;
            case 32:
                return Weather.SUNNY;    
        }              
    }
    
}
