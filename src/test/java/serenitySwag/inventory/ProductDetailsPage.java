package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class ProductDetailsPage extends PageObject {

 /*   @FindBy(css = ".inventory_details_container img[alt='Sauce Labs Backpack']")
    private WebElement algoy;*/

    public String getProductTitle() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageDisplayedWithAltAttributeOf(String firstItemName) {
        return $(".inventory_details_container img[alt='"+firstItemName+"']");
    }
}
