package com.sapient.file.parser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.sapient.bean.TranscationRecord;
/**
 * 
 * @author MayuriJain
 *
 */
public class CSVFileParser implements FileParser {

	private String filePath;

	public CSVFileParser(String file) {
		this.filePath = file;
	}

	public CSVFileParser() {
		super();
	}

	public List<TranscationRecord> processFile() throws IOException {
		List<TranscationRecord> inputList;
		try {
			inputList = Files.lines(Paths.get(filePath)).skip(1).map(line -> mapToItem(line)).filter(a -> a != null)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new IOException("Parse file failed");
		}
		return inputList;
	}

	private TranscationRecord mapToItem(String line) {
		TranscationRecord item = null;
		if (null != line && !line.trim().isEmpty()) {
			item = new TranscationRecord();
			String[] arrayStr = line.replaceAll("\"", "").split(";");//
			item.setExternalTransactionId(arrayStr[0]);
			item.setClientId(arrayStr[1]);
			item.setSecurityId(arrayStr[2]);
			item.setTransactionType(arrayStr[3]);
			item.setTransactionDate(arrayStr[4]);
			item.setMarketValue(arrayStr[5]);
			item.setPriorityFlag(arrayStr[6]);
		}
		return item;
	}

}
