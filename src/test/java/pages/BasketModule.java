package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketModule {
    private SelenideElement burgerLine = $(".nav-element__burger-line"),
            menuBurger = $x("//a[@class='menu-burger__main-list-link menu-burger__main-list-link--566']"),
            plants = $x("//div[contains(@class,'menu-burger__drop-list-item j-menu-drop-item j-menu-drop-item-566" +
                    " menu-burger__drop-list-item--active')]//a[contains(@class,'menu-burger__link" +
                    " j-menu-drop-link')][contains(text(),'Брюки')]"),
            plantsOfInterest = $x("//img[@alt='Брюки STR style']"),
            size48 = $x("//span[normalize-space()='48']"),
            buttonBasket = $x("//div[contains(@class,'product-page__aside-container j-price-block')]//span[contains(@class,'hide-mobile')][contains(text(),'Добавить в корзину')]"),
            goToBasket = $x("//div[contains(@class,'product-page__aside-container j-price-block')]//a[contains(@class,'btn-base j-go-to-basket')][contains(text(),'Перейти в корзину')]"),
            goodInfoGoodName = $x("//span[@class='good-info__good-brand ']");

    private String platsFullName = "Брюки, STR style";

    public BasketModule clickToBurgerLine() {
        burgerLine.click();
        return this;
    }

    public BasketModule moveToMouse() {
        menuBurger.hover();
        return this;
    }

    public BasketModule clickOnPlants() {
        plants.click();
        return this;
    }

    public BasketModule clickToPlantsOfInterest() {
        plantsOfInterest.click();
        return this;
    }

    public BasketModule clickToSize48() {
        size48.click();
        return this;
    }

    public BasketModule clickButtonBasket() {
        buttonBasket.click();
        return this;
    }

    public BasketModule clickGoToBasket() {
        goToBasket.click();
        return this;
    }

    public BasketModule checkAvailabilityPlants() {
        goodInfoGoodName.shouldHave(Condition.text(platsFullName));
        return this;
    }

}
