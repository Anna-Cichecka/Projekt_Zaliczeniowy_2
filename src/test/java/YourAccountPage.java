import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[@id='history-link']")
    WebElement orderHistoryAndDetails;


    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void orderHistoryAndDetailsClick() {
        orderHistoryAndDetails.click();
    }
}
