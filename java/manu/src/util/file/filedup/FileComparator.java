package util.file.filedup;

import java.util.Comparator;
public class FileComparator implements Comparator<MyFile> {
  /*
   * tuve que hacerme este comparador para ordenar los ficheros en usando
   * varios campos, uno detras de otro, en mi caso: path - name - date
   */
  public int compare(MyFile o1, MyFile o2) {
    int value1 = o1.path.compareTo(o2.path);
    if (value1 == 0) {
      int value2 = o1.name.compareTo(o2.name);
      if (value2 == 0) {
        return o1.date.compareTo(o2.date);
      } else {
        return value2;
      }
    }
    return value1;
  }
}
 
  
 
  
 