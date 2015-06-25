package ds.project4task3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * This class provides capabilities get age given person date of birth.
 *
 * @author Karinya
 */
public class GetPersonAge {

    AgeActivity ageActivity = null;

    /**
     * This method will execute methods in AsyncAgeCal, which extends from
     * AsyncTask
     *
     * @param dateOfBirth
     * @param ip
     */
    public void getAge(Calendar dateOfBirth, AgeActivity ip) {
        this.ageActivity = ip;
        new AsyncAgeCal().execute(dateOfBirth);
    }

    /**
     * AsynAgeCal class lets to program run from UI and Helper thread.
     */
    private class AsyncAgeCal extends AsyncTask<Calendar, Void, String> {

        /**
         * This method is run in the helper thread.
         *
         * @param c
         * @return
         */
        protected String doInBackground(Calendar... c) {
            String URL = "http://www.project4task3-karinya.appspot.com/project4task3servlet?year="
                    + c[0].get(Calendar.YEAR) + "&month=" + c[0].get(Calendar.MONTH) + "&day=" + c[0].get(Calendar.DATE);
            Document doc = getRemoteXML(URL);
            System.out.println(URL);
            System.out.println(doc.toString());

            String result = doc.getElementsByTagName("Result").item(0).getFirstChild().getTextContent();
            if (result.equals("Fail")) {
                return "Error: cannot calculate age.";
            } else {
                String age = doc.getElementsByTagName("Age").item(0).getFirstChild().getTextContent();
                return "The person is " + age + " years old.";
            }

        }

        /**
         * The onPostExecute is run in the UI thread, when result is ready
         *
         * @param result
         */
        protected void onPostExecute(String result) {
            ageActivity.showResult(result);

        }

        /**
         * This method returns a Document with that XML, given a url.
         *
         * @param url
         * @return
         */
        private Document getRemoteXML(String url) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource(url);
                return db.parse(is);
            } catch (Exception e) {
                System.out.print(e);
                return null;
            }
        }
    }
}