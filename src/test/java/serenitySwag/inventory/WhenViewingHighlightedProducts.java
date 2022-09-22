package serenitySwag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.authentication.User;
import serenitySwag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SerenityJUnit5Extension.class)
class WhenViewingHighlightedProducts {

    @Managed(options = "headless")
    WebDriver driver;

    @Steps
    LoginActions login;
    @Steps
    ProductListActions productList;

    ProductListPage productListPage;
    ProductDetailsPage productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productListPage.titles();

        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
        login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productListPage.titles();

        SoftAssertions softy = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softy.assertThat(productListPage.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softy.assertAll();

    }

   @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(User.STANDARD_USER);
        String firstItemName= productListPage.titles().get(0);

        //productList.openProductDetailsFor(firstItemName);
       productList.forProductWithName(firstItemName);

        Serenity.reportThat("The product title is correct",
                ()->assertThat(productDetails.getProductTitle()).isEqualTo(firstItemName));

        productDetails.productImageDisplayedWithAltAttributeOf(firstItemName).shouldBeVisible();
    }

}
