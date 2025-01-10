import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private static WebDriver driver;


    @FindBy(xpath = "//*[contains(text(), 'Proceed to checkout')]")
    WebElement checkout;


    public CartPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void checkoutClick() {
        checkout.click();
    }
}
