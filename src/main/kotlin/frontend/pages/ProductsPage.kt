package org.example.frontend.pages

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class ProductsPage {
    private val productsTitle get() = elements(byDataTestGroup("product-card"))

    @Step("Получить товары со страницы")
    fun geProducts(): ElementsCollection {
        productsTitle.shouldHave(CollectionCondition.sizeGreaterThan(0))
        return this.productsTitle
    }
}