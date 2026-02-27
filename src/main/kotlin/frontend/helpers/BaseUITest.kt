package org.example.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class BaseUITest {

    init {
        Configuration.baseUrl = "http://localhost:4000"
        Configuration.pageLoadStrategy = "eager"
        Configuration.reopenBrowserOnFail = true
        Configuration.timeout = 5000
        Configuration.browserSize = "1920x1080"
    }

    @BeforeEach
    fun openBrowser() {
        Selenide.open("/")
    }

    @AfterEach
    fun clearBrowser() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}