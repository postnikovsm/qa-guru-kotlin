package org.example.frontend.pages

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.elements
import io.kotest.matchers.shouldBe
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup
import org.example.frontend.models.ProductItem
import org.example.frontend.models.ProductItems

class ProductsPage {
    private val productsTitle get() = elements(byDataTestGroup("product-card"))
    private val lisProducts get() = ProductItems().getItems()
    @Step("Получить товары со страницы")
    fun geProducts(): ElementsCollection {
        productsTitle.shouldHave(CollectionCondition.sizeGreaterThan(0))
        return this.productsTitle
    }

    @Step("Получить список популярных товаров")
    fun getProducts(): List<ProductItem> {
        return lisProducts
    }
}