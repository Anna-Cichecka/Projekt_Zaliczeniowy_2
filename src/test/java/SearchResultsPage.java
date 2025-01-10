import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private static WebDriver driver;


    @FindBy(xpath = "//a[contains(text(), 'Hummingbird printed sweater')]")          // " + product + "
    WebElement sweater;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectProduct() {
        sweater.click();


    }
}
