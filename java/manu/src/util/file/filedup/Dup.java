package util.file.filedup;

/*
 * ============================================
 * 
 * funcionamiento de este programita
 * 
 * mira lo que hay en la variable path ( en Proc2 )
 *   String path = "C:\\manu\\00basura\\kk23\\";
 *   
 * procesa ese directorio y mira si hay archivos duplicados
 * en esa misma carpeta crea un fichero, fileOut.txt que muestra los resultados 
 * 
 * ============================================
 */

public class Dup {
  public static void main(String[] args) {
    Proc2 p = new Proc2();
    p.Exec2();
  }
}
 
  