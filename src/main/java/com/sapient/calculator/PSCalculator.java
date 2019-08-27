package com.sapient.calculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sapient.bean.Pair;
import com.sapient.bean.TranscationRecord;
import com.sapient.comarator.ReportComparator;
import com.sapient.util.CalculationUtil;
/**
 * 
 * @author MayuriJain
 *
 */
public class PSCalculator {

	public List<TranscationRecord> calculate(List<TranscationRecord> dataToProcess) {
		// calculate processing fee
		List<TranscationRecord> resultList = processAndCalculate(dataToProcess);
		// generate Report
		Collections.sort(resultList, new ReportComparator());
		return resultList;
	}

	private List<TranscationRecord> processAndCalculate(List<TranscationRecord> dataList) {
		List<TranscationRecord> resultList = new ArrayList<TranscationRecord>();
		Map<Pair, List<TranscationRecord>> resultDataMap = processDataBeforeCal(dataList);
		resultDataMap.forEach((k, v) -> {
			resultList.addAll(CalculationUtil.calculationIntraTrnsfee(v));
		});
		return resultList;
	}

	private Map<Pair, List<TranscationRecord>> processDataBeforeCal(List<TranscationRecord> dataList) {
		Map<Pair, List<TranscationRecord>> groupBydataMap = dataList.stream().collect(
				Collectors.groupingBy(t -> new Pair(t.getClientId(), t.getSecurityId(), t.getTransactionDate()),
						Collectors.mapping((TranscationRecord p) -> p, Collectors.toList())));
		return groupBydataMap;
	}

}
