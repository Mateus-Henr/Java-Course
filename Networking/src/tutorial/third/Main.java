package tutorial.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Accessing a location on the Internet
            // When working with web locations you'll mainly use URIs to build absolute URIs from the relative ones.
            // When working with web pages we usually have to provide a web address.
            URL url = new URL("http://example.org");

            // The method used below opens a connection to the URL, and it'll be doing all the low-level stuff, like
            // creating a socket (since we are using a high-end API).
            // This method is a can be divided into two steps that can be done individually, first you can open a
            // "Connection" to a URL, and then you use the "Connection.openConnection()" method, this method returns
            // a URLConnection and you can get an input stream from it.
            // This will return the entire HTML of the page, so depending on what you're trying to achieve you'll have
            // to pick up specific tags.
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";

            while (line != null)
            {
                line = inputStream.readLine();
                System.out.println(line);
            }

            System.out.println("\nRetrieving the content step by step");
            // This first method doesn't connect to the URL, it returns an instance that's used to configure the
            // connection since these configurations will depend on how the connection is made. If you try to do any
            // configuration after you'll get an error.
            // When using this class the URL you are connecting to, doesn't need to be a webpage.
            // But many of the methods in this class are only applicable to http connections.
            // By default, you can only read from a connection, if you want to write you need to call the
            // "URLConnection.setDoOutput()" before connecting.
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true); // Allowing writing.
            urlConnection.connect();

            inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            line = "";

            while (line != null)
            {
                line = inputStream.readLine();
                System.out.println(line);
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