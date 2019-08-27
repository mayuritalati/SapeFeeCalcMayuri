package com.sapient.comarator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.sapient.bean.TranscationRecord;
/**
 * 
 * @author MayuriJain
 *
 */
public class ReportComparator implements Comparator<TranscationRecord>{

	@Override
	public int compare(TranscationRecord o1, TranscationRecord o2) {
		 DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return new CompareToBuilder()
			        .append(o1.getClientId(), o2.getClientId())
			        .append(o1.getTransactionType(), o2.getTransactionType())
			        .append(f.parse(o1.getTransactionDate()), f.parse(o2.getTransactionDate()))
			        .append(o1.getPriorityFlag(), o2.getPriorityFlag()).toComparison();
		} catch (ParseException e) {
			System.out.println("error occured while sorting: "+ e.getMessage());
		}
		return 0;
	}

}
