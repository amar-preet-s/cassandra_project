package com.fantasy.clash.cassandratrial.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.datastax.driver.core.Session;
import com.fantasy.clash.framework.cassandra.CassandraConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class CassandraConfig {
  
  private static final Logger logger = LoggerFactory.getLogger(CassandraConfig.class);
  
  @Autowired
  private CassandraConfiguration cassandraConfiguration;
  private Session trialSession;
  
  @PostConstruct
  public void init() throws Exception {
    trialSession = cassandraConfiguration.getSession("amar");//alias is amar
  }
  
  
  @Bean("cassandraTrialSession")
  public Session getSession() {
    
      return trialSession;
  }
}
