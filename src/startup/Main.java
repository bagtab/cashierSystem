package startup;

import java.io.IOException;

import controller.Controller;
import view.View;

public class Main {
	public static void main(String[] args) {
		Controller contr = new Controller();
		View view = new View(contr);
		view.startNewSale();
		try {
			view.scanItems();
			view.checkForDiscount();
			view.PayForSale();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
