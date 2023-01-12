package glue;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToFavouritesTestSteps {

    private String itemName = "";

    @And("I click on the first item")
    public void clickOnFirstItem() {
        $(byXpath("/html/body/main/div/div/div/div[3]/ul/li[1]")).click();
        itemName = $(byClassName("ProductName-module--container__bmkk9")).getText();
    }

    @And("I add the item to favourites")
    public void addItemToFavourites(){
        $(byXpath("//*[@id=\"main-content\"]/div[1]/div[2]/div[1]/div[1]/div/hm-favourites-button/button")).click();
    }

    @Then("I check if the item has been added successfully")
    public void checkFavourites(){
        $(byCssSelector("#nav-favourites")).click();
        $(byText(itemName)).shouldBe(visible);
    }
}