package glue;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchFunctionalitySteps {

    @When("I search for {string}")
    public void searchForString(String text) {
        $(byCssSelector("#header-section > div > div.col-xs-24.col-sm-16 > div.col-xs-24.col-sm-10 > div.col-xs-24.no-padding > form > div > input")).setValue(text).submit();
    }


    @Then("I should get more than {string} results containing {string}")
    public void iShouldGetMoreThanResults(String number, String text) {

        ElementsCollection headers = $$(By.tagName("h4"));

        int counter = 0;
        for (SelenideElement header : headers) {
            String productName = header.getText();
            if (productName.contains(text)) {
                counter++;
            }
        }

        Assert.assertTrue("There were less results than required", counter > Integer.parseInt(number));
    }

    @Then("The products should be sorted from the {string}")
    public void theProductsShouldBeSortedFromTheExpectedResult(String param) {
        ElementsCollection prices = $$(By.className("price"));

        Double previousPrice = 0.0;
        if (param.equals("cheapest")) {
            previousPrice = -Double.MAX_VALUE;
        } else if (param.equals("most expensive")) {
            previousPrice = Double.MAX_VALUE;
        }

        for (SelenideElement priceTag : prices) {
            //convert SelenideElements as Strings to be ready for parsing to Double
            if (priceTag.toString().length() > 25){
                String tmpString = priceTag.toString().substring(17, priceTag.toString().length() - 7).replace(",", ".").replace(" ", "");
                Double currentNumericPrice = Double.parseDouble(tmpString);

                if (param.equals("cheapest")) {
                    Assert.assertTrue("Previous price is not lower or equal to the current one", currentNumericPrice >= previousPrice);
                } else if (param.equals("most expensive")) {
                    Assert.assertTrue("Previous price is not higher or equal to the current one", currentNumericPrice <= previousPrice);
                }

                previousPrice = currentNumericPrice;
            }
        }
    }
}
