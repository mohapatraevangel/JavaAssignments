package service;

import dao.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import exception.CustomerDaoException;
import exception.CustomerNotFoundException;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{

         CustomerDao customerDao = new CustomerDaoImpl();


        @Override
        public Customer addCustomer(Customer customer) {
            try {
                return customerDao.addCustomer(customer);
            }
            catch(CustomerDaoException e) {
                throw new CustomerNotFoundException(e.getMessage());
            }
        }

        @Override
        public Customer getCustomerById(int id) {
            try {
                return customerDao.getCustomerById(id);
            } catch (CustomerDaoException e) {
                throw new CustomerNotFoundException(e.getMessage());
            }
        }
    }
//    };
//    @Override
//    public void addCustomer(Customer customer) throws SQLException {
//
//    }
//
//    @Override
//    public Customer getCustomerById(int id) throws SQLException {
//        return null;
//    }
//}
