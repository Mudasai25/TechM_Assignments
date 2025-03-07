package com.setter.examples;
//an example of setter injection
//bean with setter and getter methods

public class Employee {
private int id;
private String name;
private String city;

//defining setters and getters
public int getId() {
	return id;
}

public void setId(int id) {
	this.id=id;
}

public String getName() {
   return name;
}
public void setName(String name) {
	this.name=name;
}

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city=city;
}

public void displayValues() {
	System.out.println(id + " " + name + " " + city);
  }
}