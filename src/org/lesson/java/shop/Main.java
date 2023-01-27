package org.lesson.java.shop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prodotto productTest = new Prodotto(10.0);
		System.out.print("prezzo base " + String.format("%.2f", productTest.price) + "€ --");
		System.out.println(" prezzo con iva " + String.format("%.2f", productTest.postIva(productTest.price)) + "€");
		System.out.println(productTest.generateFullName());
	}

}
