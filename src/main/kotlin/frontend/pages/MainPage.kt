package org.example.frontend.pages

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestId

class MainPage {
    private val txtTitle get() = element(byDataTestId("main-image-text"))
    private val productCard get() = elements(byClassName("product-card"))

    @Step("Получить список товаров")
    fun getProducts(): ElementsCollection {
        productCard.shouldHave(CollectionCondition.sizeGreaterThan(0))
        return this.productCard
    }

    @Step("Получить title страницы")
    fun getTitle(): String {
        return txtTitle.text
    }
}