
package util.txt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;
public class QuitarPorcentajeUrl {
     public QuitarPorcentajeUrl() {
          super();
     }
     /*
           Este programita me lo hice para cambiar los caracteres html de las urls.
           por ejemplo, en una url como esta ( el puto sharepoint hace esto )
     https://projects.nationalgrid.com/sites/iEP/test/_layouts/xlviewer.aspx?id=/sites/iEP/test/Project%20Management/Service%20Transition%20Doc
           y lo que yo quiero es que salga de esta forma
     https://projects.nationalgrid.com/sites/iEP/test/_layouts/xlviewer.aspx?id=/sites/iEP/test/Project Management/Service Transition Doc
           otro ejemplo, si a esta url :
     https://projects.nationalgrid.com/sites/iEP/test/_layouts/xlviewer.aspx?id=/sites/iEP/test/Project%20Management/Service%20Transition%20Doc/AM%20iEP%20Availability%20Tracker.xlsx&Source=https%3A%2F%2Fprojects%2Enationalgrid%2Ecom%2Fsites%2FiEP%2Ftest%2FProject%2520Management%2FForms%2FLive%2520Documents%2Easpx%3FRootFolder%3D%252Fsites%252FiEP%252Ftest%252FProject%2520Management%252FService%2520Transition%2520Doc%26FolderCTID%3D0x01200067C1E51EEFF36A4AADC42E2F06964C4D%26GroupString%3D%253B%2523Resource%2520Management%253B%2523%26IsGroupRender%3DTRUE&DefaultItemOpen=1&DefaultItemOpen=1
           le aplicamos esta rutina 1 vez obtenemos : 
     https://projects.nationalgrid.com/sites/iEP/test/_layouts/xlviewer.aspx?id=/sites/iEP/test/Project Management/Service Transition Doc/AM iEP Availability Tracker.xlsx&Source=https://projects.nationalgrid.com/sites/iEP/test/Project%20Management/Forms/Live%20Documents.aspx?RootFolder=%2Fsites%2FiEP%2Ftest%2FProject%20Management%2FService%20Transition%20Doc&FolderCTID=0x01200067C1E51EEFF36A4AADC42E2F06964C4D&GroupString=%3B%23Resource%20Management%3B%23&IsGroupRender=TRUE&DefaultItemOpen=1&DefaultItemOpen=1
           y si se lo volvemos a aplicar obtenemos :
     https://projects.nationalgrid.com/sites/iEP/test/_layouts/xlviewer.aspx?id=/sites/iEP/test/Project Management/Service Transition Doc/AM iEP Availability Tracker.xlsx&Source=https://projects.nationalgrid.com/sites/iEP/test/Project Management/Forms/Live Documents.aspx?RootFolder=/sites/iEP/test/Project Management/Service Transition Doc&FolderCTID=0x01200067C1E51EEFF36A4AADC42E2F06964C4D&GroupString=;#Resource Management;#&IsGroupRender=TRUE&DefaultItemOpen=1&DefaultItemOpen=1
           que es lo que buscabamos ( ya no hay ningun % en la url )
           uso 3 ficheros, uno de entrada, otro de salida y otro con el diccionario de los caracteres:
     20   espacio
     2F / ( division )
     2E . ( punto )
     25 % ( porcentaje )
     23 # ( numero )
     3B ; ( punto y coma )
     3D = ( igual )
     26 & ( and )
     3A : ( dos puntos )
     3F ? ( signo de interrogación - cierre )
           el fichero de diccionario, tiene que tener este formato ( los codigos uno detras de otro y despues los caracteres ) :
     20
     2F
     2E
     25
     23
     3B
     3D
     26
     3A
     3F
     /
     .
     %
     #
     ;
     =
     &
     :
     ?
    */
     public static void main(String[] args) {
          String nficheror1 = "c:\\manu\\basura\\000\\1.txt";
          String nficheror2 = "c:\\manu\\basura\\000\\2.txt";
          String nficheror3 = "c:\\manu\\basura\\000\\3.txt";
          String linea = "";
          BufferedReader br = null;
          BufferedReader dicc = null;
          FileWriter fichero = null;
          PrintWriter pw = null;
          int longi = 0;
          int lineas = 0;
          int lineas2 = 0;
          HashMap<Integer, String> lista = new HashMap<Integer, String>();
          HashMap<String, String> hdicc = new HashMap<String, String>();
          Vector<String> faltan = new Vector<String>();
          String caracterEscape = "%";
          try {
               dicc = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror3),  "utf-8"));
               fichero = new FileWriter(nficheror2);
               pw = new PrintWriter(fichero);
               // cuento las lineas del diccionario:
               while ((linea = dicc.readLine()) != null) {
                    longi++;
               }
               // meto el diccionario en una hashtable
               dicc = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror3), "utf-8"));
               while ((linea = dicc.readLine()) != null) {
                    if (lineas < longi / 2) {
                         lista.put(lineas, linea);
                    } else {
                         hdicc.put(lista.get(lineas2), linea);
                         lineas2++;
                    }
                    lineas++;
               }
               // ahora hago las sustituiciones de los caracteres usando el diccionario
               br =  new BufferedReader(new InputStreamReader(new FileInputStream(nficheror1), "utf-8"));
               linea = br.readLine();
               String lineaok1 = linea;
               String lineatemp2 = linea;
               while (linea != null) {
                    int busq = lineatemp2.indexOf(caracterEscape);
                    if (busq == -1) {
                         lineaok1 = linea;
                    }
                    while (busq != -1) {
                         String codigo =
                              lineatemp2.substring(busq + 1, busq + 3);
                         if (hdicc.containsKey(codigo)) {
                              lineaok1 = lineaok1.substring(0, busq) + hdicc.get(codigo) +lineaok1.substring(busq + 3);
                              if (hdicc.get(codigo).equals(caracterEscape)) {
                                   lineatemp2 =lineatemp2.substring(0, busq) + " " + lineatemp2.substring(busq + 3);
                              } else {
                                   lineatemp2 = lineatemp2.substring(0, busq) + hdicc.get(codigo) + lineatemp2.substring(busq + 3);
                              }
                         } else {
                              lineatemp2 = lineatemp2.substring(0, busq) + " " + lineatemp2.substring(busq + 1);
                              faltan.add(codigo);
                         }
                         busq = lineatemp2.indexOf(caracterEscape);
                    }
                    pw.println(lineaok1);
                    linea = br.readLine();
                    lineatemp2 = linea;
                    lineaok1 = linea;
               }
               if (faltan.size() > 0) {
                    System.out.println(" \n ************ \nProcesando el fichero, se han encontrado " +faltan.size() + " codigos que no estaban en el diccionario :  ");
                    for (int i = 0; i < faltan.size(); i++) {
                         System.out.println(" - " + faltan.get(i));
                    }
                    System.out.println(" ************ \n  ");
               }
          }
          catch (Exception e) {
          } finally {
               try {
                    if (null != fichero)
                         fichero.close();
                    else 
                        System.out.println(" xxx Error al cerrar el fichero. ");
               } catch (Exception e2) {
                    System.out.println(" xxx Error al cerrar el fichero. ");
                    e2.printStackTrace();
               }
          }
     }
}