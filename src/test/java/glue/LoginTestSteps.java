package glue;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTestSteps {

    private String configFilePath = "src/config.properties";

    @And("I input my login credentials and login")
    public void inputLoginCredetials(){
        Properties prop = new Properties();

        try {
            FileInputStream propsInput = new FileInputStream(configFilePath);
            prop.load(propsInput);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String login = prop.getProperty("HM_USER");
        String password = prop.getProperty("HM_PASSWORD");

        $(byCssSelector("#email")).setValue(login);
        $(byCssSelector("#password")).setValue(password).submit();
    }

    @And("I verify that the account page is displayed")
    public void verifyLoginPage(){
        $(byText("Moje oferty")).shouldBe(visible);
    }
}
