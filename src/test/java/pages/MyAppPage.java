package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyAppPage {

    WebDriver driver = Driver.getDriver("browser");

    public MyAppPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table//tbody[2]//tr[1]//td")
    public List<WebElement> row1Data;

    @FindBy(xpath = "//table//tbody[2]//tr[2]//td")
    public List<WebElement> row2Data;

    @FindBy(xpath = "//table//tbody[2]//tr[3]//td")
    public List<WebElement> row3Data;

    @FindBy(xpath = "//table//tbody[2]//tr[4]//td")
    public List<WebElement> row4Data;

    @FindBy(xpath = "//table//tbody[1]//th")
    public List<WebElement> columnNames;
}
