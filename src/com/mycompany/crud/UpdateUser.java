package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUser {

    public Integer updateUser(){//find with username and then update fullname and email

        Connection connection = null;
        Integer rowUpdated = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user's username which you want to update");
            String username = scanner.nextLine();

            System.out.println("Enter new fullname");
            String fullname = scanner.nextLine();

            System.out.println("Enter new email");
            String email = scanner.nextLine();

            connection = Configuration.createConnection();
            String updateQuery = "UPDATE Users SET fullname = ?, email = ? WHERE username = ?";
            PreparedStatement st = connection.prepareStatement(updateQuery);

            st.setString(1, fullname);
            st.setString(2, email);
            st.setString(3, username);

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
}
