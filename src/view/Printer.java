package view;

import model.Receipt;
import java.awt.BorderLayout;
import javax.swing.*;

public class Printer {
	String textToPrint;

	public void print(Receipt receipt) {
		textToPrint = receipt.getText();
		printOut();
	}
/**
 * creates a visual representation of the printed receipt
 */
	private void printOut() {
		JFrame receipt = new JFrame("receipt");
		receipt.setLayout(new BorderLayout());
		receipt.setVisible(true);
		JTextArea field = new JTextArea(new String(textToPrint));
		field.setEditable(false);
		receipt.add(field, BorderLayout.NORTH);
		receipt.setSize(240, 400);	
	}
}
