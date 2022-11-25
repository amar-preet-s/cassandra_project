package com.fantasy.clash.cassandratrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(
//    basePackageClasses = {com.fantasy.clash.cassandratrial.controller.CassandraController.class,
//        com.fantasy.clash.cassandratrial.service.CassandraService.class,
//        com.fantasy.clash.cassandratrial.config.dao.CassandraDao.class,
//        com.fantasy.clash.cassandratrial.config.CassandraConfig.class,
//        com.fantasy.clash.framework.cassandra.CassandraConfiguration.class,
//        com.fantasy.clash.framework.configuration.Configurator.class})
@ComponentScan("com.fantasy.clash")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,CassandraAutoConfiguration.class})
public class CassandraTrialApplication {

  public static void main(String[] args) {
    SpringApplication.run(CassandraTrialApplication.class, args);
  }

}
