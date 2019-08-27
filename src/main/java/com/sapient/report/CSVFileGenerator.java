package com.sapient.report;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.sapient.bean.TranscationRecord;
/**
 * 
 * @author MayuriJain
 *
 */
public class CSVFileGenerator implements GenerateReport {

	private static final String SEMICOLON_SEPRATOR = ";";

	@Override
	public boolean generate(List<TranscationRecord> resultList, String fileName) {
		// FileWriter writer = null;
		try (FileWriter writer = new FileWriter(fileName)) {
			setHeaders(writer);
			Optional.ofNullable(resultList).ifPresent(list -> list.forEach(data -> {

				try {
					setValues(writer, data);
				} catch (IOException e) {
					System.out.println("writing data into file operation has failed" + e.getMessage());
				}
			}));

		} catch (IOException e) {
			System.out.println("Generate Report has failed: " + e.getMessage());
			return false;
		}
		return true;
	}

	private void setValues(FileWriter writer, TranscationRecord data) throws IOException {
		writer.append(data.getClientId());
		writer.append(SEMICOLON_SEPRATOR);
		writer.append(data.getTransactionType());
		writer.append(SEMICOLON_SEPRATOR);
		writer.append(data.getTransactionDate());
		writer.append(SEMICOLON_SEPRATOR);
		writer.append(data.getPriorityFlag());
		writer.append(SEMICOLON_SEPRATOR);
		writer.append(data.getProcessingFee().toString());
		writer.append('\n');

	}

	private void setHeaders(FileWriter writer) throws IOException {
		writer.append("Client Id");
		writer.append(SEMICOLON_SEPRATOR);
		writer.append("Transaction Type");
		writer.append(SEMICOLON_SEPRATOR);
		writer.append("Transaction Date");
		writer.append(SEMICOLON_SEPRATOR);
		writer.append("Priority");
		writer.append(SEMICOLON_SEPRATOR);
		writer.append("Processing Fee");
		writer.append('\n');
	}

}
