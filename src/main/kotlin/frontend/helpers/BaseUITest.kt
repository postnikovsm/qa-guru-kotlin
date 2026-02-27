package org.example.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class BaseUITest {
    companion object {
        init {
            Configuration.browser = DriverProvider::class.java.name
            Configuration.timeout = 10_000
            Configuration.pageLoadStrategy = "normal"
            Configuration.reopenBrowserOnFail = true
        }
    }


    @AfterEach
    fun tearDown() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}