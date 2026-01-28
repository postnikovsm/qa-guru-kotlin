
import org.junit.jupiter.api.DisplayName
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.exactText
import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tags(Tag("regression"), Tag("smoke"))
class QAGuruKotlinCoursePagePresenceTest {

    @Test
    @DisplayName("Проверка названия курса")
    fun checkNameCourse() {
        Configuration.pageLoadStrategy = "eager";
        open("https://qa.guru/kotlin")

        element(".uui-heading-medium-curs .text-span")
            .shouldHave(text("Kotlin"))
    }

    @Test
    @DisplayName("Проверка стоимости курса")
    fun checkPriceCourseTest() {
        Configuration.pageLoadStrategy = "eager";
        val price = "6 085"
        open("https://qa.guru/kotlin")

        element(".new-rassrochka-text-wa-course")
            .shouldHave(exactText("Рассрочка от $price р/мес"))
    }
}