package com.mycompany;

import com.mycompany.crud.DeleteUser;
import com.mycompany.crud.UpdateUser;
import com.mycompany.crud.UserCrudOperation;

public class Main {

    public static void main(String[] args) {
        UserCrudOperation userCrudOperation = new UserCrudOperation();
	    //Create new user
        /*Integer rows = userCrudOperation.createUser();

        if(rows !=0 ){
            System.out.println("User added successfully!");
        }else{
            System.out.println("User cannot be added, try again later");
        }*/

        //Get all users
        userCrudOperation.getAllUsers();

        //Update existing user fullname and email
        /*UpdateUser updateUser = new UpdateUser();
        Integer rowsUpdated = updateUser.updateUser();

        if(rowsUpdated !=0 ){
            System.out.println("User updated successfully!");
        }else{
            System.out.println("User cannot be updated, try again later");
        }*/
        //Delete user with matching username
        /*DeleteUser deleteUser = new DeleteUser();
        Integer rowsUpdated = deleteUser.deleteUser();

        if(rowsUpdated !=0 ){
            System.out.println("User deleted successfully!");
        }else{
            System.out.println("User cannot be deleted, try again later");
        }*/
    }
}
