package io.luchta.forma4j.writer.processor.poi;

import io.luchta.forma4j.writer.engine.model.book.XlsxBook;
import io.luchta.forma4j.writer.engine.model.cell.XlsxCell;
import io.luchta.forma4j.writer.engine.model.cell.style.XlsxCellStyle;
import io.luchta.forma4j.writer.engine.model.row.XlsxRow;
import io.luchta.forma4j.writer.engine.model.sheet.XlsxSheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookBuilder {
    XlsxBook model;

    public WorkbookBuilder(XlsxBook model) {
        this.model = model;
    }

    public Workbook build() {
        Workbook workbook = new XSSFWorkbook();
        for (XlsxSheet sheetModel : model.sheets()) {
            Sheet sheet = workbook.createSheet(sheetModel.name().toString());
            for (XlsxRow rowModel : sheetModel.rows()) {
                Row row = sheet.createRow(rowModel.rowNumber().toInt());
                for (XlsxCell cellModel : rowModel.cells()) {
                    Cell cell = row.createCell(cellModel.columnNumber().toInt());
                    cell.setCellValue(cellModel.value().toString());
                    if (cellModel.styles().size() != 0) {
                        cell.setCellStyle(createCellStyle(workbook, cellModel, cell));
                    }
                }
            }
        }
        return workbook;
    }
    
    private CellStyle createCellStyle(Workbook workbook, XlsxCell cellModel, Cell cell) {
    	CellStyle cellStyle = workbook.createCellStyle();
    	cellStyle.setFont(workbook.createFont());
    	cell.setCellStyle(cellStyle);
        for (XlsxCellStyle style : cellModel.styles()) {
        	cell = style.addCellStyle(cell);
        }
        return cellStyle;
    }
}
