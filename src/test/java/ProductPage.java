import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public static WebDriver driver;
    String discountValue;


    @FindBy(xpath = "//div[@class='current-price']/span[2]")
    WebElement discount;
    @FindBy(xpath = "//select[@id='group_1']")
    WebElement selectSize;
    @FindBy(xpath = "//select[@id='group_1']/option[@title = 'S']")
    WebElement sizeS;
    @FindBy(xpath = "//select[@id='group_1']/option[@title = 'M']")
    WebElement sizeM;
    @FindBy(xpath = "//select[@id='group_1']/option[@title = 'X']")
    WebElement sizeX;
    @FindBy(xpath = "//select[@id='group_1']/option[@title = 'XL']")
    WebElement sizeXL;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantityInput;
    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    WebElement addToCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String dicountIsCorrect() {

        discountValue = discount.getText();
        return discountValue;
    }

    public void selectSize(String size) {
        selectSize.click();
        if (size == "S") {
            sizeS.click();
        } else if (size == "M") {
            sizeM.click();
        } else if (size == "X") {
            sizeX.click();
        } else if (size == "XL") {
            sizeXL.click();
        } else {
            System.out.println("Rozmiar niedostępny");

        }


    }

    public void enterQuantity(String quantity) {

        quantityInput.click();
        quantityInput.sendKeys(Keys.CONTROL + "a");
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(quantity);

    }

    public void addingToCart() {
        addToCart.click();
    }
}
