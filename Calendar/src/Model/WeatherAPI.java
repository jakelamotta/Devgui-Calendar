package Model;

import Enums.Weather;
import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import java.util.GregorianCalendar;

/**
 *
 * @author Kristian
 */
public class WeatherAPI {
    
    private HttpDataReaderService reader;
    private final WeatherStation weatherStation = WeatherStations.ALL.get("INORDRHE72");
    private double maxTemp;
    private double minTemp;
    private boolean rainy;
    private boolean cloudy;
    private boolean sunny;
    private double avgTemp;
    
    public WeatherAPI(){
        reader = new HttpDataReaderService();
        reader.setWeatherStation(weatherStation);
    }

    public Weather getWeather(GregorianCalendar date){
        Weather weather = Weather.CLOUD;
        reader.setWeatherDate(date.getTime());
        return weather;
    }
    
    public static void main(String[] args){
        WeatherAPI api = new WeatherAPI();
        api.getWeather(new GregorianCalendar());
    }
    
}
