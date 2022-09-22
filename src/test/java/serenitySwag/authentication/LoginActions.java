package serenitySwag.authentication;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractions {

    @Step("Login as {0}")
    public void as(User user){
        openUrl("https://www.saucedemo.com/");

        //$("[data-test='username']").sendKeys(user.getUsername());
        //find(By.id("user-name")).sendKeys(user.getUsername());
        //$("[data-test='password']").sendKeys(user.getPassword());
        //find(By.id("password")).sendKeys(user.getPassword());
        //$("[data-test='login-button']").click();
        //$(By.id(("login-button"))).click();
        //$("#login-button").click();

        $(LoginFormPage.USER_NAME).sendKeys(user.getUsername());
        $(LoginFormPage.PASSWORD).sendKeys(user.getPassword());
        $(LoginFormPage.LOGIN_BUTTON).click();

    }


}
