import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ShopTest {
    private static WebDriver driver;


    // PARAMETERS
    String expectedLoggedUser = "Test Użytkownik";
    String product = "Hummingbird Printed Sweater";
    String expectedDiscountValue = "SAVE 20%";
    String size = "M";
    String quantity = "5";
    String expectedStatus = "Awaiting check payment";


    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\annac\\Documents\\IT\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl");

    }


    @Test
    public void buyingProduct() throws IOException {
        MainShopPage mainShopPage = new MainShopPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyStorePage myStorePage = new MyStorePage(driver);
        ProductPage productPage = new ProductPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        CartPage cartPage = new CartPage(driver);
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

        mainShopPage.signIn();
        loginPage.loginAs("abc@b.pl", "abcb1");

        String currentLoggedUser = loginPage.getLoggedUserName();
        Assert.assertEquals(expectedLoggedUser, currentLoggedUser);

        myStorePage.searchProduct(product);
        searchResultsPage.selectProduct();

        productPage.dicountIsCorrect();
        Assert.assertEquals(expectedDiscountValue, productPage.discountValue);

        productPage.selectSize(size);

        productPage.enterQuantity(quantity);

        productPage.addingToCart();
        cartPage.checkoutClick();
        cartPage.checkoutClick();
        personalInformationPage.confirmAddress();
        personalInformationPage.chooseShippingMetod();
        personalInformationPage.choosePaymentOption();
        orderConfirmationPage.screenShot();

        orderConfirmationPage.getOrderReference();
        String expectedTotalValue = orderConfirmationPage.getTotalValue();
        loginPage.LoggedUserNameClick();
        yourAccountPage.orderHistoryAndDetailsClick();


        String currentStatus = orderHistoryPage.orderStatus();
        Assert.assertEquals(expectedStatus, currentStatus);


        String currentTotalValue = orderHistoryPage.totalPrice();
        Assert.assertEquals(expectedTotalValue, currentTotalValue);


    }

    @After
    public void close() {
        MainShopPage mainShopPage = new MainShopPage(driver);
        mainShopPage.signOut();

        driver.quit();
    }


}
