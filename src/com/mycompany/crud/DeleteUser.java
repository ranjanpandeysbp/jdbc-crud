package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {

    public Integer deleteUser(){//find with username and then delete the user

        Connection connection = null;
        Integer rowUpdated = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user's username which you want to delete");
            String username = scanner.nextLine();

            connection = Configuration.createConnection();
            String deleteQuery = "DELETE FROM Users WHERE username = ?";
            PreparedStatement st = connection.prepareStatement(deleteQuery);

            st.setString(1, username);
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
