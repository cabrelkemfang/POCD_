package com.example.datamigration.controller;

import com.example.datamigration.AllOffices;

import com.example.datamigration.domain.Office;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;



@RestController
public class DataMigrationController  {

    @Autowired
    private AllOffices _office;

    @RequestMapping(value = "/download", method = RequestMethod.GET)

    public void download( HttpServletResponse response, Model model) throws ClassNotFoundException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("Offices");

        int startRowIndex = 0;
        int startColIndex = 0;

        Layout.buildOfficeTemplate(worksheet, startRowIndex, startColIndex);

        response.setHeader("Content-Disposition", "inline; filename=office.xls");
        response.setContentType("application/vnd.ms-excel");

        try {
            // Retrieve the output stream
            ServletOutputStream outputStream = response.getOutputStream();
            // Write to the output stream
            worksheet.getWorkbook().write(outputStream);
            // Flush the stream
            outputStream.flush();
        } catch (Exception e) {
           System.out.println("Unable to write report to the output stream");
        }

    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ResponseEntity<String> FormUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.getContentType().equals("application/vnd.ms-excel")) {
            throw new MultipartException("Only excel files accepted!");
        } else {
            try{
                HSSFWorkbook offices = new HSSFWorkbook(file.getInputStream());
                HSSFSheet worksheet = offices.getSheetAt(0);
                HSSFRow entry;
                Integer noOfEntries=1;

                //getLastRowNum and getPhysicalNumberOfRows showing false values sometimes.
                while(worksheet.getRow(noOfEntries)!=null){
                    noOfEntries++;
                }
               // logger.info(noOfEntries.toString());
                for(int rowIndex=1;rowIndex<noOfEntries;rowIndex++){
                    entry=worksheet.getRow(rowIndex);

                    String firstName =entry.getCell(1).getStringCellValue();

                    String lastName =entry.getCell(2).getStringCellValue();


                    Integer phone=((Double)entry.getCell(3).getNumericCellValue()).intValue();

                    String address =entry.getCell(4).getStringCellValue();

                    String email =entry.getCell(5).getStringCellValue();

                    String password =entry.getCell(6).getStringCellValue();

System.out.println(" "+firstName+" "+lastName+" "+phone+" "+address+" "+email+" "+password);

             _office.SaveData(new Office(firstName,lastName,phone,address,email,password));

                }
            }catch(Exception e){
                System.out.println(e.getMessage()+" "+e.getCause());
                throw new MultipartException("Constraints Violated");
            }
            return new ResponseEntity<>("Upload successuly", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Office>> FeignAll(){

        return  new ResponseEntity<>(_office.All(),HttpStatus.OK);
    }



}
