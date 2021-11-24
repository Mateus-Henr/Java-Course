package tutorial;

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
            // URI instance that performs a database query
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

            // When using URI, just as with files, until you try to access a resource it doesn't have to exist.
//            URI uri = new URI("hello");

            // URI that's an absolute path, so the URL will be the same value.
//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

            // Below we have a relative URI since it doesn't completely identify the resource. It doesn't contain the
            // scheme, so you don't know where it points to (webpage, database, etc). Overall, there isn't enough
            // information to access the resource.
            // URLs must be absolute, so if we try to convert the URI below we will get an exception.
//            URI uri = new URI("/catalogue/phones?os=android#samsung");

            // Normally when using relative URIs you'll use them along with the base URI, so this base URI will specify
            // the root of the relative path, which is quite handy. So if you're accessing multiple pages on a website
            // instead of using absolute URIs, it's probably best to have a base that contains the host information and
            // a bunch of relative URIs for the specific pages. Therefore, if the host location changes, you only will
            // have to update the base URI.
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(uri); // Combining base with relative URI.


            // URI Components (some of them are optional)
            // Part that comes before the colons, not recommended writing your own.
            System.out.println("Scheme = " + uri.getScheme());
            // After the colon, this is the identifier for the resource you want to use.
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            // Contains the host (could be an IPV4 or 6) and often a password, as well as the username and port number.
            System.out.println("Authority = " + uri.getAuthority());
            // Contains username and password, any credentials required to access the resource.
            System.out.println("User info = " + uri.getUserInfo());
            // Host name or IPV4 or 6.
            System.out.println("Host = " + uri.getHost());
            // The port number.
            System.out.println("Port = " + uri.getPort());
            // Path for the resource on the host. In this case is a table in a database.
            System.out.println("Path = " + uri.getPath());
            // Separated by a "?" from the path, it's often a key-value pair.
            System.out.println("Query = " + uri.getQuery());
            // Specifies a secondary resource or location, in  this case it says that only "samsung" phones should be
            // returned.
            System.out.println("Fragment = " + uri.getFragment());

            // Converting URI to URL
            // A URI doesn't need to be valid when you are working with it, it only has to be valid when you want to
            // convert it to an absolute location, example of this conversion below.
//            URL url = uri.toURL();
//            System.out.println("URL = " + url);

            // Converting the resolvedURI
            URL url = resolvedUri.toURL();
            System.out.println("URL = " + url);
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