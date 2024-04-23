package util.txt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class QuitarSaltoLinea {
    public QuitarSaltoLinea() {
        super();
    }

    /*
     * Este programita lo hice para quitar los salto de linea de los ficheros de
     * texto.
     *
     * Por ejemplo, cuando se copia un fichero pdf a txt, al copiarlo, en el texto
     * txt aparecen los saltos de linea innecesarios. Usando este programita, se
     * eliminan esos saltos de linea.
     *
     *
     *
     * Esta hecho para ficheros utf-8, asi que antes de usarlo mejor convertilo a
     * utf-8 ( usando el notepad++ por ejemplo ).
     *
     * tiene un inconveniente : no se puede diferenciar un punto y aparte de un
     * punto y seguido si este va en el margen de posiciones en las que yo los quito
     */
    public static void main(String[] args) {
        String nficheror1 = "c:\\manu\\00basura\\1.txt";
        String nficheror2 = "c:\\manu\\00basura\\2.txt";
        String linea = "", chars = "", chars2 = "";
        boolean salto = false;
        BufferedReader br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror1), "utf-8"));
            fichero = new FileWriter(nficheror2);
            pw = new PrintWriter(fichero);
            while ((linea = br.readLine()) != null) {
                salto = false;
                chars = "";
                chars2 = "";
                int longi = linea.length();
                if (longi > 3) {
                    chars = linea.substring(longi - 2, longi);
                    chars2 = linea.substring(longi - 1, longi);
                }
                if (chars2.equals(".") || chars.equals(". ")) {
                } else if (longi > 45 & longi < 100)
                    salto = true;
                if (salto)
                    pw.print(linea + " ");
                else
                    pw.println(linea);
            }
            System.out.println(" El programa se ha ejecutado correctamente. ");
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
