package dao;

import exception.CustomerDaoException;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {



        // Add a customer to the database
        @Override
        public Customer addCustomer(Customer customer) {
            String query = "INSERT INTO customer (id, name, address, phone_number) VALUES (?, ?, ?, ?)";

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Set parameters for the query
                preparedStatement.setInt(1, customer.getId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getAddress());
                preparedStatement.setString(4, customer.getPhoneNumber());

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Customer added successfully.");
                } else {
                    System.out.println("Failed to add customer.");
                }
            } catch (SQLException e) {
                throw new CustomerDaoException("Error while adding customer: " + e.getMessage());
                 // Rethrow the exception for higher-level handling
            }

            return customer;
        }

        // Get a customer by ID
        @Override
        public Customer getCustomerById(int id) {
            String query = "SELECT * FROM customer WHERE id = ?";
            Customer customer = null;

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Set the ID parameter
                preparedStatement.setInt(1, id);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // If a result is found, create a Customer object
                if (resultSet.next()) {
                    int customerId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String phoneNumber = resultSet.getString("phone_number");

                    customer = new Customer(customerId, name, address, phoneNumber);
                }
            } catch (SQLException e) {
                throw new CustomerDaoException("Error while adding customer: " + e.getMessage());
            }

            return customer;
        }
    }


