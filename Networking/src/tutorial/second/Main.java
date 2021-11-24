package tutorial.second;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            // When using relative URIs, we can use multiple of them with the same host, by using the "resolve()".
            // By using it, if you need to make any changes on the base URI we only have to edit one line of code.
            // In a real world application, a base URI would be constant.
            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);


            // To get a relative URI based on the absolute URI.
            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativizedURI);


            URL url = new URL("http://example.org");

            URI uri = url.toURI(); // Converting the URL back to a URI
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());
        }
        catch (URISyntaxException e)
        {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }
        catch (MalformedURLException e)
        {
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }

}