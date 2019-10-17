import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Connection {

    private URL url;
    private HttpURLConnection httpURLConnection;
    private String line;

    public void connect() {



            try {
                url = new URL("http://10.10.10.100:8888/getWorkers");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Authorization", "TEST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            try {
                httpURLConnection.getResponseCode();
                httpURLConnection.getResponseMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()) );
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
            StringBuilder response = new StringBuilder();


                while (true) {
                    try {
                        if (!((line = in.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    response.append(line);
                }

                //print result
                System.out.println(response.toString());







    }
}
