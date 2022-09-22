package serenitySwag.cart;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import serenitySwag.inventory.ProductListPage;

import java.util.List;

public class CartActions extends UIInteractions {

    ShoppingCartIcon shoppingCartIcon;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductListPage.addItemToCart(itemName)).click();
        //$("//div[contains(text(), "+itemName+")][@class='inventory_item']//button").click();
    }

    @Step("Add {0} to the cart")
    public void addItems(List<String> titles) {
        titles.forEach(this::addItem);
    }

    @Step("Open the shopping cart")
    public void openCart(){
        $(shoppingCartIcon.link()).click();
    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").textContents();
    }
}
