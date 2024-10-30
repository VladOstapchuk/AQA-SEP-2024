package org.prog.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

public class BaseSQLTest {

   public WebDriver driver;
    private Connection connection;
    public Statement statement;
    private final static String DB_URL = "jdbc:mysql://localhost:3306/db";

    @BeforeSuite
   public void setUp() throws SQLException {
       ChromeOptions options = new ChromeOptions();
       driver = new ChromeDriver(options);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection =
                DriverManager.getConnection(DB_URL, "user", "password");
        statement = connection.createStatement();
   }


   @AfterSuite
   public void tearDown() throws SQLException {
       if (driver != null) {
           driver.quit();
           connection.close();
       }
   }



}
