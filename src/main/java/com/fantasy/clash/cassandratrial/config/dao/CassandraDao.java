package com.fantasy.clash.cassandratrial.config.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.fantasy.clash.cassandratrial.dos.CassDos;

@Service
public class CassandraDao {
  
  
  @Autowired
  @Qualifier("cassandraTrialSession")
  private Session cassandraTrialSession;
  
  public void addData(CassDos cassDo) {
    PreparedStatement ps = cassandraTrialSession.prepare("insert into employee (age, id, Name) values (?,?,?)").setConsistencyLevel(ConsistencyLevel.LOCAL_ONE);
    BuiltStatement blt = QueryBuilder.insertInto("test_cassandra","employee").value("id", 1).value("name","amar");
    BoundStatement bnd = ps.bind(cassDo.getAge(),cassDo.getId(),cassDo.getName());
    cassandraTrialSession.execute(bnd);
  }
  
  public void deleteData(int age) {
    PreparedStatement ps = cassandraTrialSession.prepare("DELETE FROM employee WHERE age= ? IF EXISTS");
    BoundStatement bnd = ps.bind(age);
    cassandraTrialSession.execute(bnd);
  }
  
  public void selectData(int age) {
    PreparedStatement ps = cassandraTrialSession.prepare("select * from employee where age = ? Allow Filtering");
    BoundStatement bnd = ps.bind(age);
 
    ResultSet result = cassandraTrialSession.execute(bnd);
    List<Row> rows = result.all();
    int rowLen = rows.size();
    int rowIterator = 0;
    while(rowIterator< rowLen) {
      Row row = rows.get(rowIterator);
      System.out.println("Name: "+row.getString("name")+" ,age: "+row.getInt("age")+" ,id: "+row.getString("id"));
      rowIterator++;
    }
   }
}
