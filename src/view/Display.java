package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import dto.QuantifiedItemDTO;
import dto.UpdateDTO;
/**
 * a display that shows the customer the latest added item and the current total
 * @author Linus Johannisson
 */
public class Display {
	private JFrame display;
	private String displayedText;
	private UpdateDTO lastUpdate;
	private JTextArea textField;

	public Display() {
		display = new JFrame("customerDisplay");
		displayedText = "välkommen!";
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setLayout(new BorderLayout());
		display.setVisible(true);
		textField = new JTextArea(displayedText);
		display.add(textField, BorderLayout.NORTH);
		display.setSize(240, 100);
	}
	/**
	 * updates the display with the latest addied item and new cost
	 * */
	public void refresh(UpdateDTO updateInfo) {
		resetDisplayText();
		showItem(updateInfo.getItem());
		generateTotal(updateInfo);
		lastUpdate = updateInfo;
		dispay();
	}

	/**
	 * puts the displayedText in the textField
	 */
	private void dispay() {
		textField.setText(displayedText);
	}
	/**
	 * displays the Total in the display, if total <0, display the last total
	 * @param total
	 */
	public void refreshTotal(Double total) {
		resetDisplayText();
		if (total < 0) {
			generateTotal(lastUpdate);
		} else {
			generateTotal(new UpdateDTO(null, total, 0));
		}
		dispay();
	}

	/**
	 * empties the displayedText
	 */
	private void resetDisplayText() {
		displayedText = "";
	}
	/**
	 * adds the itemToDisplay to the displayedText
	 * @param itemToDisplay
	 */
	private void showItem(QuantifiedItemDTO itemToDisplay) {
		addText(itemToDisplay.getDescription() + addSpaces(25 - itemToDisplay.getDescription().length())
				+ itemToDisplay.getPrice() * itemToDisplay.getQuantity());
		if (itemToDisplay.getQuantity() > 1) {
			generateQuantity(itemToDisplay);
		}
	}
	/**
	 * adds the quantity of itemToDisplay to the displayed text
	 * @param itemToDisplay
	 */
	private void generateQuantity(QuantifiedItemDTO itemToDisplay) {
		addText(itemToDisplay.getQuantity() + " st x " + roundOf(itemToDisplay.getPrice()));
	}

	/**
	 * adds the total to the displayed text
	 * @param updateInfo
	 */
	private void generateTotal(UpdateDTO updateInfo) {
		addText("total" + addSpaces(20) + roundOf(updateInfo.getCost()));
	}
	/**
	 * appends addedText to displayedText
	 * @param addedText
	 */
	private void addText(String addedText) {
		displayedText += addedText + System.lineSeparator();
	}
	/**
	 * generats string with amountOfspaces number of spaces
	 * @param amountOfSpaces
	 * @return a string with spaces
	 */
	private String addSpaces(int amountOfSpaces) {
		String spaces = "";
		while (amountOfSpaces > 0) {
			spaces += ' ';
			amountOfSpaces--;
		}
		return spaces;
	}
/**
 * rounds of val to 2 decimals
 * @param val vaule to be rounded off
 * @return rounded version of val
 */
	private double roundOf(double val) {
		return (Math.round(100*val))/100;
	}
}
