package com.sapient.calculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.bean.TranscationRecord;
import com.sapient.file.parser.CSVFileParser;
import com.sapient.file.parser.FileParser;
import com.sapient.file.parser.FileParserFactory;
import com.sapient.report.CSVFileGenerator;
import com.sapient.report.GenerateReport;

/**
 * 
 * @author MayuriJain
 *
 */
public class ProcessingFeeCalculatorTest {
	private static PSCalculator calculator;
	FileParser fileParser;
	List<BigDecimal> resultdata;

	@BeforeClass
	public static void initCalculator() {
		calculator = new PSCalculator();
	}

	@Before
	public void beforeEachTest() {
		String fileName = "Input-data.csv";//input.next();
		fileParser = new CSVFileParser(fileName);
		//result data
		resultdata = Arrays.asList(new BigDecimal(500), new BigDecimal(500), new BigDecimal(500), new BigDecimal(500), 
				new BigDecimal(500), new BigDecimal(500), new BigDecimal(50), new BigDecimal(50), new BigDecimal(100),
				new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(500), new BigDecimal(500), new BigDecimal(500),
				new BigDecimal(500), new BigDecimal(500), new BigDecimal(500), new BigDecimal(100), new BigDecimal(100));
	}

	
	@Test
	public void readRecordFromFileTest() throws IOException {
		List<TranscationRecord> resultList = fileParser.processFile();
		assertEquals(20, resultList.size());
	}

	
	@Test
	public void ReadFileException() {
		try {
		String fileName = "Input-data1.csv";// input.next();
		fileParser = FileParserFactory.getFileParser(fileName);
		} catch (Exception e) {
			assertEquals("Parse file failed",  e.getMessage());
		}
	}
	
	@Test
	public void calculateProcessingFee() throws IOException {
		List<TranscationRecord> transDataList =  fileParser.processFile();
		List<TranscationRecord> transResultDataList = calculator.calculate(transDataList);
		for (int i=0; i < transDataList.size(); i++) {
			assertEquals(resultdata.get(i), transResultDataList.get(i).getProcessingFee());
		}
	}
	
	@Test
	public void reportGenerateTest() throws IOException {
		List<TranscationRecord> transDataList =  fileParser.processFile();
		calculator.calculate(transDataList);
		GenerateReport generateReport = new CSVFileGenerator();
		boolean isFileGenerated = generateReport.generate(transDataList, "resultList.csv");
		assertTrue(isFileGenerated);
	}
	
}
