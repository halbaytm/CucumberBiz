package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.CommonUtils;
import utilities.Driver;

import java.util.List;

public class EtsySteps {

    WebDriver driver = Driver.getDriver("browser");
    EtsyHomePage etsyHomePage = new EtsyHomePage();


    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
        driver.get(CommonUtils.getProperty("EtsyURL"));

    }

    @When("User click on {string} part")
    public void user_click_on_part(String department) {

        if (department.equals("Post-Holiday Sales"))
            etsyHomePage.postHoliday.click();
        else if (department.equals("Jewelry & Accessories"))
            etsyHomePage.jewelryDep.click();
        else if (department.equals("Clothing & Shoes"))
            etsyHomePage.clothingDep.click();
        else if (department.equals("Home & Living"))
            etsyHomePage.homeDep.click();
        else if (department.equals("Wedding & Party"))
            etsyHomePage.weddingDep.click();
        else if (department.equals("Toys & Entertainment"))
            etsyHomePage.toysDep.click();
        else if (department.equals("Art & Collectibles"))
            etsyHomePage.artDep.click();
        else if (department.equals("Craft Supplies"))
            etsyHomePage.craftSup.click();
        else if (department.equals("Gifts"))
            etsyHomePage.giftCards.click();

    }



    @Then("User validates {string} title")
    public void user_validates_title(String string) {
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//    }

//    @When("User searches for {string}")
//    public void user_searches_for(String item) {
//        etsyHomePage.searchBox.sendKeys(item + Keys.ENTER);
//
//    }
//
//    @Then("User validates the result contains")
//    public void user_validates_the_result_contains(DataTable dataTable) {
//        List<String> items = dataTable.asList();
//        for (WebElement element : etsyHomePage.items) {
//            String itemName = element.getText();
//            boolean isFound = false;
//            for (String item : items) {
//                if (itemName.toLowerCase().contains(item)) {
//                    isFound = true;
//
//                }
//            }
//            Assert.assertTrue(itemName, isFound);
//        }
//
//
//    }
//
//    @When("User select over ${int} option")
//    public void user_select_over_$_option(Integer int1) throws InterruptedException {
//
//        try {
//            etsyHomePage.filtersButton.click();
//        } catch (Exception e) {
//            System.out.println("filter buton not htere..");
//        }
//
//        etsyHomePage.radioButton.click();
//        Thread.sleep(3000);
//    }
//
//
//    @Then("User validates that all prices are over {int}")
//    public void user_validates_that_all_prices_are_over(Integer int1) {
//        for(WebElement element: etsyHomePage.prices){
//            String price = element.getText(); //1,010.50
//            price = price.replace(",","");
//            double priceInDouble = Double.parseDouble(price);
//            Assert.assertTrue(priceInDouble>int1);
//
//        }
//
//    }


    }
}