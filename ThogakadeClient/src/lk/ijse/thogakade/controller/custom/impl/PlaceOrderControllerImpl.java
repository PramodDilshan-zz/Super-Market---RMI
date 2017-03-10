/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.PlaceOrderController;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.OrderdetailDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author student
 */
public class PlaceOrderControllerImpl implements PlaceOrderController {

    private OrderService orderService;

    public PlaceOrderControllerImpl() throws Exception {
        orderService = (OrderService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        return orderService.save(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        return orderService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return orderService.delete(id);
    }

    @Override
    public OrderDTO getbyId(String id) throws Exception {
        return orderService.getbyId(id);
    }

    @Override
    public ArrayList<OrderDTO> get() throws Exception {
        return orderService.get();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        orderService.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        orderService.unregisterObserver(observer);
    }

    @Override
    public void notifyAllObservers() throws RemoteException {
        orderService.notifyAllObservers();
    }

    @Override
    public boolean saveOrder(OrderDTO orderDTO, ArrayList<OrderdetailDTO> orderdetailDTOs) throws Exception {
        System.out.println("Save Order Controler");
        return orderService.saveOrder(orderDTO, orderdetailDTOs);
    }

    @Override
    public boolean reserve(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
