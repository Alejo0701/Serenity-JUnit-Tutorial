package serenitySwag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import serenitySwag.authentication.User;

public class LoginActions extends UIInteractions {

    @Step("Login as {0}")
    public void as(User user){
        openUrl("https://www.saucedemo.com/");

        $("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        $("[data-test='login-button']").click();
    }


}
