package glue;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AccountSteps {

    private final String configFilePath = "src/test/resources/config.properties";

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

        String login = prop.getProperty("SHOP_EMAIL");
        String password = prop.getProperty("SHOP_PASSWORD");

        $(byId("shp_usr_email")).setValue(login);
        $(byId("shp_usr_password")).setValue(password).submit();

        sleep(2000);
    }

    @And("I verify that I'm logged in")
    public void verifyLogin(){
        $(byText("Moje konto")).shouldBe(visible);
    }

    @And("I change the address name field to {string}")
    public void changeFieldValue(String value){
        $(byId("shp_uaddr_name")).setValue(value).pressEnter();
    }

    @After("@Address")
    public void afterAddress(){
        GeneralSteps.clickOnLinkTextString("Edytuj");
        changeFieldValue("1");
        GeneralSteps.verifyThatStringIsVisible("1");
        sleep(2000);
    }
}
