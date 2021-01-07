package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersLoginPage;
import utilities.CommonUtils;
import utilities.Driver;

public class WebOrdersAppSteps {

    WebDriver driver = Driver.getDriver("chrome");
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();

    @Given("User navigates to WebOrders application")
    public void user_navigates_to_web_orders_application() {
        driver.get(CommonUtils.getProperty("WebOrdersURL"));

    }

    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        webOrdersLoginPage.logIn(username, password);
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


}
