package com.sapient.file.parser;
/**
 * 
 * @author MayuriJain
 *
 */
public class FileParserFactory {

	public static FileParser getFileParser(String fileName) {
		FileParser fileParser = null;
		String[] tempArr = fileName.split("\\.");
		String fileType = tempArr[tempArr.length - 1].toUpperCase();
		switch (fileType) {
		case "CSV":
			fileParser = new CSVFileParser(fileName);
			break;
		case "XML":
			System.out.println("XML File Parser");
			break;

		default:
			System.out.println("Invalid File Type");
		}
		return fileParser;

	}
}
