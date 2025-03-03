package com.demo.jdbc;

import com.demo.factory.ConnectionFactory;

import java.sql.*;

public class G_InsertGettingAutoGenKey {
    public static void main(String[] args) {

        Connection connection=null;
        try {
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into emp(name, salary) values(?,?)",
                            Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,"indu");
            preparedStatement.setInt(2,90000);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                System.out.println(rs.getInt(1));

            }

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
