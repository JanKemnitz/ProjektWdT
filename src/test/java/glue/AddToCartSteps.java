package glue;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddToCartSteps {

    private String itemName = "";

    @And("I add the first item to the cart")
    public void clickOnFirstItem() {
        $(byCssSelector("#content-section > div > div.col-xs-24.col-sm-18.product-list > div.col-xs-24.products-list.no-padding.v-offset-5 > div:nth-child(1)")).hover();
        sleep(2000);
        $(byCssSelector("#content-section > div > div.col-xs-24.col-sm-18.product-list > div.col-xs-24.products-list.no-padding.v-offset-5 > div:nth-child(1) > div > div.product-description > div.product-actions > form > input.add_cart")).click();
        sleep(2000);
        itemName = $(byClassName("product-title")).getText();
    }

    @Then("I check if the item has been added successfully")
    public void checkCart(){
        $(byXpath("//*[@id=\"header-section\"]/div/div[2]/div[2]/div[2]/div/div")).click();
        $(byText(itemName)).shouldBe(visible);
    }
}
