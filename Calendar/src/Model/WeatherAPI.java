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
 * 
 * Actually determining what constitutes as rain, windy and snowy needs
 * to be calibrated
 * 
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
    private String weatherURLAddress = "http://weather.yahooapis.com/forecastrss?w=2502264";
    
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
    
    public static void main(String[] args){
        WeatherAPI api = new WeatherAPI();
        api.setWeather(new GregorianCalendar());
        
        try {
            System.out.println(api.getWeatherCode(new GregorianCalendar()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(api.getCity());
    }
    
    private int getWeatherCode(GregorianCalendar date) throws MalformedURLException, IOException{
        RSSReader reader = new RSSReader(weatherURLAddress);
        ArrayList<String> list = reader.readRSS();
        
        return parseList(list);        
    }
    
    private int parseList(ArrayList<String> list) {
        Iterator iterator = list.iterator();
        String line;
        int code = 0;
        
        while(iterator.hasNext()){
            line = iterator.next().toString();
            if(line.contains("code=")){
                String[] temp;
                temp = line.split("code=");
                line = temp[1];
                char pos1 = line.charAt(1);
                char pos2 = line.charAt(2);
                code = Character.digit(pos1, 10)*10+(Character.digit(pos2, 10));
                break;
            }
        }
        return code;
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
       
    private void setMaxTemp(){
        this.maxTemp = reader.maxTemperature().getTemperature();
    }
    
    private void setMinTemp(){
        this.minTemp = reader.minTemperature().getTemperature();
    }
    
    private void setAvgTemp(){
        this.avgTemp = (maxTemp+minTemp)/2;
    }
        
    
    public double getAvgTemp(){
        return this.avgTemp;
    }
    
    public double getMinTemp(){
        return this.minTemp;
    }

    public String getCity() {
        return this.weatherStation.getCity();
    }
    
    public Weather getWeather(int code){
               
        switch(code){
            default:
                return Weather.UNKNOWN;
            case 28:
                return Weather.CLOUDY;
            case 11:
                return Weather.RAINY;
            case 16:
                return Weather.SNOWY;
            case 32:
                return Weather.SUNNY;
        }              
    }
    
}
