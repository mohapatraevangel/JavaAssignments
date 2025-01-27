package web;

import dao.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Use the service implementation
        CustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(new Customer(133, "john", "4 Elm St", "123-456-7890"));
        System.out.println(customerService.getCustomerById(6));

    }
}
