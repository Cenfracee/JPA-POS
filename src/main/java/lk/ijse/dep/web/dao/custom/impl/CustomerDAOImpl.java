package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.CrudDAOImpl;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.entity.Customer;

import java.util.List;

public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

    @Override
    public List<Customer> searchCustomersByName(String name) throws Exception {
        return null;
    }
}
