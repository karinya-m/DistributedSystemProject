/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbwebservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import p2t0databasedemoproject.Account;
import p2t0databasedemoproject.RecordNotFoundException;
import java.util.*;

/**
 * DBWebService class contains method to get name from input ID
 * @author Karinya
 */
@WebService(serviceName = "DBWebService")
public class DBWebService {

    @WebMethod(operationName = "getName")
    
    /**
     * get name from the input ID number
     * @param id ID of the user
     * @return name of the user whose ID is entered.
     */
    public String getNameGivenID(@WebParam(name = "id") int id) {
        String result = null;
        try {
            //Built database connection and create Account
            Connection con =
                    DriverManager.getConnection("jdbc:derby://localhost:1527/Account", "karinya", "karinya");
            System.out.println("Built connection");
            Account personA = new Account();
            
            System.out.println("Built an account");
            personA.read(Integer.toString(id), con);
            
            //put name in the result
            result = personA.getCustomerName();
        } catch (SQLException sqle) {
            System.err.println("Exception caught in main:" + sqle);
        } catch (RecordNotFoundException e) {
            //put error msg in the result
            result = "Record Not Found";
        } finally {
            return result;
        }
    }
}
