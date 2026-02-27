package frontend

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import org.example.frontend.helpers.BaseUITest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LamodaTest : BaseUITest() {

    @Test
    @DisplayName("Проверка открытия сайта Lamoda")
    fun testOpenLamoda() {
        Selenide.open("https://www.lamoda.ru")
        sleep(25_000)
    }
}