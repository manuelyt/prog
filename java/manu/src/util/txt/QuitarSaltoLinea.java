

package util.txt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
public class QuitarSaltoLinea {
     public QuitarSaltoLinea() { super(); }
     /*
           Este programita me lo hice para quitar los salto de linea de los ficheros de texto.
           por ejemplo, cuando se copia un fichero pdf a txt, al copiarlo, se copian los saltos de linea
           usando este programita, se eliminan esos saltos de linea
           este lo use para formatear este :"Arendt-Hannah-Los-Origenes-Del-Totalitarismo.txt"
    */
     public static void main(String[] args) {
          String nficheror1 = "c:\\manu\\basura\\1.txt";
          String nficheror2 = "c:\\manu\\basura\\2.txt";
          String linea = "";
          BufferedReader br = null;
          FileWriter fichero = null;
          PrintWriter pw = null;
          try {
               br = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror1), "utf-8"));
               fichero = new FileWriter(nficheror2);
               pw = new PrintWriter(fichero);
               while ((linea = br.readLine()) != null) {
                    int longi = linea.length();
                    if (longi > 84 & longi < 120) {
                         pw.print(linea + " ");
                    } else {
                         pw.println(linea);
                    }
               }
          } catch (Exception e) {
               System.out.println(" xxx Se ha producido un error. ");
               e.printStackTrace();
          } finally {
               try {
                    if (null != fichero)
                         fichero.close();
               } catch (Exception e2) {
                    System.out.println(" xxx Error al cerrar el fichero. ");
                    e2.printStackTrace();
               }
          }
     }
}





