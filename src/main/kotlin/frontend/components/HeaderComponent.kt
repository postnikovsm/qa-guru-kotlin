package org.example.frontend.components
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.findByTextOrFail
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class HeaderComponent {
    val linksHeader get() = elements(byDataTestGroup("nav-link"))

    @Step("Открыть раздел {name}")
    fun clickLink(name: String): HeaderComponent {
        val link = linksHeader.find { it.text == name }
            ?: error("Header link with text '$name' not found")
        link.click()
        return this
    }

    @Step("Клик по всем ссылкам в хэдере")
    fun clickAllLinks(): HeaderComponent {
        linksHeader
            .map { it.text.trim() }
            .forEach { clickLinkByExtension(it) }
        return this
    }

    @Step("Открыть раздел {name}")
    fun clickLinkByExtension(name: String): HeaderComponent {
        linksHeader.findByTextOrFail(name).click()
        return this
    }
}