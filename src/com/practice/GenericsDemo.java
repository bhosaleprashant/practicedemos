package com.practice;



public class GenericsDemo <T,T1>{
	private T id;
	private T1 name;
	
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public T1 getName() {
		return name;
	}

	public void setName(T1 name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "GenericsDemo [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		GenericsDemo<Integer, String> gd = new GenericsDemo<>();
		gd.setId(13);
		gd.setName("Prashant");
		System.out.println(gd);
		
		GenericsDemo<Object,Object> gd1 = new GenericsDemo<>();
		gd1.setId(14);
		gd1.setName("Prashant12");
		System.out.println(gd1);
	}

}
