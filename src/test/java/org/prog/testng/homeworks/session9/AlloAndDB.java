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
            "INSERT INTO PHONES (PhoneModel, PhonePrice, SKU) VALUES ('%s', '%s', '%s')";
    private final static String UPDATE_QUERY =
            "UPDATE PHONES set PhonePrice = '%s' where PhoneModel = '%s'";
    private final static String SELECT_ALL_QUERY =
            "SELECT * FROM PHONES";

    @Test
    public void alloSecondTest() throws SQLException {

        //ініциалізація драйвера та відкриття першої сторвнки виніс в клас BasePage
        new BasePage(driver).openURL(mainURL);

        //для сторінок создав класи PageObject
        //List зробив, щоб потім була можливість стігнути одразу всі товари зі сторінки
        List<AlloProduct> AlloProductList =
                new AlloStartPage(driver)
                        .CloseAdv()
                        .SearchForm("iphone 16")
                        .ClickSubmitButton()
                        .FirstResult();

        //перевіряю кожен продукт та виконую логіку теста
        for (AlloProduct product : AlloProductList) {
            Assert.assertTrue(checkIsInDB(product), "The price of the product has changed");
            System.out.println(product);
        }
    }

    //додаю товар у БД
    private void addToDB(AlloProduct product) throws SQLException {
        statement.execute(String.format(INSERT_QUERY,
                product.getProductName(),
                product.getActualPrice(),
                product.getSku()));
    }

    //оновлюю ціну товару
    private void updateInDB(AlloProduct product) throws SQLException {
        statement.execute(String.format(UPDATE_QUERY,
                product.getActualPrice(),
                product.getProductName()));
    }

    //метод перевірки товара згідно логіки тесту
    //якщо товара немає - записати в БД і повернути - > true
    //якщо това є і ціна без змін - > true
    //якщо товар є, а ціна в БД інше - > перезаписати ціну і повернути  - > false
    private boolean checkIsInDB(AlloProduct product) throws SQLException {
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);

        while (resultSet.next()) {
            if (resultSet.getString("PhoneModel").equals(product.getProductName())
                    & resultSet.getString("Sku").equals(product.getSku())) {
                if (resultSet.getString("PhonePrice").replace("₴", "").replace(" ", "")
                        .equals(product.getActualPrice())) {
                    return true;
                } else
                    updateInDB(product);
                return false;
            }
        }
        addToDB(product);
        return true;
    }
}
