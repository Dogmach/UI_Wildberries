package tests;

import helpers.Attach;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TestWildberries extends TestBase {

    @Owner("Курс QA.GURU 13 UNIT")
    @Link(value = "Тестирование UI сайта", url = "https://www.wildberries.ru/")
    @Feature("Задачи в репозитории")
    @Tag("smoke")
    @Test
    @DisplayName("Проверка наличия слова Wildberries в хедере")
    void testControlTitleText() {
        step("Открыть главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Проверить есть ли в хедере слово Wildberries", () -> {
            $x("//div[@class='header__container']").should(text("Wildberries"));
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка работоспособности поиска товаров на главной странице сайта и отображение количества товаров")
    void testCheckSearchOnHomepage() {

        step("Открыть главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Ввести в строку поиска \"футболка мужская\" и нажать Enter", () -> {
            $x("//input[@id='searchInput']").setValue("футболка мужская").pressEnter();
        });
        step("Проверить наличие запроса \"футболка мужская\" в строке результатов", () -> {
            $(".searching-results__title").shouldHave(text("футболка мужская"));
        });
        step("Проверить видимость отображения количества найденных товаров на странице", () -> {
            $(".goods-count").shouldBe(visible);
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Добавление самых популярных мужских брюк в корзину")
    void testCheckBasketShop() {

        step("Открыть главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Кликнуть по значку каталога в левом углу", () -> {
            $(".nav-element__burger-line").click();
        });
        step("Навести мышку на категорию \"Мужчинам\"", () -> {
            $x("//a[@class='menu-burger__main-list-link menu-burger__main-list-link--566']").hover();
        });
        step("Кликнуть на раздел \"Брюки\"", () -> {
            $x("//a[@href='/catalog/muzhchinam/odezhda/bryuki-i-shorty']").click();
        });
        step("Кликнуть по интересующим нас брюкам на странице", () -> {
            $x("//img[@alt='Брюки STR style']").click();
        });
        step("Кликнуть на 48 размер", () -> {
            $x("//span[normalize-space()='48']").click();
        });
        step("Кликнуть на кнопку добавить в корзину", () -> {
            $x("//span[contains(text(),'Добавить в корзину')]").click();
        });
        step("Кликнуть на перейти в корзину", () -> {
            $x("//a[contains(@class,'btn-base j-go-to-basket')]").click();
        });
        step("Проверить наличие брюк в корзине которые были изначально добавлены", () -> {
            $x("//span[@class='good-info__good-name']").shouldHave(text("Брюки мужские спортивные больших размеров широкие штаны"));
        });
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка виджета смены языка с Русского на Белорусский")
    void testSwitchLanguage() {

        step("Открыть главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Навести мышку на виджет смены языка", () -> {
            $("span[class='simple-menu__link simple-menu__link--country j-wba-header-item'] span:nth-child(1)")
                    .hover();
        });
        step("Выбрать из списка Беларусский язык", () -> {
            $x("//span[normalize-space()='(Belarus)']").click();
        });
        step("Проверить изменился ли город в меня геолокации на \"Минск\"", () -> {
            $x("//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']")
                    .shouldHave(text("Минск"));
        });
    }

    @Test
    @DisplayName("Проверка на наличие ошибок в console log")
    void testNavigation() {
        step("Открыть главную страницу" + baseUrl, () -> {
            open(baseUrl);
        });
        step("Консольные логи не должны содержать значение -  'SEVERE'", () -> {
            String consoleLogs = Attach.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}