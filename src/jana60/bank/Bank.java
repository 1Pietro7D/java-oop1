package jana60.bank;

import java.util.Random;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.print("what your name -> ");
		String name = s.nextLine().toLowerCase().trim();
		Conto newConto = new Conto(name);
		newConto.userAccount = r.nextInt(999) + 1;

		String userChoise = "";
		int numberChoise = 0;
		while (!userChoise.equals("3") || !userChoise.equals("exit")) { // a differenza degli if interni non posso usare
																		// Integer.parseInt(userChoise) != 3
			while (userChoise.equals("")) {
				System.out.print("what do you want to do? 1-Add 2-Get 3-Exit -> ");
				userChoise = s.nextLine().toLowerCase().trim();
				try {
					numberChoise = Integer.parseInt(userChoise);
				} catch (NumberFormatException e) {
					numberChoise = 0;
				}
			}

			if (userChoise.equals("add") || numberChoise == 1) {
				System.out.println("how much do you want to deposit?");
				double money = Double.parseDouble(s.nextLine().replace(",", "."));
				double moneyCheck = Double.parseDouble(String.format("%.2f", money).replace(",", "."));// Refactoring!!
																										// funzione per
																										// checkMoney in
																										// classe Bank
				newConto.addCash(moneyCheck);
				System.out.println(newConto.userAccount + " now your total is :" + newConto.balance + "€");
				userChoise = "";
			} else if (userChoise.equals("get") || numberChoise == 2) {
				System.out.println("how much do you want to withdraw?");
				double money = Double.parseDouble(s.nextLine().replace(",", "."));
				double moneyCheck = Double.parseDouble(String.format("%.2f", money).replace(",", ".")); // Refactoring!!
																										// funzione per
																										// checkMoney in
																										// classe Bank
				boolean verify = newConto.takeCash(moneyCheck);
				if (!verify) {
					System.out.println("you cannot withdraw all this money");
				} else {
					System.out.println(newConto.userAccount + " now your total is :" + newConto.balance + "€");
					userChoise = "";
				}
			} else if (userChoise.equals("exit") || numberChoise == 3) {
				System.out.println(
						"Good by " + newConto.username.substring(0, 1).toUpperCase() + newConto.username.substring(1)); // Refactoring!!
																														// convertire
																														// adeguatamente
																														// il
																														// nome
																														// in
																														// classe
																														// Conto
				break;
			} else {
				System.out.println("your choice is invalid, please choose between 1 and 3");
				userChoise = "";
			}
		}
		;
		s.close();
	}

}
