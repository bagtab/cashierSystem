package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;
/**
 * the main class used for the cashier to communicate with the program
 * @author Linus Johannisson
 *
 */
public class View {
	Controller contr;
	Display display;
	ChangeMachine changeMachine;
	public View(Controller contr) {
		this.contr = contr;
		display = new Display();
		changeMachine = new ChangeMachine();
	}
	
	/**
	 * starts a new sale
	 */
	public void startNewSale() {
		contr.startNewSale();
	}
	/**
	 * initializes the program for scanning items through the console.
	 * the input options are: scan #itemID#(example: "scan 0"), addMany #quantity#(example: "addMany 7")and done(example: "done")
	 * @throws IOException
	 */
	public void scanItems() throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = reader.readLine();
			if(executeInput(input)) {
				return;
			}
		}
	}
	/**
	 * executes the entered input for scanning items
	 * @param dividedInput
	 */
	private boolean executeInput(String input) {
		input = input.trim();
		String[] dividedInput = input.split("\\s+");
		if(dividedInput.length >2 ||dividedInput.length ==0) {
			//should be treated with error handling for next part
		}

		if(getCommand(dividedInput).equals("addMany")) {
			contr.scanManyItems(extractData(dividedInput));
		}
		if(getCommand(dividedInput).equals("scan")) {
			display.refresh(contr.scanItem(extractData(dividedInput)));
		}
		if(getCommand(dividedInput).equals("done")) {
			display.refreshTotal(-1.0);
			return true;
		}
		return false;
	}
	/**
	 * initializes the program for a customerID entered in the Console.
	 * @throws IOException
	 */
	public void checkForDiscount() throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		display.refreshTotal(contr.applyDiscount(input));
	}
	/**
	 * initializes the program for payment entered in the Console. the payment must be written with numbers
	 * @throws IOException
	 */
	public void PayForSale() throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		changeMachine.getChange(contr.payAndEndSale(Double.parseDouble(input)).getAmount());
	}
	/**
	 * extracts the data part of the input String array
	 * @param dividedInput
	 * @return the Data from dividedInput
	 */
	private int extractData(String[] dividedInput) {
		return Integer.parseInt(dividedInput[1]);
	}
	/**
	 * extracts the command part from the input String array
	 * @param dividedInput
	 * @return the command of the input
	 */
	private String getCommand(String[] dividedInput) {
		return dividedInput[0];
	}
}
