// 95-702 Distributed Systems Project 2
// Account.java

package p2t0databasedemoproject;

/* Account.java */

     // Professional Java Server Programming J2EE Edition (modified)
     // A simple Account object - wraps a row in the Account table.

     import java.sql.Connection;
     import java.sql.PreparedStatement;
     import java.sql.ResultSet;
     import java.sql.SQLException;
     import java.sql.*;

    public class Account {

    private String accountID;
    private String customerName;
    private double amount;

    public String toString() {
        return "ID " + accountID + "\t" + "Name " + customerName + "\t" + "Amount " + amount ;
    }

    public String getAccountID() {
          return accountID;
    }

    public String getCustomerName() {
          return customerName;
    }

    public void setCustomerName(String c) {

          customerName = c;
    }

    public double getAmount() {

          return amount;
    }

    public void setAmount( double amt) {
          amount = amt;
    }

    public void create(String actID, String customerName, double amt, Connection con)
            throws SQLException, Exception {

        accountID = actID;
        this.customerName = customerName;
        this.amount = amt;

        PreparedStatement statement = null;

        try {
             

             statement = con.prepareStatement("Insert into app.AccountTable (accountID," +
                                                "CustomerName, Amount)"  +
                                                "Values ( ?,?,?)"); 
             statement.setString(1,accountID);
             statement.setString(2,customerName);
             statement.setDouble(3,amt);

            
             statement.executeUpdate();
        }

        catch(SQLException e) {
             System.out.println("Caught exception in create" + e);
             throw new Exception(e);
        }

        finally {
             if(statement != null) {
                 statement.close();

             }
        }
    }

    public void read(String accountID, Connection con) throws SQLException, RecordNotFoundException {

         PreparedStatement statement = null;

         try {

             statement = con.prepareStatement("Select customerName, amount FROM app.AccountTable"
                                              +" where accountID = ?");

             statement.setString(1,accountID);

             ResultSet result = statement.executeQuery();

             if(result.next()) {
                 this.accountID = accountID;
                 this.customerName = result.getString(1);
                 this.amount = result.getDouble(2);

             }
             else {
                 System.out.println("Could not read a record");
                 throw new RecordNotFoundException();
             }
         }
         finally {
                 if(statement != null) {
                     statement.close();
             }
         }
    }

    public void update(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
              statement = con.prepareStatement("Update app.accountTable set customername = ?," +
                                               "amount = ? where accountID = ?");

              statement.setString(1, customerName);
              statement.setDouble(2, amount);
              statement.setString(3,accountID);

              statement.executeUpdate();
        }
        finally {
              if(statement != null) {
                 statement.close();
              }
        }
    }


    public void delete(Connection con) throws SQLException {

       PreparedStatement statement = null;

       try {

           statement = con.prepareStatement("Delete from app.AccountTable Where AccountID = ?");
           statement.setString(1,accountID);
           int h = statement.executeUpdate();
           System.out.println("Tried to delete " + accountID + " Changed " + h + " records");
       }
       finally {
           if (statement != null) {
                statement.close();
           }
       }

   }

   public void delete(String accountID, Connection con) throws SQLException {

       PreparedStatement statement = null;

       try {

           statement = con.prepareStatement("Delete from app.AccountTable Where AccountID = ?");
           statement.setString(1,accountID);
           statement.executeUpdate();
       }
       finally {
           if (statement != null) {
                statement.close();
           }
       }

   }

   public static void main(String args[]) throws SQLException, RecordNotFoundException,
   ClassNotFoundException, Exception  {


               Class.forName("org.apache.derby.jdbc.ClientDriver");


               Connection con =
                   DriverManager.getConnection("jdbc:derby://localhost:1527/Account","karinya","karinya");

               System.out.println("Built connection");

               // Test code. After running once the database has data.
               // That's why a second execution throws an exception.

               Account personA = new Account();

               System.out.println("Built an account");


               personA.create("1","Mike McCarthy",100.0,con);
               System.out.println("Create complete");

               Account personB = new Account();
               personB.create("2","Sue Smith",45.00,con);

               System.out.println("Two Accounts constructed");

               ResultSetMetaData rsm = null;

               String answer = "";

               Statement s = con.createStatement();

               ResultSet rs = s.executeQuery("select  * from app.AccountTable");

               rsm = rs.getMetaData();

               try {

                   while(rs.next()) {

                      for(int col = 1; col <= rsm.getColumnCount(); col++)
                           answer += rs.getString(col);
                   }
                   con.close();
               }
               catch (SQLException sqle) {
                  System.err.println("Exception caught in main:" + sqle);
               }

               System.out.println(answer);
               con.close();

   }
}

