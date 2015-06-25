

/**
 *
 * @author Karinya
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class OlympicPictureModel {
    private String pictureTag;
    private String pictureURL;

    public void doOlympicPictureSearch(String search) {
         pictureTag = search;
         String response = "";
        try {
            // Create a URL for the desired page            
            URL url = new URL("http://www.olympic.org/photos/search-results?Men=true&Women=true&Mixed=true&Sport=&Game=&Country=&Search="+search);
            // Create an HttpURLConnection.  This is useful for setting headers and for getting the
            // path of the resource that is returned (which may be different than the URL above if
            // redirected).
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) {
                // str is one line of text; readLine() strips the newline character(s)
                response += str;
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        
        // find the picture URL to scrape
        int startfarm = response.indexOf("href=\"/Assets/MediaPlayer/Photos/");

        int endfarm = response.indexOf("hd.jpg", startfarm+6); // only start looking after the quote before http
        pictureURL = "src=\"http://www.olympic.org" + response.substring(startfarm+6, endfarm+6) + "\""; // +1 to include the quote
    }

    public String getPictureTag() {
        return (pictureTag);
    }
    public String getPictureURL() {
        return (pictureURL);
    }
}
