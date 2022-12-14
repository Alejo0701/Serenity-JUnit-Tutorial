package serenitySwag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenitySwag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenLoggingOn {

    @Managed(options = "headless")
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage(){
        //driver.get("https://www.saucedemo.com/");

       /* driver.findElement(new By.ByCssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(new By.ByCssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(new By.ByCssSelector("[data-test='login-button']")).click();*/

        //assertThat(driver.findElement(new By.ByCssSelector(".title")).getText()).isEqualToIgnoringCase("Products");

        login.as(STANDARD_USER);

        Serenity.reportThat("The Inventory Heading contains the word 'Products'",
        ()-> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );
       //assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products");






    }

}
