package com.itbuzzpress.json.model;

public class Person {
String name;
String surname;
String address;
String city;

public Person() {
	
}
@Override
public String toString() {
	return "Person [name=" + name + ", surname=" + surname + ", address=" + address + ", city=" + city + "]";
}
public Person(String name, String surname, String address, String city){
	this.name=name;
	this.surname=surname;
	this.address= address;
	this.city=city;
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
}
