package integration;

import java.util.LinkedList;

import dto.FinalizedSalesLog;

public class Accounting {
	LinkedList<FinalizedSalesLog> recordedSalesLogs;
	/**
	 * initializes a new Accounting object
	 */
	public Accounting() {
		recordedSalesLogs = new LinkedList<FinalizedSalesLog>();
	}
	/**
	 * logs the final saleslog
	 * @param finalSalesLog log that describes the sale
	 */
	public void recordSalesLog(FinalizedSalesLog finalSalesLog) {
		recordedSalesLogs.add(finalSalesLog);
	}
}
