package org.example.frontend.components

import com.codeborne.selenide.Selectors.shadowCss
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestId

class RegistrationComponent {
    private val emailInput: SelenideElement get() = element(byDataTestId("create-email"))
        .find(shadowCss("input"))

    private val passwordInput: SelenideElement get() = element(byDataTestId("create-password"))
        .find(shadowCss("input"))

    private val userNameInput: SelenideElement get() = element(byDataTestId("create-username"))
        .find(shadowCss("input"))
    private val loginComponent: SelenideElement get() = element(byDataTestId("create-login"))



    @Step("Заполнить форму регистрации")
    fun fillLoginForm(email: String, pass: String): RegistrationComponent {
        emailInput.value = email
        passwordInput.value = pass
        return this
    }

    @Step("Открыть компонент авторизации")
    fun openLoginComponent(): LoginComponent {
        loginComponent.click()
        return LoginComponent()
    }
}