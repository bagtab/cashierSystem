package integration;

import java.util.LinkedList;

import dto.FinalizedSalesLog;

public class Accounting {
	LinkedList<FinalizedSalesLog> recordedSalesLogs;
	public Accounting() {
		recordedSalesLogs = new LinkedList<FinalizedSalesLog>();
	}
	public void recordSalesLog(FinalizedSalesLog finalSalesLog) {
		// TODO Auto-generated method stub
		recordedSalesLogs.add(finalSalesLog);
	}

}
