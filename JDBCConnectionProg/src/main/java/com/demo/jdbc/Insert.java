package com.demo.jdbc;

import com.demo.factory.ConnectionFactory;
import java.sql.*;

public class Insert {

    public static void main(String[] args) {

        Connection connection=null;
        try {
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into emp(id, name, salary) values(?,?,?)");

            preparedStatement.setInt(1, 123);
            preparedStatement.setString(2,"pooja");
            preparedStatement.setInt(3,50000);

            int noOfRecordEffected= preparedStatement.executeUpdate();

            System.out.println(noOfRecordEffected);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
