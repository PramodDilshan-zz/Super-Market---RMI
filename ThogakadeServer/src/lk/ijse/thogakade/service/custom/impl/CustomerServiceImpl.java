/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.CustomerBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.reservation.impl.Reservation;
import lk.ijse.thogakade.service.custom.CustomerService;

import lk.ijse.thogakade.service.SuperService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Dilshan
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    private CustomerBO customerBO;
    private static Reservation customerReservation = new Reservation();

    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public CustomerServiceImpl() throws Exception {
        try {
            customerBO = (CustomerBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.CUSTOMER);
        } catch (Exception ex) {

        }
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
            boolean result = customerBO.save(t);
            notifyAllObservers();
            return result;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        boolean result = customerBO.update(t);
        notifyAllObservers();
        return result;
    }

    @Override
    public boolean delete(String id) throws Exception {
        boolean result = customerBO.delete(id);
        notifyAllObservers();
        return result;
    }

    @Override
    public CustomerDTO getbyId(String id) throws Exception {
        return customerBO.getbyId(id);
    }

    @Override
    public ArrayList<CustomerDTO> get() throws Exception {
        return customerBO.get();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        alObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers() throws RemoteException {
        for (Observer alObserver : alObservers) {
            alObserver.update();
        }
    }
    @Override
    public boolean reserve(String id, SuperService superService) throws Exception {
        return customerReservation.reserve(id, this);
    }

    @Override
    public boolean release(String id) throws Exception {
        return customerReservation.release(id);
    }

    @Override
    public JasperPrint getOrderReport(String orderId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
