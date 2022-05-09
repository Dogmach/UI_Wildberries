# Проект по автоматизации тестирования для Wildberries
<a target="_blank" href="https://www.wildberries.ru">Веб сайт Wildberries</a>

## Содержание:

-:heavy_check_mark: [Технологии и инструменты](#технологии-и-инструменты)
-:heavy_check_mark: [Реализованные проверки](#реализованные-проверки)
-:heavy_check_mark: [Сборка в Jenkins](#параметры-сборки-в-jenkins)
-:heavy_check_mark: [Запуск из терминала](#запуск-тестов-из-терминала)
-:heavy_check_mark: [Allure отчет](#-отчет-в-allure-report)
-:heavy_check_mark: [Отчет в Telegram](#-уведомление-в-telegram-при-помощи-бота)
-:heavy_check_mark: [Видео примеры прохождения тестов](#-видео-прохождения-теста)

## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## Реализованные проверки

- ✓ Проверка наличия слова Wildberries в хедере.
- ✓ Проверка работоспособности поиска товаров на главной странице сайта и отображение количества товаров.
- ✓ Добавление самых популярных мужских брюк в корзину.
- ✓ Проверка виджета смены языка с Русского на Белорусский.
- ✓ Проверка на наличие ошибок в console log.

## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> работа в <a target="_blank" href="https://jenkins.autotests.cloud/job/c11-dogmach666_unit13/"> Jenkins </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/c11-dogmach666_unit13/"><img src="images/screenshots/Screenshot_1.png" alt="Jenkins"/></a>
</p>

### Параметры сборки в Jenkins:

- user (логин удалённого браузера)
- password (пароль удаленного браузера)
- remoteBrowser (адрес удаленного сервера Selenoid с параметрами user & password)
- browser (браузер, по умолчанию chrome)
- size (размер окна браузера, по умолчанию 1920x1080)
- version (версия браузера, по умолчанию 99.0)

## Запуск тестов из терминала

Локальный запуск:
```
gradle clean test
```

Удаленный запуск:
```
clean
test
-Duser=${USER}
-Dpassword=${PASSWORD}
-DremoteBrowser=${REMOTE_BROWSER}
-Dbrowser=${BROWSER}
-Dsize=${BROUSERSIZE}
-Dversion=${VERSION}
```

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/c11-dogmach666_unit13/2/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/Screenshot_2.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/screenshots/Screenshot_3.png">
</p>

### Графики

<p align="center">
<img title="Allure Graphics" src="images/screenshots/Screenshot_4.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/Screenshot_5.png" >
</p>


## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Видео прохождения теста

<p align="center">
<img title="Selenoid Video" src="images/gif/Gif_1.gif" width="750" height="459"  alt="video"> 
</p>
