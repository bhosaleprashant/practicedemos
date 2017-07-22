package com.externalization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/**
 * @author Prashant
 * a) Mandatory to have no-arg constructor in both super as well as sub class.
 */
class College {
	public String colName;
	public String colAddress;
	public String deanName;

	public College() {
		System.out.println("I am in the college");
	}

	@Override
	public String toString() {
		return "College [colName=" + colName + ", colAddress=" + colAddress
				+ ", deanName=" + deanName + "]";
	}

}

class Student extends College implements Externalizable {

	public String studName;
	public String studAddress;
	public String studId;

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		super.colName = (String) in.readObject();
		super.colAddress = (String) in.readObject();
		this.studName = (String) in.readObject();
		this.studAddress = (String) in.readObject();
		this.studId = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(super.colName);
		out.writeObject(super.colAddress);
		out.writeObject(studName);
		out.writeObject(studAddress);
		out.writeObject(studId);
	}

	public Student(String name, String address, String id, String colName,
			String colAddress, String colProfName) {
		this.studName = name;
		this.studAddress = address;
		this.studId = id;
		super.colName = colName;
		super.colAddress = colAddress;
		super.deanName = colProfName;
	}

	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studAddress=" + studAddress
				+ ", studId=" + studId + ", colName=" + colName
				+ ", colAddress=" + colAddress + ", deanName=" + deanName + "]";
	}

	public Student() {
		System.out.println("I am a student");
	}
}

public class ExternalisationDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Start");
		System.out.println("Serialization");
		Student stud = new Student("Prashant", "Walchandnagar", "7", "SITS", "Pune", "Navale");
		System.out.println(stud);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/AdvExternalisation.ser"));
		oos.writeObject(stud);
		oos.close();
		
		System.out.println("Deserialization");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/AdvExternalisation.ser"));
		Student stud1 = (Student) ois.readObject();
		System.out.println(stud1);
		ois.close();
		
		
	}
}
