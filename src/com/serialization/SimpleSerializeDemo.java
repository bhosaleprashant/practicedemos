package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Prashant
 * Transient fields are never serialized.
 * During deserialization, transient fields get initialized to default values as per data types.
 * 
 * Role of "serialVersionUID" comes into picture during Deserialization.
 * If we "serialize a class" without serialVersionUID, modify the class and then try to deserialize the previously saved 
 * serialized object we get "Runtime Exception" with different version IDs.
 * 
 */

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String empname;
	private String empid;
	private String empcontact;
	public String getEmpcontact() {
		return empcontact;
	}
	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}

	private transient String empplace;
	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpplace() {
		return empplace;
	}
	public void setEmpplace(String empplace) {
		this.empplace = empplace;
	}
	
	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empid=" + empid
				+ ", empcontact=" + empcontact + ", empplace=" + empplace + "]";
	}
	
	
}

public class SimpleSerializeDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("Serialization");
		Employee e = new Employee();
		e.setEmpid("PC-578");
		e.setEmpname("Prashant");
		e.setEmpplace("Pune");
		e.setEmpcontact("9999999999");
		System.out.println(e);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/Emp.ser"));
		oos.writeObject(e);
		oos.close();
		
		System.out.println("Deserialization");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/Emp.ser"));
		Employee e1 = (Employee) ois.readObject();
		ois.close();
		System.out.println(e1);
	}

}
