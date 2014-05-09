/**
 * 
 */
package com.pedroalmir.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Pedro Almir
 * 
 */
public class PlotSolution {

	/**
	 * Write data in sheet
	 * 
	 * @param sheet
	 * @param lines
	 */
	public static void writeSheet(XSSFWorkbook workbook, XSSFSheet sheet, List<Object[]> lines) {
		int rownum = 0;
		int maxSize = 0;
		
		/* Style the cell with borders all around. */
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		
		for (Object[] line : lines) {
			if(line.length > maxSize){
				maxSize = line.length;
			}
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			for (Object obj : line) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				} else if (obj instanceof Float) {
					cell.setCellValue((Float) obj);
				} else if (obj instanceof Long) {
					cell.setCellValue((Long) obj);
				}
				cell.setCellStyle(style);
			}
		}
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 3));
		
		for(int i = 0; i < maxSize; i++){
			sheet.autoSizeColumn(i);
		}
	}

	/**
	 * @param workbook
	 * @param resultFolder
	 * @param fileName
	 */
	public static void writeWorkbook(XSSFWorkbook workbook, String resultFolder, String fileName) {
		try {
			/* Write the workbook in file system */
			FileOutputStream out = new FileOutputStream(new File(resultFolder + fileName));
			workbook.write(out);
			out.close();
			System.out.println(fileName + " written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
