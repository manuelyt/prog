/*
 * ============================================
 * 
 * funcionamiento de este programita
 * 
 * mira lo que hay en la variable path ( unas lineas mas abajo )
 *   String path = "C:\\manu\\00basura\\kk23\\";
 *   
 * procesa ese directorio y mira si hay archivos duplicados
 * en esa misma carpeta crea un fichero, fileOut.txt que muestra los resultados 
 * 
 * ============================================
 * 
 * 
 * mejoras que se me ocurren :
 * 
 * - que funcione en linux tambien
 * - ??? añadir interface grafico
 */

package util.file.filedup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/*
 * Esta clase es para ver los ficheros en un disco que estan duplicados
 * 
 * uso un dir del msdos para sacar el listado
 * lo meto en un array list
 * y despues lo ordeno y miro los que se repiten
 */
public class Proc2 {
	String path = "C:\\manu\\00basura\\kk23\\";
	String fileCmd = "fileCmd.txt";
	String fileOut = "fileOut.txt";
	String strCmdDir = " Directorio de ";
	ArrayList<MyFile> flist = new ArrayList<MyFile>();
	ArrayList<MyFile> flistrepe = new ArrayList<MyFile>();
	ArrayList<String> extens = new ArrayList<String>();
	HashMap<String, Integer> extCount = new HashMap<String, Integer>();
	ArrayList<MyCounter> extCountl = new ArrayList<MyCounter>();
	HashMap<String, Integer> pathCount = new HashMap<String, Integer>();
	ArrayList<MyCounter> extCountByF = new ArrayList<MyCounter>();

	public Proc2() {
	}

	public void Exec() {
		// esto saca listado usando dir
		callcmd(path);
		importTree(path + fileCmd);
		proctree();
		System.out.print(" \n \n ____ \n \n");
	}

	public void Exec2() {
		System.out.print(" \n \n ____ \n \n");

		// esto usa el listado que yo he sacado antes

		// // callcmd(path);
		// importtree("c:\\manu\\1.txt");
		// getAllExtension();
		// proctree();

		// esto lee ficheros usando java, no cmd msdos
		importTree2(path);
		proctree();
		System.out.print(" \n \n ____ \n \n");
	}

	// aqui esta la llamada al dir de msdos que obtine el listado de ficheros
	public void callcmd(String path) {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"" + path + "\" && dir /s > " + fileCmd);
		builder.redirectErrorStream(true);
		try {
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.print(" \n \n ===== ===== \n - error in cmd dir command \n ===== ===== \n \n");
			e.printStackTrace();
		}
	}

	// meto los ficheros en un array list ( meto nombre, path, fecha y tamaño )
	public void importTree(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String st = "", pathTemp = "", sizeTemp = "", dateTemp = "";
			while ((st = br.readLine()) != null) {
				try {
					if (st.startsWith(strCmdDir)) {
						pathTemp = st.substring(15);
					} else if (st.substring(2, 3).equals("/")) {
						if (st.substring(21, 22).equals("<")) {
						} else {
							sizeTemp = st.substring(18, 35);
							dateTemp = st.substring(0, 17);
							MyFile fileTemp = new MyFile();
							fileTemp.setSize(Integer.parseInt(sizeTemp.replace(".", "").replace(" ", "")));
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm",
									Locale.ENGLISH);
							fileTemp.setDate(LocalDateTime.parse(dateTemp, formatter));
							fileTemp.setName(st.substring(36));
							fileTemp.setPath(pathTemp);
							flist.add(fileTemp);
						}
					}
				} catch (Exception e) {
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.print(" \n \n ===== ===== \n - error importing tree \n ===== ===== \n \n");
			e.printStackTrace();
		}
	}

	// meto los ficheros en un array list ( meto nombre, path, fecha y tamaño )
	public void importTree2(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				MyFile fileTemp = new MyFile();
				fileTemp.setSize(listOfFiles[i].length());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm", Locale.ENGLISH);
				fileTemp.setDate(new Date(listOfFiles[i].lastModified()).toInstant().atZone(ZoneId.systemDefault())
						.toLocalDateTime());
				fileTemp.setName(listOfFiles[i].getName());
				fileTemp.setPath(path);
				flist.add(fileTemp);
			} else if (listOfFiles[i].isDirectory()) {
				importTree2(listOfFiles[i].getPath().replace("\\", "\\\\"));
			}
		}
	}

	public void proctree() {
		flist.sort(Comparator.comparing(MyFile::getName));
		// writeFile("1a.txt");
		proc1();
	}

	public void proc1() {
		try {
			MyFile fileTemp = new MyFile();
			MyFile fileTemp2 = new MyFile("1", "1", 1, LocalDateTime.now());
			MyFile fileTemp3 = new MyFile("2", "1", 1, LocalDateTime.now());
			fileTemp = flist.get(0);
			for (int i = 1; i < flist.size(); i++) {
				String name = fileTemp.name;
				String ext = getExtension(name);
				// extensiones que se ignoran, o se procesan :
				// if (true) {
				if ((ext.equals("mp3") || ext.equals("m4v"))) {
					// si los nombres son iguales, es que esta duplicado, y lo
					// meto en mi array list de resultado
					// ??? habria que comprobar fecha y tamaño tambien ???
					if (fileTemp2.name.equals(fileTemp.name)) {
						// cuando un fichero esta muchas veces, la primera vez
						// se guardan en el listado de resultado los 2 primeros,
						// pero en las demas solo se guarda el actual
						if (!fileTemp3.name.equals(fileTemp.name)) {
							MyFile fileTemp4 = new MyFile();
							fileTemp4.copy(fileTemp2);
							flistrepe.add(fileTemp4);
						}
						MyFile fileTemp5 = new MyFile();
						fileTemp5.copy(fileTemp);
						flistrepe.add(fileTemp5);
					}
				}
				fileTemp3.copy(fileTemp2);
				fileTemp2.copy(fileTemp);
				fileTemp = flist.get(i);
			}
			PrintWriter writer2 = new PrintWriter(path + fileOut, "UTF-8");
			getAllExtension();
			writer2.println("\n\n\nestas son todas las extensiones : \n");
			for (int i = 0; i < extens.size(); i++) {
				writer2.print(extens.get(i) + " - ");
				if (i % 20 == 19)
					writer2.println("");
			}
			getCountByExt();
			MyCounter extTemp = new MyCounter();
			writer2.println("\n\n\n\n cuenta de repetidos por extension : \n");
			extCountl.sort(Comparator.comparing(MyCounter::getCount).reversed());
			for (int k = 0; k < extCountl.size(); k++) {
				extTemp = extCountl.get(k);
				writer2.println(" - " + extTemp.getName() + " - " + extTemp.getCount());
			}
			getCountByFolder();
			writer2.println("\n\n\n cuenta de repetidos por carpeta : \n");
			extCountByF.sort(Comparator.comparing(MyCounter::getCount).reversed());
			for (int k = 0; k < extCountByF.size(); k++) {
				extTemp = extCountByF.get(k);
				writer2.println(" - " + extTemp.getName().replace("\\\\", "\\") + " - " + extTemp.getCount());
			}
			writer2.println("\n\n\n listado de ficheros repetidos : \n");
			extTemp = new MyCounter();
			// flistrepe.sort(comp);
			MyFile fileTemp6 = new MyFile();
			fileTemp6.copy(fileTemp);
			for (int j = 0; j < flistrepe.size(); j++) {
				fileTemp6.copy(fileTemp);
				fileTemp = flistrepe.get(j);
				if (!fileTemp6.path.equals(fileTemp.path))
					writer2.println();
				writer2.println(" - " + fileTemp.getDate() + " - " + fileTemp.getSize() + " - " + fileTemp.getName()
						+ " - " + fileTemp.getPath().replace("\\\\", "\\"));
			}
			writer2.close();
		} catch (Exception e) {
			System.out.print(" \n \n ===== ===== \n - error writing proc1 file\n ===== ===== \n \n");
			e.printStackTrace();
		}
	}

	// esta funcioncita la puse mientras desarrollaba para ver los resultados
	// intermedios, pero no se utiliza, al final no la necesite
	public void writeFile(String name) {
		try {
			PrintWriter writer = new PrintWriter(path + name, "UTF-8");
			MyFile fileTemp = new MyFile();
			for (int i = 0; i < flist.size(); i++) {
				fileTemp = flist.get(i);
				writer.println(" - " + fileTemp.getDate() + " - " + fileTemp.getSize() + " - " + fileTemp.getName()
						+ " - " + fileTemp.getPath());
			}
			writer.close();
		} catch (Exception e) {
			System.out.print(" \n \n ===== ===== \n - error writing file\n ===== ===== \n \n");
			e.printStackTrace();
		}
	}

	public String getExtension(String name) {
		String out = "";
		int dot = name.indexOf(".");
		while (name.indexOf(".", dot + 1) != -1)
			dot = name.indexOf(".", dot + 1);
		if (dot != -1)
			out = name.substring(dot + 1, name.length());
		return out.toLowerCase();
	}

	public void getAllExtension() {
		MyFile fileTemp = new MyFile();
		for (int i = 0; i < flist.size(); i++) {
			fileTemp = flist.get(i);
			String name = fileTemp.name;
			String ext = getExtension(name);
			if (!extens.contains(ext))
				extens.add(ext);
		}
	}

//  public void writeAllExt() {
//    try {
//      PrintWriter writer = new PrintWriter(path + "file-ext.txt", "UTF-8");
//      for (int i = 0; i < extens.size(); i++) {
//        writer.print(extens.get(i) + " - ");
//        if (i % 20 == 19)
//          writer.println("");
//      }
//      writer.close();
//    } catch (Exception e) {
//      System.out.print(" \n \n ===== ===== \n - error writing extensions file\n ===== ===== \n \n");
//      e.printStackTrace();
//    }
//  }
	public void getCountByExt() {
		MyFile fileTemp = new MyFile();
		MyCounter extTemp = new MyCounter();
		for (int i = 0; i < flistrepe.size(); i++) {
			fileTemp = flistrepe.get(i);
			String extLoop = getExtension(fileTemp.name);
			if (!extCount.containsKey(extLoop))
				extCount.put(extLoop, 0);
			else
				extCount.replace(extLoop, extCount.get(extLoop) + 1);
		}
		Iterator it = extCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			extCountl.add(new MyCounter((String) pair.getKey(), (int) pair.getValue()));
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

	public void getCountByFolder() {
		MyFile fileTemp = new MyFile();
		MyCounter extTemp = new MyCounter();
		for (int i = 0; i < flistrepe.size(); i++) {
			fileTemp = flistrepe.get(i);
			String pathLoop = fileTemp.path;
			if (!pathCount.containsKey(pathLoop))
				pathCount.put(pathLoop, 0);
			else
				pathCount.replace(pathLoop, pathCount.get(pathLoop) + 1);
		}
		Iterator it = pathCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			extCountByF.add(new MyCounter((String) pair.getKey(), (int) pair.getValue()));
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
}
