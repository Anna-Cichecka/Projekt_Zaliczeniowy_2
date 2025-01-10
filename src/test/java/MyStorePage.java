import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage {
    private static WebDriver driver;


    @FindBy(xpath = "//a/img[@clas = 'logo']")
    WebElement myStore;

    @FindBy(xpath = "//input[@name = 's']")
    WebElement searchInput;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void myStoreClick() {
        myStore.click();
    }

    public void searchProduct(String product) {
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(product);
        searchInput.submit();
    }


}




