package util.java.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Class2 {

	public Class2() {
		super();
		method1();
	}

	public void method1() {
		List<Class3> list = new ArrayList<>();
		Class3 xxx3 = new Class3(1,1);
		int i=0;
		while(i<3) {
			list.add(xxx3);
			i++;
			xxx3.setId(i);
			xxx3.setName(i);
		}
		System.out.println(list);
	}

public class Class3 implements Serializable{
int id;
int name;
public Class3(int id, int name) {
	super();
	this.id = id;
	this.name = name;
}
public Class3() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getName() {
	return name;
}
public void setName(int name) {
	this.name = name;
}
@Override
public String toString() {
	return " - id : " + id + " , name: " + name + " . ";	
}
}	
	
}
