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
    
//    CqlOperations cqlOperations;
//    try {
//         sessionBean = new CqlSessionFactoryBean();
//         sessionBean.setContactPoints("127.0.0.1");
//         sessionBean.setKeyspaceName("test_cassandra");
//         sessionBean.setLocalDatacenter("datacenter1");
//         sessionBean.afterPropertiesSet();
//         CqlSession session = sessionBean.getObject();
//         
//        
//        PreparedStatement ps = session.prepare("select * from test_cassandra.employee where id = ? Allow Filtering");
//         BoundStatement bnd = ps.bind("00000");
//          
//          ResultSet result = session.execute(bnd);
//          List<Row> rows = result.all();
//          int rowLen = rows.size();
//          int rowIterator = 0;
//          while(rowIterator< rowLen) {
//            Row row = rows.get(rowIterator);
//            System.out.println("Name: "+row.getString("name")+" ,age: "+row.getInt("age")+" ,id: "+row.getString("id"));
//            rowIterator++;
//          }
//        
//        
////         CassandraOperations cassandraOps = new CassandraTemplate(session);
//         CassandraTemplate cassandraOps = new CassandraTemplate(session);
////         cqlOperations = cassandraOps.getCqlOperations();
//         cqlOperations = cassandraOps.getCqlOperations();
//         return cqlOperations;
//       } catch (Exception e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//       }
//    try {
//      
//      PoolingOptions poolingOptions = new PoolingOptions();
//      poolingOptions.setMaxConnectionsPerHost(HostDistance.LOCAL,
//          config.getInt("cassandra.maxConnectionPerHost.local", 200));
//      poolingOptions.setMaxConnectionsPerHost(HostDistance.REMOTE,
//          config.getInt("cassandra.maxConnectionPerHost.remote", 200));
//      
//      CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();
//      cassandraClusterFactoryBean.setContactPoints(config.getString("cassandra.host.ips"));
//      cassandraClusterFactoryBean.setPort(config.getInt("cassandra.port",9042));
//      cassandraClusterFactoryBean.setPoolingOptions(poolingOptions);
//     
//      QueryOptions queryOptions = new QueryOptions();
//      cassandraClusterFactoryBean.setQueryOptions(queryOptions.setFetchSize(config.getInt("cassandra.fetch.size",2000)));
//      
//      cassandraClusterFactoryBean.afterPropertiesSet();
//      
//      Cluster cluster = cassandraClusterFactoryBean.getObject();
//
//      Session session = cluster.connect(config.getString("cassandra.keyspaceName"));
//      PreparedStatement ps = session.prepare("select * from test_cassandra.employee where id = ? Allow Filtering");
//      BoundStatement bnd = ps.bind("00000");
//     
//       ResultSet result = session.execute(bnd);
//       List<Row> rows = result.all();
//       int rowLen = rows.size();
//       int rowIterator = 0;
//       while(rowIterator< rowLen) {
//         Row row = rows.get(rowIterator);
//         System.out.println("Name: "+row.getString("name")+" ,age: "+row.getInt("age")+" ,id: "+row.getString("id"));
//         rowIterator++;
//       }
//      
//    }catch(Exception e) {
//        logger.error("Some error occured",e);
//    }
//    Session session;
//    try {
//      
//      PoolingOptions poolingOptions = new PoolingOptions();
//      poolingOptions.setMaxConnectionsPerHost(HostDistance.LOCAL,200);
//      poolingOptions.setMaxConnectionsPerHost(HostDistance.REMOTE,200);
//      
//      CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();
//      cassandraClusterFactoryBean.setContactPoints("127.0.0.1");
//      cassandraClusterFactoryBean.setPort(9042);
//      cassandraClusterFactoryBean.setPoolingOptions(poolingOptions);
//     
//      QueryOptions queryOptions = new QueryOptions();
//      cassandraClusterFactoryBean.setQueryOptions(queryOptions.setFetchSize(2000));
////      cassandraClusterFactoryBean.setMetricsEnabled(false);
//      cassandraClusterFactoryBean.afterPropertiesSet();
//      
//      Cluster cluster = cassandraClusterFactoryBean.getObject();
//      session = cluster.connect("test_cassandra");
//      PreparedStatement ps = session.prepare("select * from test_cassandra.employee where id = ? Allow Filtering");
//      BoundStatement bnd = ps.bind("00000");
//     
//       ResultSet result = session.execute(bnd);
//       List<Row> rows = result.all();
//       int rowLen = rows.size();
//       int rowIterator = 0;
//       while(rowIterator< rowLen) {
//         Row row = rows.get(rowIterator);
//         System.out.println("Name: "+row.getString("name")+" ,age: "+row.getInt("age")+" ,id: "+row.getString("id"));
//         rowIterator++;
//       }
//       
//       return session;
//      
//    }catch(Exception e) {
//        logger.error("Some error occured",e);
//    }
//    
//    
//    return null;
// }
  }
}
