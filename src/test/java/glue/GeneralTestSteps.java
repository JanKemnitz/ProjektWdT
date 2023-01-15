package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en_scouse.An;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GeneralTestSteps {

    @Given("I open {string}")
    public void openGoogle(String url) {
        open(url);
        if($(byId("closeCoockieAccept")).isDisplayed()){
            $(byText("Zamknij")).shouldBe(visible).click();
            $(byText("Zamknij")).should(disappear);
        }
        sleep(200);
    }

    @And("I click on linkText {string}")
    public static void clickOnLinkTextString(String text) {
        $(byLinkText(text)).click();
        sleep(500);
        if($(byId("closeCoockieAccept")).isDisplayed()){
            System.out.println("aaa!");
            $(byText("Zamknij")).shouldBe(visible).click();
            $(byText("Zamknij")).should(disappear);
        }
        sleep(2000);
    }

    @And("I click on text {string}")
    public static void clickOnTextString(String text){
        $(byText(text)).click();
        sleep(2000);
    }

    @And("I verify that {string} is visible")
    public static void verifyThatStringIsVisible(String text){
        $(byText(text)).shouldBe(visible);
    }
}
