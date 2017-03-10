/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author student
 */
public class ConnectionFactory {
    
    private static ConnectionFactory connectionFactory;
    private BasicDataSource bds;
    
    

    
    
    private ConnectionFactory(){
        
        try {
            Properties dbproperties = new Properties();
            FileReader reader = null;
            
            File file = new File("settings/dbsettings.properties");
            
            reader = new FileReader(file);
            dbproperties.load(reader);
            
            
            bds = new BasicDataSource();
            
            bds.setUsername((String)dbproperties.getProperty("username"));
            bds.setPassword((String)dbproperties.getProperty("password"));
            System.out.println((String)dbproperties.getProperty("url"));
            bds.setUrl((String)dbproperties.getProperty("url"));
            bds.setDriverClassName((String)dbproperties.getProperty("driver"));
            
            bds.setInitialSize(10);
            bds.setMaxTotal(10);
            bds.setMaxIdle(10);
            bds.setMinIdle(10);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
    public static ConnectionFactory getInstance(){
        if (connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
        
    }
    
    public  Connection getConnection() throws Exception{
//        System.out.println("Success");
        return bds.getConnection();
    }
    
     
  
    
}
