package tutorial.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main
{
    // THE JAVA.NET PACKAGE IS AN OLDER VERSION OF HTTP PROTOCOL AND IT'S RARELY USED.
    // THERE ARE SEVERAL PROBLEMS WITH IT.
    // Two popular libraries to work with HTTP protocol are:
    // Jetty
    // Apache HTTPClient
    public static void main(String[] args)
    {
        try
        {
            // Invalid URL
            // When using URLs is always a good idea to test them in a browser first.
//            URL url = new URL("http://example.org/somepage.html");
            // The query can be edited as it say on the site: https://www.flickr.com/services/feeds/docs/photos_public/
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=dogs");
            // You can also use the "HttpsURLConnection", but it's in the "javax.net.ssl" package.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);

            connection.setRequestProperty("User-Agent", "Chrome");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200)
            {
                System.out.println("Error reading web page");
                // This method can be used to get more information about the error.
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = inputReader.readLine()) != null)
            {
                System.out.println(line);
            }

            inputReader.close();
        }
        catch (MalformedURLException e)
        {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}

// Writing to a connection (Example)
// URL url = new URL("http://somewebpage//processform.php");
//
// HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
// connection .setRequestMethod("POST");
//
// connection.setRequestProperty("User-Agent", "Chrome");
// connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
// // This is a way to set multiple parameters
// String parameters = "parameter1=25&parameter2=hello"; // It's a part of the URL, appears after the "?"
// connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
//
// connection.setUseCaches(false);
// connection.setDoOutput(true);
// connection.setDoInput(true);
//
// DataOutputStream output = new DataOutputStream(connection.getOutputStream());
// output.writeBytes(parameters);
//
// output.flush();
//
// output.close();
//
// InputStream input = connection.getInputStream();
// BufferedReader reader = new BufferedReader(new InputStreamReader(input));
// String line;
// while((line = reader.readLine()) != null) {
//      System.out.printin(line);
// }