package App.service;

import App.dao.Address.IAddressDAO;
import App.dao.DAOFactory;
import App.model.Address;
import App.model.Patient;

import java.util.List;

public class AdressService {
    private IAddressDAO adrDAO = DAOFactory.createAddressDAO();


    public List<Address> findAll() {
        return this.adrDAO.findAll();
    }
}
