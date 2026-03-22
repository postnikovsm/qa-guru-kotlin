package frontend

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.example.frontend.components.HeaderComponent
import org.example.frontend.components.RegistrationComponent
import org.example.frontend.helpers.BaseUITest
import org.junit.jupiter.api.DisplayName
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ParameterizedTest: BaseUITest() {

    @ParameterizedTest
    @CsvSource(
        "bla-bla, bla-bla,Invalid email or password",
        "bla-bla,'',Please enter email and password",
        "'', bla-bla,Please enter email and password",
        "'','',Please enter email and password"
    )
    @DisplayName("Авторизация с не вылидными данными")
    fun unsuccessfulLoginTest(email: String, password: String, message: String) {
        HeaderComponent().clickLink("Join")
        val error = RegistrationComponent()
            .openLoginComponent()
            .fillLoginForm(email, password)
            .submitLogin().getErrorTest()

        error shouldBe message
    }

    @Test
    @DisplayName("Авторизация с валидными данными")
    fun successfulLoginTest() {
        HeaderComponent().clickLink("Join")
        RegistrationComponent()
            .openLoginComponent()
            .fillLoginForm("test@test.test", "test")
            .submitLogin()

        val avatar = HeaderComponent().getAvatar()

        avatar shouldContain ("/src/assets/images/avatar.png")
    }

    @ParameterizedTest
    @ValueSource(strings = ["Products", "Orders", "Contact", "Cart"])
    fun testWithValueSource(links: String) {
        val listLinks = HeaderComponent().getLinksHeaders()

        listLinks shouldContain links
    }
}