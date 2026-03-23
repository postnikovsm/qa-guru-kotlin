package org.example.frontend.models

import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class ProductPopularItems {
    private val listProducts get() = elements(byDataTestGroup("product-card"))

    fun getItems(): List<ProductPopularItem> {
        return listProducts
            .map {
                ProductPopularItem(
                    image = it.find(byDataTestGroup("product-card-image")),
                    name = it.find(byDataTestGroup("product-card-name")).text,
                    description = it.find(byDataTestGroup("product-card-description")).text,
                    price = it.find(byDataTestGroup("product-card-price")).text.filter { it.isDigit() }.toFloat() / 100f,
                    btnIncrement = it.find(byDataTestGroup("product-card-increment")),
                    quantity = it.find(byDataTestGroup("product-card-qty")).text.toInt(),
                    btnDecrement = it.find(byDataTestGroup("product-card-decrement")),
                )
            }
    }
}

data class ProductPopularItem(
    val image: SelenideElement,
    val name: String,
    val description: String,
    val price: Float,
    val btnDecrement: SelenideElement,
    var quantity: Int,
    val btnIncrement: SelenideElement,
)