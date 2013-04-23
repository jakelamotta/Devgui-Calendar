package Model;

import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import java.util.GregorianCalendar;

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
    private boolean rainy;
    private boolean windy;
    private boolean sunny;
    private boolean snowy;
    private double avgTemp;
    
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
        setRain();
        setWind();
        setMaxTemp();
        setMinTemp();
        setAvgTemp();
        setSnow();
    }  
    
    public static void main(String[] args){
        WeatherAPI api = new WeatherAPI();
        api.setWeather(new GregorianCalendar());
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
    
    private void setWind(){
        if(reader.maxTemperature().getWindSpeedKmh() > 5){
            this.windy = true;
        }
        else{
            this.windy = false;
        }
    }
    
    private void setMaxTemp(){
        this.maxTemp = reader.maxTemperature().getTemperature();
    }
    
    private void setMinTemp(){
        this.minTemp = reader.minTemperature().getTemperature();
    }
    
    private void setAvgTemp(){
        this.avgTemp = (maxTemp+minTemp)/2;
    }
        
    private void setRain(){
        if(reader.maxTemperature().getRainRateHourlyMm() > 40){
            this.rainy = true;
        }
        else{
            this.rainy = false;
        }
    }
    
    private void setSnow(){
        if(this.reader.maxTemperature().getTemperature() < 0 && isRainy()){
            this.snowy = true;
        }
        else{
            this.snowy = false;
        }
    }
    
    public double getAvgTemp(){
        return this.avgTemp;
    }
    
    public double getMinTemp(){
        return this.minTemp;
    }
    
    public boolean isWindy(){
        return this.windy;
        
    }
    
    
    public boolean isSunny(){
        return this.sunny;
    }
    
    public boolean isRainy(){
        return this.rainy;
    }
    
    public boolean isSnowy(){
        return this.snowy;
    }

    public String getCity() {
        return this.weatherStation.getCity();
    }
    
}
