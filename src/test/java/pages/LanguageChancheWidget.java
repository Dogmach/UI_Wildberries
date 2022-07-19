package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LanguageChancheWidget {
    private SelenideElement countryMenu = $("span[class='simple-menu__link simple-menu__link--country j-wba-header-item'] span:nth-child(1)"),
            belarusLanguage = $x("//span[normalize-space()='(Belarus)']"),
            geocityMenu = $x("//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");

    private String minsk = "Минск";

    public LanguageChancheWidget moveTheMouse() {
        countryMenu.hover();
        return this;
    }

    public LanguageChancheWidget chooseLanguage() {
        belarusLanguage.click();
        return this;
    }

    public LanguageChancheWidget checkGeocity() {
        geocityMenu.shouldHave(Condition.text(minsk));
        return this;
    }


}
