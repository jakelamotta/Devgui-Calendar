package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Class that provides functionality to read from RSS-feeds
 * @author Kristian
 */
public class RSSReader {

    private URL urlAddress;
    private ArrayList<String> rssData;
    private BufferedReader reader; 
    
    /**
     * Default constructor, initializes the url address of the feed
     * @param url
     * @throws MalformedURLException 
     */
    public RSSReader(String url) throws MalformedURLException{
        this.urlAddress = new URL(url);
    }
    
    /**
     * Function that reads an RSS, returns an arraylist with the raw data
     * @return an arraylist with the raw data
     * @throws IOException 
     */
    public ArrayList<String> readRSS() throws IOException{
        
        reader = new BufferedReader(new InputStreamReader(urlAddress.openStream()));
        String line;
        rssData = new ArrayList();
        
        while((line = reader.readLine()) != null){
            rssData.add(line);
        }        
        
        reader.close();
        
        return rssData;
    }
    
    /**
     * Set the url address to read from to input value
     * @param url
     * @throws MalformedURLException 
     */
    public void setURLAddress(String url) throws MalformedURLException{
        this.urlAddress = new URL(url);
    }
    
}
