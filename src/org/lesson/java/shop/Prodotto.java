package org.lesson.java.shop;

import java.util.Random;

public class Prodotto {
	int cod; // max 8 cifre
	String name = "asciugamario";
	String description = "può asciugare mario";
	double price;
	int iva = 22; // 22

	/**
	 * Constructor all variable
	 * 
	 * @param name
	 * @param description
	 * @param price
	 * @param iva
	 */
	public Prodotto(double price) {
		Random rand = new Random();
		this.cod = rand.nextInt(100000000);
		this.price = price;
	}

	double postIva(double price) {
		double priceMoreIva = (100 + this.iva) * price / 100;
		return priceMoreIva;
	};

	String generateFullName() {
		String fullName = Integer.toString(cod) + "-" + name;
		return fullName;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prodotto productTest = new Prodotto(10.0);
		System.out.print("prezzo base " + String.format("%.2f", productTest.price) + "€ --");
		System.out.println(" prezzo con iva " + String.format("%.2f", productTest.postIva(productTest.price)) + "€");
		System.out.println(productTest.generateFullName());
	}

}
