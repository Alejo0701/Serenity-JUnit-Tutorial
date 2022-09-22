package serenitySwag.cart;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartIcon extends PageObject {

    static By SHOPPING_CART_LINK =By.className("shopping_cart_link");

    public String badgeCount() {
        return $(SHOPPING_CART_LINK).getText();
    }

    public By link(){
       return SHOPPING_CART_LINK;
    }
}
