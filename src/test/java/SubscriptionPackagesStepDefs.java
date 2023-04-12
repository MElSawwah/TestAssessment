import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static org.junit.Assert.*;

public class SubscriptionPackagesStepDefs {
  private WebDriver driver;

  @Given("I am on the STC TV subscriptions page")
  public void i_am_on_the_STC_TV_subscriptions_page() {
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    driver = new ChromeDriver();
    driver.get("https://subscribe.stctv.com/");
  }

  @When("I select the country {string}")
  public void i_select_the_country(String country) {
    WebElement countryDropdown = driver.findElement(By.cssSelector("#country-select"));
    countryDropdown.click();
    WebElement countryOption = driver.findElement(By.xpath("//option[text()='" + country + "']"));
    countryOption.click();
  }

  @Then("I should see the subscription packages with correct type, price and currency for {string}")
  public void i_should_see_the_subscription_packages_with_correct_type_price_and_currency_for(String country) {
    WebElement subscriptionPackage = driver.findElement(By.cssSelector(".subscription-package"));
    String packageType = subscriptionPackage.findElement(By.cssSelector(".package-type")).getText();
    String packagePrice = subscriptionPackage.findElement(By.cssSelector(".package-price")).getText();
    String packageCurrency = subscriptionPackage.findElement(By.cssSelector(".package-currency")).getText();
    switch (country) {
      case "SA":
        assertEquals("Basic", packageType);
        assertEquals("10 SAR", packagePrice);
        assertEquals("SAR", packageCurrency);
        break;
      case "Kuwait":
        assertEquals("Premium", packageType);
        assertEquals("5 KWD", packagePrice);
        assertEquals("KWD", packageCurrency);
        break;
      case "Bahrain":
        assertEquals("Standard", packageType);
        assertEquals("3 BHD", packagePrice);
        assertEquals("BHD", packageCurrency);
        break;
      default:
        fail("Invalid country: " + country);
    }
  }

  @After
  public void afterScenario() {
    driver.quit();
  }
}
