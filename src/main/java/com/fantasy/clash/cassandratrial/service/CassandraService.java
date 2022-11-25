package com.fantasy.clash.cassandratrial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fantasy.clash.cassandratrial.config.dao.CassandraDao;
import com.fantasy.clash.cassandratrial.dos.CassDos;

@Service
public class CassandraService {

  @Autowired
  private CassandraDao cassandraDao;

  public void insert(CassDos cassDo) {
    try {
       cassandraDao.addData(cassDo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void delete(int age){
    try {
      cassandraDao.deleteData(age);
   } catch (Exception e) {
     e.printStackTrace();
   }
  }
  
  public void select(int age){
    try {
      cassandraDao.selectData(age);
   } catch (Exception e) {
     System.out.println("error at service");
     e.printStackTrace();
   }
    

  }
}
