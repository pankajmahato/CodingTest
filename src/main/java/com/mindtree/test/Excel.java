package com.mindtree.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\m1035984\\Desktop\\Test.xls"));
		// InputStream file = new
		// URL("http://datreports.pgsitecore.com/Quick-Sanity/Excel-Reports/M1033195/Home_Smoke_Brandsites_Test1495027799.99.xls")
		// .openStream();

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.iterator();
		System.out.println(sheet.getRow(2).getCell(2));
		// while (rowIterator.hasNext()) {
		// Row row = rowIterator.next();
		//
		// //For each row, iterate through each columns
		// Iterator<Cell> cellIterator = row.cellIterator();
		// while (cellIterator.hasNext()) {
		// Cell cell = cellIterator.next();
		//
		// switch (cell.getCellTypeEnum()) {
		// case BOOLEAN:
		// System.out.print(cell.getBooleanCellValue() + "\t\t");
		// break;
		// case NUMERIC:
		// System.out.print(cell.getNumericCellValue() + "\t\t");
		// break;
		// case STRING:
		// System.out.print(cell.getStringCellValue() + "\t\t");
		// break;
		// default:
		// break;
		// }
		// }
		// System.out.println("");
		// }
		int rowCount = sheet.getPhysicalNumberOfRows();
		Map<String, InstanceStatus> instances = new HashMap<>(rowCount);

		// Iterate through each rows from first sheet
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);

			boolean pass = row.getCell(2).getStringCellValue().equalsIgnoreCase("pass");

			InstanceStatus instanceStatus = instances.get(row.getCell(0).getStringCellValue());
			if (instanceStatus == null) {
				instanceStatus = new InstanceStatus(0, 0);
			}
			if (pass) {
				instanceStatus.setPassCount(instanceStatus.getPassCount() + 1);
			} else {
				instanceStatus.setFailCount(instanceStatus.getFailCount() + 1);
			}

			instances.put(row.getCell(0).getStringCellValue(), instanceStatus);

		}
		System.out.println(instances);
		file.close();
		workbook.close();
		// FileOutputStream out = new FileOutputStream(new
		// File("C:\\Users\\m1035984\\Desktop\\Test.xls"));
		// workbook.write(out);
		// out.close();
	}

}
