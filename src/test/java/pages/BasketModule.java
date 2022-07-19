package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketModule {
    private SelenideElement burgerLine = $(".nav-element__burger-line"),
            menuBurger = $(".menu-burger__main-list-link.menu-burger__main-list-link--566"),
            plants = $(byText("Брюки")),
            plantsOfInterest = $x("//div[@id='c68988778']//img[@alt='Брюки Barouz Jeans']"),
            size48 = $x("//span[normalize-space()='32']"),
            buttonBasket = $(byText("Добавить в корзину")),
            goToBasket = $(byText("Перейти в корзину")),
            priceToBasket = $x("//div[@class='list-item__price-new']");

    private String platsFullName = "Брюки",
            nameOfPlants = "STR style";

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
        priceToBasket.shouldBe(Condition.visible).shouldHave(Condition.text("1 620"));
        return this;
    }

}
