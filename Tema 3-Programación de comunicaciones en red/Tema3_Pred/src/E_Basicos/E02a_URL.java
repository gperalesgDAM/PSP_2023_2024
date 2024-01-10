package E_Basicos;

import java.net.MalformedURLException;
import java.net.URL;

public class E02a_URL {
	
public static void main (String[] args) {
		
		URL url;
		try {
			
                    System.out.println("Constructor simple para una URL");
                    url = new URL("http://developer.oracle.com");
                    visualizar(url);

                    System.out.println("Constructor para protocolo + URL  + directorio");
                    url = new URL("http", "developer.oracle.com", "/devo/java");
                    visualizar(url);
                    System.out.println("Constructor simple con URL con Query");
                    url = new URL("https://www.decathlon.es/es/p/bota-de-esqui-alpino-freeride-travesia-mujer-wedze-fr-500-flex-90-lowtech/_/R-p-308562?mc=8563589");
                    visualizar(url);
                    System.out.println("Constructor simple con URL con Port");
                    url = new URL("https://www.decathlon.es:443");
                    visualizar(url);
                    
                    System.out.println("Constructor simple con URL mal formada");
                    url = new URL("ww.decathlon.es:443");
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
