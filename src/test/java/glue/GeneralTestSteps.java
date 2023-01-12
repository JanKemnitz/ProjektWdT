package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GeneralTestSteps {

    @Given("I open {string}")
    public void openGoogle(String url) {
        open(url);
        $(byText("Akceptuj wszystkie pliki cookie")).click();
        sleep(200);
    }

    @And("I click on linkText {string}")
    public void clickOnLinkTextString(String text) {
        $(byLinkText(text)).click();
    }
}
