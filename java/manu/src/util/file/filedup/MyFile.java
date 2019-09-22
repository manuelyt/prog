package util.file.filedup;

import java.time.LocalDateTime;
public class MyFile {
  public String name;
  public String path;
  public long size;
  public LocalDateTime date;
  public MyFile() {
  }
  public MyFile(String name, String path, long size, LocalDateTime date) {
    this.name = name;
    this.path = path;
    this.date = date;
    this.size = size;
  }
  public void copy(MyFile file) {
    this.name = file.name;
    this.path = file.path;
    this.date = file.date;
    this.size = file.size;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }
  public LocalDateTime getDate() {
    return date;
  }
  public void setDate(LocalDateTime date) {
    this.date = date;
  }
  public long getSize() {
    return size;
  }
  public void setSize(long size) {
    this.size = size;
  }
}
 
  
 
  
 
  