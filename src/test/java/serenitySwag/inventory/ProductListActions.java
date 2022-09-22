package serenitySwag.inventory;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

class ProductListActions extends UIInteractions {


   @Step("View product details fo product '{0}'")
    public void forProductWithName(String firstItemName) {
        $(ProductListPage.productDetailsLinkFor(firstItemName)).click();
    }
}
