package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends PageObject {

    //static String PRODUCT_TITLE =".inventory_item_name";
    static By PRODUCT_TITLE =By.className("inventory_item_name");
    static String PRODUCT_IMAGE_TEXT = ("//div[@class='inventory_item'][contains(.,\"%s\")]//img");

    public List<String> titles(){
        //return findAll(".inventory_item_name").textContents();
        return findAll(PRODUCT_TITLE).textContents();
    }

    public String imageTextForProduct(String productName){
        //return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
        return $(String.format(PRODUCT_IMAGE_TEXT,productName)).getAttribute("alt");
    }

    public static By productDetailsLinkFor(String itemName){
        return By.linkText(itemName);
    }





}
