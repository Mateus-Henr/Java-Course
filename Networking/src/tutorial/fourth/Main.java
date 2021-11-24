package tutorial.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            // We can also get specific parts of a web page without having to read everything.
            // The method below will retrieve all the header field information, you can also get a specific one by using
            // its singular version.
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headerFields.entrySet())
            {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("-----------KEY = " + key);
                for (String string : value)
                {
                    System.out.println("Value = " + string);
                }
            }
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

