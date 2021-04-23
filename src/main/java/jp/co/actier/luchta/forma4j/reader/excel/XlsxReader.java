package jp.co.actier.luchta.forma4j.reader.excel;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import jp.co.actier.luchta.forma4j.reader.config.element.Elements;
import jp.co.actier.luchta.forma4j.reader.excel.elementreader.XlsxElementReaderHelper;
import jp.co.actier.luchta.forma4j.reader.excel.process.CurrentColNumber;
import jp.co.actier.luchta.forma4j.reader.excel.process.CurrentRowNumber;
import jp.co.actier.luchta.forma4j.reader.excel.process.ProcessInfo;
import jp.co.actier.luchta.forma4j.reader.excel.process.ProcessInfoCollection;
import jp.co.actier.luchta.forma4j.databind.json.JsonNode;
import jp.co.actier.luchta.forma4j.databind.json.JsonObject;

public class XlsxReader {
	
	public JsonObject read(InputStream inputStream, Elements elements) throws EncryptedDocumentException, IOException {
        
        Workbook workbook = WorkbookFactory.create(inputStream);
		
		ProcessInfo xlsxReaderProcessInformation = new ProcessInfo(
				workbook,
				null,
				null,
				elements,
				new JsonObject(new JsonNode()),
				new CurrentRowNumber(0),
				new CurrentColNumber(0)
				);
		
		ProcessInfoCollection result = XlsxElementReaderHelper.read(xlsxReaderProcessInformation);
        return result.get(0).jsonObject();
    }
}