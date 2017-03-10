/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss.custom;

import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.SuperBO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.OrderdetailDTO;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Dilshan
 */
public interface OrderBO extends SuperBO<OrderDTO>{
    


    public boolean saveOrder(OrderDTO Odto, ArrayList<OrderdetailDTO> t) throws Exception;
    
    public JasperPrint getOrderReport(String orderId)throws Exception;
}
