package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class TestOzon extends TestBase {


    @Test
    @DisplayName("Проверка Ozon в хедере")
    void testLogotipOzon() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Проверить наличие надписи Ozon в хедере", () -> {
            $("[data-widget=header]").should(text("Ozon"));
        });

    }


    @Test
    @DisplayName("Навигация по каталогу")
    void testKatalog(){

        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть на кнопку Каталог", () -> {
            $("[class='ui-b4 ui-b6']").click();
        });
        step("Кликнуть на пункт \"Системные блоки\"", () -> {
            $(By.linkText("Системные блоки")).click();
        });
        step("Проверить что нахожусь в раздере \"Системные блоки\"", () -> {
            $("[data-widget=catalogResultsHeader]").shouldHave(text("Системные блоки"));
        });
    }


    @Test
    @DisplayName("Поиск процессора amd ryzen 5 5600x")
    void testSearchXiaomi() {

        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("В строку поиска ввести amd ryzen 5 5600x", () -> {
            $("[name=text]").setValue("amd ryzen 5 5600x");
        });
        step("В выпадающем меню выбрать пункт 'бренд Xiaomi'", () -> {
            $("[href='/search/?from_global=true&text=amd+ryzen+5+5600x']").click();
        });
        step("Проверить что нахожусь на странице с процессором amd ryzen 5 5600x", () -> {
            $("[data-widget=meta]").shouldHave(text("amd ryzen 5 5600x"));
        });
    }


    @Test
    @DisplayName("Добавление товара в корзину")
    void testItemCart() {

        step("Открыть карточку c товаром", () -> {
            open(baseUrl +
                    "product/videokarta-msi-geforce-rtx-3080-ti-12-gb-3080-ti-gaming-x-trio-12g-560949480/?advert=gLZI_cGoSJ595YMs5Wn9tJgrd_iA9IbWvUgSz0J38L7OFTNV8Tk4IiEi3TTjIu9EAobsWDE8t1fOXrNHP7HGvTag36GqkTWKgVJjmKEGlyQmZm3sAlc_YyJjkUWPoUxbxWKb4pYmXLLd2ccYJBvWrYzzKDy1JWTvi0OD2ihBfVzQiq5_UYY_bD-c2DCTUmyqTWyde4QPCHc8-aXBXt4il7uhSQB1C8KoyY38gTBZWYgezl-sWb57BJtWEblgX_ALgxbGtLl-IfGTPcUUVtjEwG5dOIXgYmpakyiKlvYH9Rk5dWHyad4TrQr3VfqcLIKQDL47EO-2tZF-Kh6IC6dSCYarjB-xtwhBzgDnOZ1pgWwTxhBpLhntGEov5ddibN88ROrngmFqVYVQhsvQZl0OBV_PLGX_KnIQvWD8kBuod67WaeJ3ObPxVLBLWj0zzXZmH7vyF9xIZVJwPwXn2mZt0J1JHVJHzFGWiDDLn15I9Yo2DfjMAL3QtzmcxSQsB-OBVUOwnFC-1SyNH15a8loizTF3Wk56e6JPfeE9ui_cCSrfeOg0LUkTlTTgBaq9Gz68tUv_w0NsGHsAin1k8TkI8Q&keywords=3080ti+rtx+видеокарта&sh=J9CUxX3Z2A");
        });
        step("Нажать на кнопку Добавить в корзину", () -> {
            $("[data-widget=webAddToCart]").click();
        });
        step("Перейти в корзину", () -> {
            $("[href='/cart']").click();
        });
        step("Проверить что товар в корзине", () -> {
            $("[class='ta4 ta5']").shouldHave(text("Видеокарта MSI GeForce RTX 3080 Ti 12 ГБ"));
        });
    }

    @Test
    @DisplayName("Навигация Ozon Travel")
    void testNavigation() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на пункт Ozon Travel", () -> {
            $("[href='https://www.ozon.ru/travel?perehod=ozon_menu_header']").click();
        });
        step("Проверить что попал на страницу Ozon Travel", () -> {
            $("[data-widget='seoPurchaseAdvantages']")
                    .shouldHave(text("Покупать авиа- и ж/д билеты на Ozon удобно!"));
        });

    }




}