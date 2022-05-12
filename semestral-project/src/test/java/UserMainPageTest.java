import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

public class UserMainPageTest extends TestCase {
    private WebDriver driver;
    private UserMainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        mainPage = new UserMainPage(driver);
    }


    @Test
    public void addItemToShoppingCartContinueShopping_ItemIsUnavailable() {
        Assertions.assertTrue(
                mainPage.clickOn("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .clickOn("//*[@id=\"content\"]/div[3]/div[1]/a")
                        .clickOn("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .isPresentOnPage("//*[@id=\"checkout-cart\"]/div[1]"));
    }

    @ParameterizedTest
    @CsvSource({"HP LP3065, 1111, Sweden, Blekinge, 10000, rIDAEdYsc4"})
    public void addItemToShoppingCartUseCouponCountEstimateShippingUseCertificateGoToCheckout_ItemIsAvailable
            (String itemName, String couponCode, String state,
             String region, String postalCode, String voucherNum) {
        Assertions.assertTrue(
                mainPage.fillTextArea("//*[@id=\"search\"]/input", itemName)
                        .clickOn("//*[@id=\"search\"]/span/button")
                        .clickOn("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .clickOn("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
                        .fillTextArea("//*[@id=\"input-coupon\"]", couponCode)
                        .clickOn("//*[@id=\"button-coupon\"]")
                        .clickOn("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
                        .chooseInSlidingArea("//*[@id=\"input-country\"]", state)
                        .chooseInSlidingArea("//*[@id=\"input-zone\"]", region)
                        .fillTextArea("//*[@id=\"input-postcode\"]", postalCode)
                        .clickOn("//*[@id=\"button-quote\"]")
                        .clickOnShowingUpWindow("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
                        .clickOn("//*[@id=\"modal-shipping\"]/div/div/div[3]/button")
                        .clickOn("//*[@id=\"accordion\"]/div[3]/div[1]/h4/a")
                        .fillTextArea("//*[@id=\"input-voucher\"]", voucherNum)
                        .clickOn("//*[@id=\"button-voucher\"]")
                        .clickOn("//*[@id=\"content\"]/div[3]/div[2]/a")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }

    @Test
    public void addItemToShoppingCartGoToCheckout_ItemIsAvailable() {
        Assertions.assertTrue(
                mainPage.fillTextArea("//*[@id=\"search\"]/input", "HP LP3065")
                        .clickOn("//*[@id=\"search\"]/span/button")
                        .clickOn("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .clickOn("//*[@id=\"content\"]/div[3]/div[2]/a")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }

    @Test
    public void addItemToShoppingCartUseCouponGoToCheckout_ItemIsAvailable() {
        Assertions.assertTrue(
                mainPage.fillTextArea("//*[@id=\"search\"]/input", "HP LP3065")
                        .clickOn("//*[@id=\"search\"]/span/button")
                        .clickOn("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .clickOn("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
                        .fillTextArea("//*[@id=\"input-coupon\"]", "1111")
                        .clickOn("//*[@id=\"button-coupon\"]")
                        .clickOn("//*[@id=\"content\"]/div[3]/div[2]/a")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }

    @ParameterizedTest
    @CsvSource({"HP LP3065, 1111, Sweden, Blekinge, 10000"})
    public void addItemToShoppingCartUseCouponCountEstimateShippingGoToCheckout_ItemIsAvailable
            (String goodsName, String couponNum, String state, String region, String postalCode) {
        Assertions.assertTrue(
                mainPage.fillTextArea("//*[@id=\"search\"]/input", goodsName)
                        .clickOn("//*[@id=\"search\"]/span/button")
                        .clickOn("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
                        .clickOn("//*[@id=\"button-cart\"]")
                        .clickOn("//*[@id=\"top-links\"]/ul/li[4]/a")
                        .clickOn("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
                        .fillTextArea("//*[@id=\"input-coupon\"]", couponNum)
                        .clickOn("//*[@id=\"button-coupon\"]")
                        .clickOn("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
                        .chooseInSlidingArea("//*[@id=\"input-country\"]", state)
                        .chooseInSlidingArea("//*[@id=\"input-zone\"]", region)
                        .fillTextArea("//*[@id=\"input-postcode\"]", postalCode)
                        .clickOn("//*[@id=\"button-quote\"]")
                        .clickOnShowingUpWindow("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
                        .clickOn("//*[@id=\"modal-shipping\"]/div/div/div[3]/button")
                        .clickOn("//*[@id=\"content\"]/div[3]/div[2]/a")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }

    @ParameterizedTest
    @CsvSource({"Damian, ceoonly@gmail.com, When will iPhone will be on stock?"})
    public void writeMessageToTechSupport(String name, String mail, String enquiry) {
        Assertions.assertTrue(
                mainPage.clickOn("/html/body/footer/div/div/div[2]/ul/li[1]/a")
                        .fillTextArea("//*[@id=\"input-name\"]", name)
                        .fillTextArea("//*[@id=\"input-email\"]", mail)
                        .fillTextArea("//*[@id=\"input-enquiry\"]", enquiry)
                        .clickOn("//*[@id=\"content\"]/form/div/div/input")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }

    @ParameterizedTest
    @CsvSource({"Marcus, Aurelius, iamgoogleceo@gmail.com, +111111111, 11111, laptop, 11111"})
    public void returnItem(String name, String surname, String mail,
                           String phoneNum, String id, String goodsName, String orderId) {
        Assertions.assertTrue(
                mainPage.clickOn("/html/body/footer/div/div/div[2]/ul/li[2]/a")
                        .fillTextArea("//*[@id=\"input-firstname\"]", name)
                        .fillTextArea("//*[@id=\"input-lastname\"]", surname)
                        .fillTextArea("//*[@id=\"input-email\"]", mail)
                        .fillTextArea("//*[@id=\"input-telephone\"]", phoneNum)
                        .fillTextArea("//*[@id=\"input-order-id\"]", id)
                        .clickOn("//*[@id=\"content\"]/form/fieldset[1]/div[6]/div/div/span/button")
                        .clickOn("/html/body/div[3]/div/div[1]/table/tbody/tr[1]/td[7]")
                        .fillTextArea("//*[@id=\"input-product\"]", goodsName)
                        .fillTextArea("//*[@id=\"input-model\"]", orderId)
                        .clickOn("//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[1]/label/input")
                        .clickOn("//*[@id=\"content\"]/form/div/div[2]/input")
                        .isPresentOnPage("//*[@id=\"content\"]/h1"));
    }
}
