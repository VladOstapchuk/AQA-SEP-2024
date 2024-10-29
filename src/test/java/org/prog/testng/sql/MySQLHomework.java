package org.prog.testng.sql;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

// TODO: Create table PHONES with columns: Product_Id (autoincrement, not null, unique), PhoneModel, PhonePrice
// TODO: Search for iPhone in allo UA
// TODO: Check if DB has this phone
// TODO: IF phone is NOT in DB >> Store phone model name and phone price >>  TEST PASSES!!
// TODO: IF phone IS in DB >> if price is different >> update price and fail test
public class MySQLHomework {

    @Test
      public void setUp() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement statement = connection.createStatement();
try {
//    statement.execute("ALTER TABLE PHONES ADD COLUMN Sku mediumint");
    statement.execute("ALTER TABLE PHONES DROP COLUMN Sku");
    System.out.println("Column Droped");
}
catch (SQLSyntaxErrorException e){
    System.out.println("Some error");
}


          connection.close();
    }
}
