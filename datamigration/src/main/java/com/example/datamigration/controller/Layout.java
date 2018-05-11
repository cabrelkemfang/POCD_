package com.example.datamigration.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

public class Layout {


        public static void buildOfficeTemplate(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
            worksheet.setColumnWidth(0, 5000);
            worksheet.setColumnWidth(1, 5000);
            worksheet.setColumnWidth(2, 5000);
            worksheet.setColumnWidth(3, 7000);
            worksheet.setColumnWidth(4, 7000);
            worksheet.setColumnWidth(5, 7000);
            worksheet.setColumnWidth(6, 7000);
            worksheet.setColumnWidth(7, 7000);

            Font font = worksheet.getWorkbook().createFont();
            //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
            // headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            headerCellStyle.setWrapText(true);
            headerCellStyle.setFont(font);
            // headerCellStyle.setBorderRight(CellStyle.BORDER_THICK);
             //headerCellStyle.setBorderBottom(CellStyle.BORDER_THICK);

            HSSFRow rowHeader = worksheet.createRow((short) startRowIndex);
            rowHeader.setHeight((short) 500);

            HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
            cell1.setCellValue("id");
            cell1.setCellStyle(headerCellStyle);

            HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
            cell2.setCellValue("FirstName");
            cell2.setCellStyle(headerCellStyle);

            HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
            cell3.setCellValue("LastName");
            cell3.setCellStyle(headerCellStyle);

            HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
            cell4.setCellValue("Phone");
            cell4.setCellStyle(headerCellStyle);

            HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
            cell5.setCellValue("Address ");
            cell5.setCellStyle(headerCellStyle);

            HSSFCell cell6 = rowHeader.createCell(startColIndex+5);
            cell6.setCellValue("Email ");
            cell6.setCellStyle(headerCellStyle);

            HSSFCell cell7= rowHeader.createCell(startColIndex+6);
            cell7.setCellValue("Password");
            cell7.setCellStyle(headerCellStyle);

        }

    }
