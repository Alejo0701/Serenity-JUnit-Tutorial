package serenitySwag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.authentication.LoginActions;
import serenitySwag.authentication.User;
import serenitySwag.inventory.ProductDetailsPage;
import serenitySwag.inventory.ProductListPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenAddingAnItemToTheCart {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public void algo(){
        System.out.println("Before");
    }

   /* @BeforeClass
    public void class1(){
        System.out.println("BeforeClass");
    }*/

    @Steps
    CartActions cartActions;

    ProductListPage productListPage;
    ProductDetailsPage productDetails;
    ShoppingCartIcon shoppingCartBadge;

    @Test
    public void theCorrectItemCountShouldBeShown(){
        login.as(User.STANDARD_USER);
        Serenity.reportThat("The cart should be empty",
                ()->assertThat(shoppingCartBadge.badgeCount()).isEmpty());

        cartActions.addItem("Sauce Labs Backpack");

        Serenity.reportThat("The cart should have 1 item",
                ()->assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1"));
    }

    @Test
    public void allTheItemShouldAppearInTheCart() {
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = firstThreeProductTitles();

        cartActions.addItems(productsOnDisplay);

        String countTitles = Integer.toString(productsOnDisplay.size());
        Serenity.reportThat("The cart should have "+countTitles+" items",
                ()->assertThat(shoppingCartBadge.badgeCount()).isEqualTo(countTitles));

        cartActions.openCart();

        Serenity.reportThat("The displayed items should have all the items listed ",
                ()->assertThat(cartActions.displayedItems()).containsExactlyElementsOf(productsOnDisplay));
     }

    @NotNull
    private List<String> firstThreeProductTitles() {
        return productListPage.titles().subList(0, 3);
    }
}
