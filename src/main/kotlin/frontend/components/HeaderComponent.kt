package org.example.frontend.components
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.findByTextOrFail
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class HeaderComponent {
    private val linksHeader get() = elements(byDataTestGroup("nav-link"))
    private val avatar get() = element(".avatar")

    @Step("Открыть раздел {name}")
    fun clickLink(name: String): HeaderComponent {
        val link = linksHeader.find { it.text == name }
            ?: error("Header link with text '$name' not found")
        link.click()
        return this
    }

    @Step("Получить список ссылок")
    fun getLinksHeaders(): List<String> {
        return linksHeader.map { it.text }
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

    @Step("Проверить видимость аватарки")
    fun getAvatar(): String {
        return avatar.getAttribute("src")!!
    }
}