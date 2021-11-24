package tutorial.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// HttpURLConnection
// When your browser asks for a web page, it does what's called a GET request. The server that hosts the page then
// respond, and the response will include a code, if the server is able to return the webpage successfully it returns
// the code 200 that means OK. The code 400 is returned otherwise.
// A 500 code means that something critical went wrong, for example, the database the web page needs to access could be
// down. The return code is called the response code.
// When we want to provide information to a URL, we use a POST operation, for example, posting values to a form.

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // When writing to a URL, it's best to use specific classes such as "HttpURLConnection" class that's a
            // subclass of the "URLConnection" class, this is because the URLConnection is a generic class.
            // The "HttpURLConnection" supports http specific features.
            URL url = new URL("http://example.org");
            // The method below is smart enough to return a "HttpURLConnection" or a "JarConnection".
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Configuring the connection, normally by default "GET" is already use, but it's a good practise to
            // write it.
            connection.setRequestMethod("GET");

            // Just as with Sockets we can set a timeout
            connection.setReadTimeout(30000);

            // When dealing with a high-end API you're dealing with abstractions, things are being dealt automatically.
            // So when you call the connect method for the first time Java creates the sockets, does handshakes, etc.
            // So even if you close the "HttpURLConnection" the connection may persist.
            // Each "HttpURLConnection" instance can only be used to make one request, but the connection may persist
            // across connection objects, it may persist even if you close the connection, since create a socket for
            // each request might be inefficient Java may persist the connection under the covers.

            // Getting specific header field
            // In the method below, the first parameter is the key and the second is the value.
            connection.setRequestProperty("User-Agent", "Chrome");

            // Some methods implicitly perform the connection step, so we don't have to call the "connect()" method.
            // The "getResponseCode()" is one example of them as well as the "getInputStream()".
            // Essentially if an operation requires to be connected to work it will perform the connection when
            // necessary. If you call "connect()" when a connection has already been established it won't do anything.
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200)
            {
                System.out.println("Error reading web page");
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
// More about the other operations at: https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html

