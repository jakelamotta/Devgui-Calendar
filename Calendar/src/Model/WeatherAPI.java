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
        //reader object to read weather information
        reader = new HttpDataReaderService();
        
        //station to read data from
        reader.setWeatherStation(weatherStation);
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
     * Function that parse the data of a rss-document and return the weathercodes
     * for that document
     */
    private ArrayList<Integer> getWeatherCode() throws MalformedURLException, IOException{
        return parseList(getRSSDocument());        
    }
    
    /**
     * Function that retrieves a rss-document from the address specified by
     * the field weatherURLAddress
     * @return an RSS-document in the form of an arraylist
     * @throws IOException 
     */
    private ArrayList<String> getRSSDocument() throws IOException{
        RSSReader rssreader = null;
        
        try {
            rssreader = new RSSReader(weatherURLAddress);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rssreader.readRSS();
    }
    
    /**
     * Function that returns a list of temperatures available in the rss document
     * provided as input
     * @param list Arraylist to parse
     * @return List of integers (temperatures)
     */
    public ArrayList<Integer> getTemperatures(ArrayList<String> list){
        Iterator iterator = list.iterator();
        String line;
        ArrayList<Integer> temperatures = new ArrayList();  
        int low;
        int high;
        int avg;
        char pos1;
        char pos2;
        
        //Iterate over the elements in the list, where "low=" exists the number
        //after this string is converted to an integer.
        while(iterator.hasNext()){
            line = iterator.next().toString();
            if(line.contains("low=")){
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
        
        //Iterate over the elements in the list, where "code=" exists the number
        //after this string is converted to an integer.
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
        
        //Check weather date is today or tomrrow to determine
        //which data to provide
        if(Utilities.isSpecficDay(cal,1)){
            code = getWeatherCode().get(2);
        }
        else if(Utilities.isSpecficDay(cal, 0)){
            code = getWeatherCode().get(1);
        }
        else{
            //If neither weather cant be retrieved
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
    
    
    public void setAvgTemp(GregorianCalendar cal) throws IOException{
        //Check weather date is today or tomrrow to determine
        //which data to provide
        if(Utilities.isSpecficDay(cal, 0)){
            this.avgTemp = getTemperatures(getRSSDocument()).get(1);
        }
        else if(Utilities.isSpecficDay(cal,1)){
            this.avgTemp = getTemperatures(getRSSDocument()).get(2);
        }
    }
    
    public int getAvgTemp(){
        return (int)this.avgTemp; 
    }    
    
    /**
     * Sets the reader object's weather date so the correct weather will
     * get retrieved. Also sets all the weather instances to their values
     * accordingly
     * @param date 
     */
    public void setWeather(GregorianCalendar date){
        reader.setWeatherDate(date.getTime());
        setAvgTemp();
    } 
}
