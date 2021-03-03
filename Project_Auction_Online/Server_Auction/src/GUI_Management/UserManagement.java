/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Management;

/**
 *
 * @author icydeath
 */
public class UserManagement {
    
    String username;
    String statement;

    public UserManagement(String name, String statement) {
        
        this.username = name;
        this.statement = statement;
       
    }

    
    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    
}
