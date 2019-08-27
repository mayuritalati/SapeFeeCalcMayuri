package com.sapient;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.sapient.bean.TranscationRecord;
import com.sapient.calculator.PSCalculator;
import com.sapient.file.parser.FileParser;
import com.sapient.file.parser.FileParserFactory;
import com.sapient.report.CSVFileGenerator;
import com.sapient.report.GenerateReport;
/**
 * 
 * @author MayuriJain
 *
 */
public class PSCalculatorMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter File Name(ex: c:/myfile/input-file.csv).");
		String fileName = input.next(); //"Input-data.csv";
		
		System.out.println("Enter Report File Name with file extension (ex: c:/myfile/report-file.csv).");
		String reportFileName = input.next(); //"output-data.csv";
		
		//check file type and get the parser object
		FileParser fileParser = FileParserFactory.getFileParser(fileName);
		List<TranscationRecord> trnsInputDataList = null;
		try {
			trnsInputDataList = fileParser.processFile();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		PSCalculator calculator = new PSCalculator();
		List<TranscationRecord> TrnsResultDataList =  calculator.calculate(trnsInputDataList);
		
		GenerateReport generateReport = new CSVFileGenerator();
		boolean file = generateReport.generate(TrnsResultDataList, reportFileName);
		if(file) { 
			System.out.println("Report generated successfully");} 
		else {
			System.out.println("Report generation failed. Please check logs for more details");
		}
	}
}
