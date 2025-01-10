import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    private static WebDriver driver;

    @FindBy(xpath = "//tr/td[4]")
    WebElement status;

    @FindBy(xpath = "//tr/td[2]")
    WebElement totalPrice;


    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String orderStatus() {
        String currentorderStatus = status.getText();
        return currentorderStatus;
    }

    public String totalPrice() {
        String currentTotalPrice = totalPrice.getText();
        return currentTotalPrice;
    }
}
