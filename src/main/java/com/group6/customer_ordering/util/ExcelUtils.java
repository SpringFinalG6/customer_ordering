package com.group6.customer_ordering.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.enums.Gender;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

    public static ByteArrayInputStream customersToExcel(List<Customers> customers) throws IOException {
        String[] COLUMNs = {"Username", "Phone", "Email", "Address", "Gender", "Created-By", "Updated_By"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){

            Sheet sheet = workbook.createSheet("Customers");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for (Customers customer : customers) {
                Row row = sheet.createRow(rowIdx++);

//                row.createCell(0).setCellValue(customer.getId());
                row.createCell(0).setCellValue(customer.getUsername());
                row.createCell(1).setCellValue(customer.getPhone());
                row.createCell(2).setCellValue(customer.getEmail());
                row.createCell(3).setCellValue(customer.getAddress());
                row.createCell(4).setCellValue(String.valueOf(customer.getGender()));
                row.createCell(5).setCellValue(customer.getCreatedBy());
                row.createCell(6).setCellValue(customer.getUpdatedBy());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static List<Customers> parseExcelFile(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet("Customers");
            Iterator<Row> rows = sheet.iterator();

            List<Customers> lstCustomers = new ArrayList<Customers>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if(rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Customers cust = new Customers();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if(cellIndex==0) {
                        cust.setUsername(currentCell.getStringCellValue());
                    } else if(cellIndex==1) {
                        cust.setPhone((int) currentCell.getNumericCellValue());
                    } else if(cellIndex==2) {
                        cust.setEmail(currentCell.getStringCellValue());
                    } else if(cellIndex==3) {
                        cust.setAddress(currentCell.getStringCellValue());
                    } else if(cellIndex==4) {
                        cust.setGender(Gender.valueOf(currentCell.getStringCellValue()));
                    } else if(cellIndex==5) {
                        cust.setCreatedBy(currentCell.getStringCellValue());
                    } else if(cellIndex==6) {
                        cust.setUpdatedBy(String.valueOf(currentCell.getDateCellValue()));
                    }

                    cellIndex++;
                }

                lstCustomers.add(cust);
            }

            // Close WorkBook
            workbook.close();

            return lstCustomers;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

}