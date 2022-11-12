package ejemploarchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EjemploArchivo {

    public static void main(String[] args) {
        /*
        Algoritmo para escribir en un archivo desde Java
        1. Crear una variable de tipo File
        2. Crear una variable de tipo PrintWriter
        3. Preparar al archivo
        4. Verificar si el archivo no existe
         4.1 Crear el archivo
        4.2 En otro caso (else)
           4.2.1 Preparar el archivo para escribir
           4.2.2 escribir en el archivo
           4.2.3 Cerrar el archivo
        */
        String nombre;
        File miArchivo;
        PrintWriter escribir;
       
        miArchivo = new File("EjemploEscritura.txt");
        
        if (!miArchivo.exists()) {
            System.out.println("Archivo creado con exito");
            try {
                miArchivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(EjemploArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("El archivo ya existe");
            try {
                escribir = new PrintWriter(miArchivo,"utf-8");
                nombre = JOptionPane.showInputDialog(null,"Digite su nombre: ");
                escribir.println("Hola, Bienvenido " + nombre + " a la fiesta!");
                escribir.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EjemploArchivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(EjemploArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
