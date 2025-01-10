import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {

    private static WebDriver driver;

    @FindBy(xpath = "//section[@id='main']")
    WebElement toScreen;
    @FindBy(xpath = "//li[@id='order-reference-value']")
    WebElement orderNumber;
    @FindBy(xpath = "//tr[@class='total-value font-weight-bold']/td[2]")
    WebElement total;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public File screenShot() throws IOException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        File screenshot = toScreen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target\\screenshot.jpg"));

        js.executeScript("document.body.style.zoom = '100%'");
        return screenshot;
    }

    public String getOrderReference() {
        String orderReferenceText = orderNumber.getText();
        System.out.println(orderReferenceText);
        String[] parts = orderReferenceText.split("Order reference:");
        String currentOrderReference = " ";
        if (parts.length > 1) {
            String orderReference = parts[1];
            currentOrderReference = orderReference;
            System.out.println(currentOrderReference);

        }
        return currentOrderReference;
    }

    public String getTotalValue() {
        String totalValue = total.getText();
        System.out.println("total Value: " + totalValue);
        return totalValue;
    }


}
