package tutorial.sixth;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The jar files to import Apache into the project can be found in the "bin" folder. Just add them as libraries to
// this project.
public class ApacheTest
{
    // Equivalent code used before
    public static void main(String[] args) throws IOException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-Agent", "Chrome");

        // Recommended closing in the "finally" block.
        CloseableHttpResponse response = httpClient.execute(request); // This sends the request
        try
        {
            System.out.println("Response code = " + response.getCode());

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;

            while ((line = inputReader.readLine()) != null)
            {
                System.out.println(line);
            }

            inputReader.close();
        }
        finally
        {
            response.close();
        }
    }

}
