package glue;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class MenuShortcutsSteps {

    @And("I should be transferred to {string}")
    public void verifyUrl(String url){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        if (!url.equals("blum-url")){
            Assert.assertTrue("Current url doesn't match the provided one", currentUrl.equals(url));
        } else{
            Assert.assertTrue("Current url doesn't match the provided one", currentUrl.contains("blum"));
        }
    }
}
