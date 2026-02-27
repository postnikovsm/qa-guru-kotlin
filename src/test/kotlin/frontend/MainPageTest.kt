package frontend

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.example.frontend.components.HeaderComponent
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainPageTest: BaseUITest()  {

    @Test
    @DisplayName("Проверка количества товаров")
    fun checkCountProductTest() {
        val products = MainPage()
            .getProducts()

        products shouldHaveSize(2)
    }

    @Test
    @DisplayName("Проверка title главной страницы")
    fun mainPageCheck() {
        val title = MainPage()
            .getTitle()

        title shouldBe "Welcome to Brew & Bean"
    }

    @Test
    @DisplayName("Прокликиваем по всем ссылкам (?)")
    fun test() {
         HeaderComponent().clickAllLinks()
    }
}