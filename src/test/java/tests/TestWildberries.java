package tests;

import helpers.Attach;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasketModule;
import pages.ConsoleLogs;
import pages.LanguageChancheWidget;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TestWildberries extends TestBase {
    MainPage mainPage = new MainPage();
    BasketModule basketModule = new BasketModule();
    LanguageChancheWidget languageChancheWidget = new LanguageChancheWidget();
    ConsoleLogs consoleLogs = new ConsoleLogs();

    @Owner("Курс QA.GURU 13 UNIT")
    @Link(value = "Тестирование UI сайта", url = "https://www.wildberries.ru/")
    @Feature("Задачи в репозитории")
    @Tag("smoke")
    @Test
    @AllureId("11395")
    @DisplayName("Проверка наличия слова Wildberries в хедере")
    void testControlTitleText() {
        step("Открыть главную страницу" + baseUrl, () -> {
            mainPage.openPage();
        });
        step("Проверить есть ли в хедере слово Wildberries", () -> {
            mainPage.checkHeader();
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Поиск товара на главной странице сайта")
    void testCheckSearchOnHomepage() {

        step("Открыть главную страницу" + baseUrl, () -> {
            mainPage.openPage();
        });
        step("Ввести в строку поиска \"футболка мужская\" и нажать Enter", () -> {
            mainPage.writeInSearchBar();
        });
        step("Проверить наличие запроса \"футболка мужская\" в строке результатов", () -> {
            mainPage.checkForRequest();
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Добавление мужских брюк в корзину")
    void testCheckBasketShop() {

        step("Открыть главную страницу" + baseUrl, () -> {
            mainPage.openPage();
        });
        step("Кликнуть по значку каталога в левом углу", () -> {
            basketModule.clickToBurgerLine();
        });
        step("Навести мышку на категорию \"Мужчинам\"", () -> {
            basketModule.moveToMouse();
        });
        step("Кликнуть на раздел \"Брюки\"", () -> {
            basketModule.clickOnPlants();
        });
        step("Кликнуть по интересующим нас брюкам на странице", () -> {
            basketModule.clickToPlantsOfInterest();
        });
        step("Кликнуть на 48 размер", () -> {
            basketModule.clickToSize48();
        });
        step("Кликнуть на кнопку добавить в корзину", () -> {
            basketModule.clickButtonBasket();
        });
        step("Кликнуть на перейти в корзину", () -> {
            basketModule.clickGoToBasket();
        });
        step("Проверить отображение стоимости товара в корзине", () -> {
            basketModule.checkAvailabilityPlants();
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка виджета смены языка с Русского на Белорусский")
    void testSwitchLanguage() {

        step("Открыть главную страницу" + baseUrl, () -> {
            mainPage.openPage();
        });
        step("Навести мышку на виджет смены языка", () -> {
            languageChancheWidget.moveTheMouse();
        });
        step("Выбрать из списка Беларусский язык", () -> {
            languageChancheWidget.chooseLanguage();
        });
        step("Проверить изменился ли город в меня геолокации на \"Минск\"", () -> {
            languageChancheWidget.checkGeocity();
        });
    }

    @Test
    @DisplayName("Проверка на наличие ошибок в console log")
    void testNavigation() {
        step("Открыть главную страницу" + baseUrl, () -> {
            mainPage.openPage();
        });
        step("Консольные логи не должны содержать значение -  'SEVERE'", () -> {
            consoleLogs.checkConsoleLogs();
        });
    }
}