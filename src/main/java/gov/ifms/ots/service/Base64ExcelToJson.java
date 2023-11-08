package gov.ifms.ots.service;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
@ApplicationScoped
public class Base64ExcelToJson {
    public JsonObject getExcelDataAsJsonObject(String base64Data) {
        System.out.println("base64Data==============>"+base64Data);
        JsonObject sheetsJsonObject = new JsonObject();
        Workbook workbook = null;
        byte[] decodedBytes = Base64.decodeBase64(base64Data);
        InputStream excelStream = new ByteArrayInputStream(decodedBytes);

        try {
          //  FileInputStream fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(excelStream);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            JsonArray sheetArray = new JsonArray();
            ArrayList<String> columnNames = new ArrayList<>();

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                JsonObject jsonObject = new JsonObject();

                if (currentRow.getRowNum() != 0) {
                    for (int j = 0; j < columnNames.size(); j++) {
                        Cell cell = currentRow.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    jsonObject.addProperty(columnNames.get(j), cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    jsonObject.addProperty(columnNames.get(j), cell.getNumericCellValue());
                                    break;
                                case BOOLEAN:
                                    jsonObject.addProperty(columnNames.get(j), cell.getBooleanCellValue());
                                    break;
                                case BLANK:
                                    jsonObject.addProperty(columnNames.get(j), "");
                                    break;
                                default:
                                    // Handle other cell types as needed
                            }
                        } else {
                            jsonObject.addProperty(columnNames.get(j), "");
                        }
                    }

                    sheetArray.add(jsonObject);
                } else {
                    // Store column names
                    for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
                        columnNames.add(currentRow.getCell(k).getStringCellValue());
                    }
                }
            }

            sheetsJsonObject.add(sheetName, sheetArray);
        }

        return sheetsJsonObject;
    }

}