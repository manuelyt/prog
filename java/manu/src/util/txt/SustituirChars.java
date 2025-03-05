package util.txt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

public class SustituirChars {
	public SustituirChars() {
		super();
	}

	/*
	 * Este programita me lo hice para cambiar los caracteres html de las urls.
	 * 
           uso 3 ficheros, uno de entrada, otro de salida y otro con el diccionario de los caracteres:
           
           
           
&lt;          ( < )
&gt;          ( > )
nbsp;         (   )
#187;         (   ) ( comillas anguladas de cierre ) ( » )
&amp;         ( & )

     
     
     
           el fichero de diccionario, tiene que tener este formato ( los codigos uno detras de otro y despues los caracteres ) :
           
           
&lt;
&gt;
nbsp;
#187;
&amp;
<
>
 
 
&




    */
	public static void main(String[] args) {
		String nficheror1 = "c:\\manu\\basura\\000\\1.txt";
		String nficheror2 = "c:\\manu\\basura\\000\\2.html";
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
			dicc = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror3), "utf-8"));
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
			br = new BufferedReader(new InputStreamReader(new FileInputStream(nficheror1), "utf-8"));
			linea = br.readLine();
			String lineaok1 = linea;
			String lineatemp2 = linea;
			while (linea != null) {
				for (int i = 0; i < longi / 2; i++) {
					String Sbusq = lista.get(i);
					int Sbusql = Sbusq.length();
					int busq = lineaok1.indexOf(Sbusq);
//					if (busq == -1) {
//						lineaok1 = linea;
//					}
					while (busq != -1) {
						lineaok1 = lineaok1.substring(0, busq) + hdicc.get(Sbusq) + lineaok1.substring(busq + Sbusql);
						busq = lineaok1.indexOf(Sbusq);
					}
				}
				pw.println(lineaok1);
				linea = br.readLine();
				lineatemp2 = linea;
				lineaok1 = linea;
			}
			if (faltan.size() > 0) {
				System.out.println(" \n ************ \nProcesando el fichero, se han encontrado " + faltan.size()
						+ " codigos que no estaban en el diccionario :  ");
				for (int i = 0; i < faltan.size(); i++) {
					System.out.println(" - " + faltan.get(i));
				}
				System.out.println(" ************ \n  ");
			}
		} catch (Exception e) {
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