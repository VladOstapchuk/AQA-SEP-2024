package org.prog.testng.homeworks.session9;

import org.prog.BasePage;
import org.prog.PageObject.AlloStartPage;
import org.prog.dto.AlloDto.AlloProduct;
import org.prog.testng.BaseSQLTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlloAndDB extends BaseSQLTest {
    private String mainURL = "https://allo.ua/";
    private final static String INSERT_QUERY =
            "insert into Phones (PhoneModel, PhonePrice, Sku) VALUES ('%s', '%s', '%s')";
    private final static String UPDATE_QUERY =
            "update Phones set PhonePrice = '%s' where PhoneModel = '%s'";


    @Test
    public void alloSecondTest() throws SQLException {

        new BasePage(driver).openURL(mainURL);

        List<AlloProduct> AlloProductList =
                new AlloStartPage(driver)
                        .CloseAdv()
                        .SearchForm("iphone 16")
                        .ClickSubmitButton()
                        .FirstResult();

        for (AlloProduct product : AlloProductList) {
            Assert.assertTrue(checkIsInDB(product));
            System.out.println(product);
        }
    }

    private void addToDB(AlloProduct product) throws SQLException {
        statement.execute(String.format(INSERT_QUERY,
                product.getProductName(),
                product.getActualPrice(),
                product.getSku()));
    }

    private void updateInDB(AlloProduct product) throws SQLException {
        statement.execute(String.format(UPDATE_QUERY,
                product.getActualPrice(),
                product.getProductName()));
    }

    private boolean checkIsInDB(AlloProduct product) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Phones");
        while (resultSet.next()) {
            if (resultSet.getString("PhoneModel").equals(product.getProductName())
                    &resultSet.getString("Sku").equals(product.getSku()))
            {
                if (resultSet.getString("PhonePrice").equals(product.getActualPrice())){
                    return true;
            }
                else
                    updateInDB(product);
                return false;
            }
        }
        addToDB(product);
        return true;
    }
}
