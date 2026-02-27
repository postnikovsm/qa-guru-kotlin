package org.example.frontend.helpers

import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.Capabilities
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI

open class DriverProvider : WebDriverProvider {
    override fun createDriver(capabilities: Capabilities): RemoteWebDriver {
        return ChromeOptions().apply {
            setCapability("browserName", "chrome")
            setCapability("browserVersion", "latest")
            setCapability(
                "selenoid:options",
                mapOf(
                    "enableVNC" to true,
                    "enableVideo" to false,
                    "sessionTimeout" to "15m",
                    "screenResolution" to "1920x1080"
                )
            )
        }.run {
            RemoteWebDriver(URI("http://localhost:5555/wd/hub").toURL(), this)
        }.apply {
            fileDetector = LocalFileDetector()
        }
    }
}