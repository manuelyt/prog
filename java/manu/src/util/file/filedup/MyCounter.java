package util.file.filedup;

public class MyCounter {
  public String name;
  public int count;
  public MyCounter() {
  }
  public MyCounter(String name, int count) {
    this.name = name;
    this.count = count;
  }
  public void copy(MyCounter ext) {
    this.name = ext.name;
    this.count = ext.count;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
 
  
 
  
 