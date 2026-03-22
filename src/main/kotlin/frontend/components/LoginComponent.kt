package org.example.frontend.components

import com.codeborne.selenide.Selectors.shadowCss
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestId

class LoginComponent {
    private val loginEmailInput
        get() = element(byDataTestId("login-email"))
            .find(shadowCss("input"))

    private val loginPasswordInput
        get() = element(byDataTestId("login-password"))
            .find(shadowCss("input"))

    private val loginButton get() = element(byDataTestId("login-submit"))
    private val loginError get() = element(byDataTestId("login-error"))


    @Step("Заполнить форму авторизации")
    fun fillLoginForm(email: String, password: String): LoginComponent {
        loginEmailInput.value = email
        loginPasswordInput.value = password
        return this
    }

    @Step("Нажать на кнопку Login")
    fun submitLogin(): LoginComponent {
        loginButton.click()
        return this
    }

    @Step("Получить текст ошибки")
    fun getErrorTest(): String {
        return loginError.text
    }
}