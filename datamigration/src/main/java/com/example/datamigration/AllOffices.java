package com.example.datamigration;

import com.example.datamigration.domain.Office;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="office")
public interface AllOffices {

    @RequestMapping(value = "all", method = RequestMethod.GET)
    List<Office> All();

    @RequestMapping(value= "save",method = RequestMethod.POST)
     ResponseEntity<Office> SaveData(Office office);
}