package com.sapient.util;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.bean.TranscationRecord;
import com.sapient.constant.TransactionConstant;

/**
 * 
 * @author MayuriJain
 *
 */
public class CalculationUtil {

	static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("BUY", "SELL");
		map.put("DEPOSIT", "WITHDRAW");
		map.put("SELL", "BUY");
		map.put("WITHDRAW", "DEPOSIT");
	}

	public static List<TranscationRecord> calculationIntraTrnsfee(List<TranscationRecord> transDataList) {
		String type = "";
		int tempIndex = 0;
		BigDecimal processingFee = null;
		for (int i = 0; i < transDataList.size(); i++) {
			TranscationRecord t = transDataList.get(i);
			if (t.getTransactionType().equals(map.get(type))) {
				processingFee = new BigDecimal(10);
				transDataList.get(tempIndex).setProcessingFee(new BigDecimal(10));
				type = "";
			} else {
				if (t.getTransactionType().equals(TransactionConstant.BUY)
						|| t.getTransactionType().equals(TransactionConstant.DEPOSIT)) {
					processingFee = t.getPriorityFlag().equals("Y") ? new BigDecimal(500) : new BigDecimal(50);
				} else if (t.getTransactionType().equals(TransactionConstant.SELL)
						|| t.getTransactionType().equals(TransactionConstant.WITHDRAW)) {
					processingFee = t.getPriorityFlag().equals("Y") ? new BigDecimal(500) : new BigDecimal(100);
				}
				type = t.getTransactionType();
				tempIndex = i;
			}
			t.setProcessingFee(processingFee);
		}
		return transDataList;

	}

}
