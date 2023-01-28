package glue;

import constants.Constants;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.*;

public class CabinetFrontCalculatorSteps {

    @And("I input the width of the front {string}, thickness {string} and height {string}")
    public void inputValuesIntoTheCalculator(String width, String thickness, String height){
        $(byXpath("//*[@id=\"calculator-modal\"]/div/div/div[2]/form/div[3]/div[1]/div[2]/input")).setValue(width);
        $(byXpath("//*[@id=\"calculator-modal\"]/div/div/div[2]/form/div[3]/div[2]/div[2]/input")).setValue(thickness);
        $(byXpath("//*[@id=\"calculator-modal\"]/div/div/div[2]/form/div[3]/div[3]/div[2]/input")).setValue(height);
    }

    @And("I verify that all the values match for a given {string}")
    public void assertCorrectValues(String cabinetType) {
        String weight = $(byXpath("//*[@id=\"calculator-modal\"]/div/div/div[2]/form/div[5]/p[1]")).getText();
        String powerFactor = $(byXpath("//*[@id=\"calculator-modal\"]/div/div/div[2]/form/div[5]/p[2]")).getText();

        weight = weight.substring(14,weight.length() - 3);
        powerFactor = powerFactor.substring(20);

        switch (cabinetType){
            case "Aventos HF":
                assertTrue("Weight is not equal", Constants.HF_WEIGHT.equals(weight));
                assertTrue("Power Factor is not equal", Constants.HF_POWER_FACTOR.equals(powerFactor));
                break;
            case "Aventos HK-S":
                assertTrue("Weight is not equal", Constants.HKS_WEIGHT.equals(weight));
                assertTrue("Power Factor is not equal", Constants.HKS_POWER_FACTOR.equals(powerFactor));
                break;
            case "Aventos HK":
                assertTrue("Weight is not equal", Constants.HK_WEIGHT.equals(weight));
                assertTrue("Power Factor is not equal", Constants.HK_POWER_FACTOR.equals(powerFactor));
                break;
        }
    }
}
