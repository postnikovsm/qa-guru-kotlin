package firstTest.lesson_5

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tags(Tag("regression"), Tag("smoke"))
class QAGuruKotlinCoursePagePresenceTest {

    @Test
    @DisplayName("Проверка названия курса")
    fun checkNameCourse() {
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://qa.guru/kotlin")

        Selenide.element(".uui-heading-medium-curs .text-span")
            .shouldHave(Condition.text("Kotlin"))
    }

    @Test
    @DisplayName("Проверка стоимости курса")
    fun checkPriceCourseTest() {
        Configuration.pageLoadStrategy = "eager";
        val price = "6 085"
        Selenide.open("https://qa.guru/kotlin")

        Selenide.element(".new-rassrochka-text-wa-course")
            .shouldHave(Condition.exactText("Рассрочка от $price р/мес"))
    }
}