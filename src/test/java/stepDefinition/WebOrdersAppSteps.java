package stepDefinition;

import com.sun.tools.corba.se.idl.constExpr.Or;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import utilities.CommonUtils;
import utilities.Driver;
import utilities.ExcelUtils;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class WebOrdersAppSteps {

    WebDriver driver = Driver.getDriver("chrome");
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    OrderPage orderPage = new OrderPage();

    @Given("User navigates to WebOrders application")
    public void user_navigates_to_web_orders_application() {
        driver.get(CommonUtils.getProperty("WebOrdersURL"));

    }

    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        webOrdersLoginPage.logIn(CommonUtils.getProperty(username), CommonUtils.getProperty(password));
    }

    @Then("User validates that application {string} logged in")
    public void user_validates_that_application_logged_in(String condition) {
        if (condition.equalsIgnoreCase("is")) {
            String excpectedTitle = "Web Orders";
            String actualTitle = driver.getTitle();

            Assert.assertEquals("Actual Title: " + actualTitle + "" + "Didn`t match with expected Title: "
                    + excpectedTitle, excpectedTitle, actualTitle);

        }else if (condition.equalsIgnoreCase("is not")){
            String expectedErrorMessage = "Invalid Login or Password.";
            String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        }

    }
    @When("User click on Order part")
    public void user_click_on_order_part() {
        webOrdersHomePage.orderPart.click();
    }
    @When("User adds new order")
    public void user_adds_new_order(DataTable dataTable) {
        List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);
        orderPage.quantityBox.clear();
        orderPage.quantityBox.sendKeys(data.get(0).get("Quantity").toString());
        orderPage.customerNameBox.sendKeys(data.get(0).get("Customer name").toString());
        orderPage.streetBox.sendKeys(data.get(0).get("Street").toString());
        orderPage.cityBox.sendKeys(data.get(0).get("City").toString());
        orderPage.stateBox.sendKeys(data.get(0).get("State").toString());
        orderPage.zipBox.sendKeys(data.get(0).get("Zip").toString());
        orderPage.VisacardBox.click();
        orderPage.cardNumBox.sendKeys(data.get(0).get("Card Nr").toString());
        orderPage.expireDate.sendKeys(data.get(0).get("Expire Date").toString());

    }
    @Then("User click on Process button and validate {string} message")
    public void user_click_on_process_button_and_validate_message(String success) {
        orderPage.processButton.click();
        String actualMessagge = orderPage.verifyOrderCreated.getText();
        Assert.assertEquals(success, actualMessagge);


    }
    @When("User click View All Orders part")
    public void user_click_view_all_orders_part() {

        webOrdersHomePage.viewAllOrder.click();
    }

    @Then("User created order is added to list with data")
    public void user_created_order_is_added_to_list_with_data(DataTable dataTable) {
       List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);

        Assert.assertEquals(data.get(0).get("Customer name"),webOrdersHomePage.firstRowData.get(1).getText());
        Assert.assertEquals(data.get(0).get("Quantity"),webOrdersHomePage.firstRowData.get(3).getText());
        Assert.assertEquals(data.get(0).get("Street"),webOrdersHomePage.firstRowData.get(5).getText());
        Assert.assertEquals(data.get(0).get("City"),webOrdersHomePage.firstRowData.get(6).getText());
        Assert.assertEquals(data.get(0).get("State"),webOrdersHomePage.firstRowData.get(7).getText());
        Assert.assertEquals(data.get(0).get("Zip"),webOrdersHomePage.firstRowData.get(8).getText());
        Assert.assertEquals(data.get(0).get("Card Nr"),webOrdersHomePage.firstRowData.get(10).getText());
        Assert.assertEquals(data.get(0).get("Expire Date"),webOrdersHomePage.firstRowData.get(11).getText());

    }
    @Then("User validates UI headers with {string} excel file expected result")
    public void user_validates_ui_headers_with_excel_file_expected_result(String excelFile) {
        ExcelUtils.openExcelFile(excelFile, "Sheet1");
        String expectedResult = ExcelUtils.getValue(1, 4);
        System.out.println(expectedResult);
        String[] results=expectedResult.split("\n");


        Assert.assertEquals(results[1], orderPage.productLabel.getText());
        Assert.assertEquals(results[2], orderPage.quantityLabel.getText());
        Assert.assertEquals(results[3], orderPage.pricePerUnitLabel.getText());
        Assert.assertEquals(results[4], orderPage.discountLabel.getText());
        Assert.assertEquals(results[5], orderPage.totalLabel.getText());
    }
    @Then("User updates {string} with {string}")
    public void user_updates_with(String string, String string2) {

        ExcelUtils.setValue(1,6,string2);
    }




}
