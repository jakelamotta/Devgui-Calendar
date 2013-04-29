package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public class RSSReader {

    private URL urlAddress;
    private ArrayList<String> rssData;
    private BufferedReader reader; 
    
    public RSSReader(String url) throws MalformedURLException{
        this.urlAddress = new URL(url);
    }
    
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
    
}
