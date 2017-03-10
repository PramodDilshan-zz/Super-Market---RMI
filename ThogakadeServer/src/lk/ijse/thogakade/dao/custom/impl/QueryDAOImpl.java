/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.QueryDAO;
import lk.ijse.thogakade.dto.SuperDTO;

/**
 *
 * @author student
 */
public class QueryDAOImpl implements QueryDAO{

    private Connection connection;
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }    

     @Override
    public Connection getConnection() throws Exception {
        return this.connection;
    }   

    
    
}
