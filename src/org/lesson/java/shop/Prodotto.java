package org.lesson.java.shop;

public class Prodotto {
	int cod; // max 8 cifre
	String name;
	String description;
	double price;
	int iva = 22; // 22
	
	
	
	/** Constructor all variable
	 * @param cod
	 * @param name
	 * @param description
	 * @param price
	 * @param iva
	 */
	public Prodotto(int cod, String name, String description, double price, int iva) {
		this.cod = cod;
		this.name = name;
		this.description = description;
		this.price = price;
		this.iva = iva;
	}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prodotto productTest=new Prodotto(111,"asciugamario","può asciugare mario",10.5,22);
		
		System.out.println(productTest.name);
	}

}
