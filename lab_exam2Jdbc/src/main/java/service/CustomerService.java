package service;

import dao.Customer;
import java.sql.SQLException;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer getCustomerById(int id);

}

