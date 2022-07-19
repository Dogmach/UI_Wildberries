package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement headerContainer = $x("//div[@class='header__container']"),
            searchInput = $x("//input[@id='searchInput']"),
            searchingResultTitle = $(".searching-results__title");

    String wildberries = "Wildberries",
            mansTShirt = "футболка мужская";

    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    public MainPage checkHeader() {
        headerContainer.shouldHave(text(wildberries));
        return this;
    }

    public MainPage writeInSearchBar() {
        searchInput.setValue(mansTShirt).pressEnter();
        return this;
    }

    public MainPage checkForRequest() {
        searchingResultTitle.shouldHave(text(mansTShirt));
        return this;
    }
}
