package jana60.bank;

import java.util.Random;
import java.util.Scanner;

public class Conto {

	int userAccount;
	String username;
	double balance;

	public Conto(String username) {
		// TODO Auto-generated constructor stub
		this.balance = 0;
		this.username = username;

	}

	void addCash(double money) {
		this.balance += money;
	}

	boolean takeCash(double money) {
		if (money > this.balance) {
			return false;
		} else {
			this.balance -= money;
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.print("what your name -> ");
		String name = s.nextLine().toLowerCase().trim();
		Conto newConto = new Conto(name);
		newConto.userAccount = r.nextInt(999) + 1;

		String userChoise = "";
		while (userChoise != "3" || !userChoise.equals("exit")) {
			System.out.print("what do you want to do? 1-Add 2-Get 3-Exit -> ");
			userChoise = s.nextLine().toLowerCase().trim();
			System.out.println(userChoise);
			if (Integer.parseInt(userChoise) == 1 || userChoise.equals("add")) {
				System.out.println("how much do you want to deposit?");
				double money = Double.parseDouble(s.nextLine().replace(",", "."));
				double moneyCheck = Double.parseDouble(String.format("%.2f", money).replace(",", "."));
				newConto.addCash(moneyCheck);
				System.out.println("now your total is :" + newConto.balance);
			} else if (Integer.parseInt(userChoise) == 2 || userChoise.equals("get")) {
				System.out.println("how much do you want to withdraw?");
				double money = Double.parseDouble(s.nextLine().replace(",", "."));
				double moneyCheck = Double.parseDouble(String.format("%.2f", money).replace(",", "."));
				boolean verify = newConto.takeCash(moneyCheck);
				if (!verify) {
					System.out.println("you cannot withdraw all this money");
				} else 
					System.out.println("now your total is :" + newConto.balance);
			}else if(Integer.parseInt(userChoise) == 3 || userChoise.equals("exit")) 
			{System.out.println("Good by");
			}else {System.out.println("your choice is invalid, please choose between 1 and 3");}
		}
		;
		s.close();
	}
}

/*
 * Esercizio: Java Bank repo java-oop1 Oggi ci occupiamo di conti correnti.
 * Consegna Nel progetto java-oop-bank, package jana60.bank, creare la classe
 * Conto caratterizzata da: - numero di conto - nome del proprietario - saldo
 * Usate opportunamente i costruttori ed eventuali altri metodi di “utilità” per
 * fare in modo che: - alla creazione di un nuovo conto il saldo sia 0€ - siano
 * presenti un metodo per versare una somma di denaro sul conto e uno per
 * prelevare una somma di denaro dal conto (attenzione: il saldo non può mai
 * diventare negativo) - altri metodi per ritornare le informazioni del conto e
 * il saldo formattato Aggiungere una classe Bank con metodo main, dove
 * chiediamo all’utente il suo nome e generiamo un Conto intestato all’utente
 * con un numero di conto random (da 1 a 1000) Poi chiediamo all’utente cosa
 * vuole fare dando 3 opzioni: versare una somma o prelevare una somma di denaro
 * o uscire. Dopo la scelta dell’utente chiediamo quanti soldi vuole versare o
 * prelevare e proviamo ad effettuare l’operazione sul conto. Se l’operazione
 * non è valida mostriamo un messaggio di errore. Se l’operazione va a buon fine
 * mostriamo il saldo attuale del conto. Il menu continua ad apparire fino a che
 * l’utente sceglie di uscire.
 */