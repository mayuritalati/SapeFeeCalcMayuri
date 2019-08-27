package com.sapient.file.parser;
import java.io.IOException;
import java.util.List;

import com.sapient.bean.TranscationRecord;
/**
 * 
 * @author MayuriJain
 *
 */
public interface FileParser {

	List<TranscationRecord> processFile() throws IOException;

}
