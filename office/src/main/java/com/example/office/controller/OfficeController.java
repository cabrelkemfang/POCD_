package com.example.office.controller;

import com.example.office.domain.Office;
import com.example.office.repository.OfficeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class OfficeController {

    @Autowired
    private OfficeRepository _officeRepo;

@RequestMapping(value= "save",method = RequestMethod.POST)
    public ResponseEntity<Office> SaveData(@RequestBody  Office office){

        if(office==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }else {
            Office value;
            value = _officeRepo.save(office);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)

    public ResponseEntity<List<Office>> All (){
    List <Office> office;
    office = _officeRepo.findAll();
    return new ResponseEntity<>(office,HttpStatus.OK);
    }
}
