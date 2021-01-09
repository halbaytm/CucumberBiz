package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderPage {
    WebDriver driver = Driver.getDriver("browser");

    public OrderPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    public WebElement customerNameBox;

    @FindBy(name ="ctl00$MainContent$fmwOrder$TextBox2")
    public WebElement streetBox;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    public WebElement cityBox;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox4")
    public WebElement stateBox;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    public WebElement zipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement VisacardBox;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox6")
    public WebElement cardNumBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy (id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(tagName = "strong")
    public WebElement verifyOrderCreated;

    @FindBy(xpath = "//label[@for='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productLabel;

    @FindBy(xpath = "//label[@for='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantityLabel;

    @FindBy(xpath = "//label[@for='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    public WebElement pricePerUnitLabel;

    @FindBy(xpath = "//label[@for='ctl00_MainContent_fmwOrder_txtDiscount']")
    public WebElement discountLabel;

    @FindBy(xpath = "//label[@for='ctl00_MainContent_fmwOrder_txtTotal']")
    public WebElement totalLabel;
}
