package E_Basicos;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;

public class E02a_URL {
	
public static void main (String[] args) {
		
		URL url;
		try {
			
			System.out.println("Constructor simple para una URL");
			url = new URL ("http://developer.oracle.com");
			visualizar(url);
			
			System.out.println("Constructor para protocolo + URL  + directorio");
			url = new URL ("http","developer.oracle.com", "/devo/java");
			visualizar(url);
			
		} catch (MalformedURLException e) {
			System.out.println (e);
		}
	}
	public static void visualizar (URL url) {
		
		System.out.println("URL completa: " + url.toString());
		System.out.println("getProtocol: " + url.getProtocol());
		System.out.println("getPHost: " + url.getHost());
		System.out.println("getPort: " + url.getPort());
		System.out.println("getFile: " + url.getFile());
		System.out.println("getUserInfo: " + url.getUserInfo());
		System.out.println("getPath: " + url.getPath());
		System.out.println("getAuthority: " + url.getAuthority());
		System.out.println("getQuery: " + url.getQuery());
		System.out.println("getDefaultPort: " + url.getDefaultPort());
		System.out.println ("======================");
	}
	

	
	

}
