package com.sapient.report;
import java.util.List;

import com.sapient.bean.TranscationRecord;
/**
 * 
 * @author MayuriJain
 *
 */
public interface GenerateReport {

	boolean generate(List<TranscationRecord> resultList, String reportFileName);
}
