package com.fantasy.clash.cassandratrial.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fantasy.clash.cassandratrial.dos.CassDos;
import com.fantasy.clash.cassandratrial.service.CassandraService;



@RestController
public class CassandraController {
  
  @Autowired
  private CassandraService cassService;
  
  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addUser(@RequestBody CassDos cassDo,HttpServletRequest request){
    cassService.insert(cassDo);
  }
  
  @GetMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public void delUser(@RequestParam int age ,HttpServletRequest request){
    cassService.delete(age);
  }

  @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
  public void getUser(@RequestParam int age,HttpServletRequest request){
    cassService.select(age);
  }
}
