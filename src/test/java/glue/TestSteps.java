package glue;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class TestSteps {

    @Given("I open google.com")
    public void openGoogle(){
        open("https://www2.hm.com/pl_pl/");
        sleep(500);
        $(byText("Akceptuj wszystkie pliki cookie")).click();
        sleep(500);
//        if ($(byText("AKCEPTUJ WSZYSTKIE PLIKI COOKIE")).isDisplayed()) {
//            $(byText("AKCEPTUJ WSZYSTKIE PLIKI COOKIE")).shouldBe(visible).click();
//            $(byText("AKCEPTUJ WSZYSTKIE PLIKI COOKIE")).should(disappear);
//        }
    }

    @And("I click on linkText {string}")
    public void clickOn(String text){
        $(byLinkText(text)).click();
        sleep(2000);
    }
}
