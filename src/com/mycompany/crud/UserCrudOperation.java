package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserCrudOperation {

    public Integer createUser(){

        Connection connection = null;
        Integer rowUpdated = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username");
            String username = scanner.nextLine();

            System.out.println("Enter password");
            String password = scanner.nextLine();

            System.out.println("Enter fullname");
            String fullname = scanner.nextLine();

            System.out.println("Enter email");
            String email = scanner.nextLine();

            connection = Configuration.createConnection();
            String insertQuery = "INSERT INTO Users (username, password, fullname, email) VALUE(?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(insertQuery);

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, fullname);
            st.setString(4, email);

            rowUpdated = st.executeUpdate();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return rowUpdated;
    }

    public void getAllUsers(){

        Connection connection = null;

        try{
            connection = Configuration.createConnection();
            String allUserQuery = "SELECT * FROM Users";
            PreparedStatement st = connection.prepareStatement(allUserQuery);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Long userId = rs.getLong(1);
                String username = rs.getString(2);
                String password = rs.getString("password");
                String fullname = rs.getString(4);
                String email = rs.getString("email");

                String format = "User #%d: %s - %s - %s - %s";
                String formattedOutput = String.format(format, userId, username, password, fullname, email);

                System.out.println(formattedOutput);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
