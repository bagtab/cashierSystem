package startup;

import java.io.IOException;

import controller.Controller;
import view.View;

public class Main {
	/**
	 * initializes the program and starts the loop of scanning items
	 * @param args not used, standardized input for main with console testing
	 */
	public static void main(String[] args) {
		Controller contr = new Controller();
		View view = new View(contr);
		try {
			while(true) {
				view.startNewSale();
				view.scanItems();
				view.checkForDiscount();
				view.PayForSale();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
