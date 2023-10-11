/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;
import java.io.*;

/**
 *
 * @author guipe
 */
//LEctura de ficheros byte a byte
public class E04_Copiarfichero {
    public static void main(String[] args) throws IOException{
        File rutaOrigen = new File ("");
        File rutaDestino = new File ("");
        FileInputStream fis = new FileInputStream(rutaOrigen);
        FileOutputStream fos = new FileOutputStream(rutaDestino);
        
        int b; //Almacenamos los bytes en esta variable
        
        while((b=fis.read())!=-1){
            System.out.print((char) b);
            fos.write(b);

        }

        fis.close();
        fos.close();
    }
    
    
    
}