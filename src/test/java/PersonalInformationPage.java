import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PersonalInformationPage {
    private static WebDriver driver;


    @FindBy(xpath = "//button[@name='confirm-addresses']")
    WebElement confirmAddress;
    @FindBy(xpath = "//input[@id='delivery_option_8']")
    WebElement shippingMethodRadio;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    WebElement confirmShippingMethod;
    @FindBy(xpath = "//input[@id='payment-option-1']")
    WebElement payment;
    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    WebElement agree;
    @FindBy(xpath = "//button[contains(text(), 'Place order')]")
    WebElement orderSubmit;


    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        confirmAddress.click();

    }

    public void chooseShippingMetod() {
        if (shippingMethodRadio.isSelected()) {
            confirmShippingMethod.click();
        } else {
            shippingMethodRadio.click();

            confirmShippingMethod.click();
        }
    }

    public void choosePaymentOption() {
        payment.click();
        agree.click();
        orderSubmit.click();
    }


}
