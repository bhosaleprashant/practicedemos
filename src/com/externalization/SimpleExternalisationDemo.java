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
 * @author blr-lt-202
 * a) It is mandatory to have no-arg constructor
 * b) No need of having serialVerisonID
 * c) Does not save the state of class till the Object Class
 * d) Can control the reads and writes of a object. ( using readExternal and writeExternal ,
 * 	meaning for specific fields )
 */

class Addition implements Externalizable {
	public int a;
	public int b;
	public int sum;

	public Addition() {
		System.out.println("Inside Addition");
	}
	
	@Override
	public void readExternal(ObjectInput objInp) throws IOException,
			ClassNotFoundException {
		this.a = objInp.readInt();
		this.b = objInp.readInt();
		this.sum = objInp.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objOut) throws IOException {
		objOut.writeInt(a);
		objOut.writeInt(b);
		objOut.writeInt(sum);
	}
	
	public Addition(int a , int b) {
		this.a = a;
		this.b = b;
	}
	
	public void sum(){
		this.sum = this.a + this.b;
	}

	@Override
	public String toString() {
		return "Addition [a=" + this.a + ", b=" + this.b + ", sum=" + this.sum + "]";
	}
	
}

public class SimpleExternalisationDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Addition add = new Addition(3, 4);
		add.sum();
		
		System.out.println("Start");
		System.out.println("Serialization");
		System.out.println(add);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/Externalisation.ser"));
		oos.writeObject(add);
		oos.close();
		
		System.out.println("Deserialization");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/Externalisation.ser"));
		Addition add1 = (Addition) ois.readObject();
		System.out.println(add1);
		ois.close();
	}
}
