package org.example.frontend.models


import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.elements

import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class ProductItems {


    fun getItems(): List<ProductItem> {
        return elements(byDataTestGroup("product-card"))
            .map {
                ProductItem(
                   // image = it.find(byDataTestGroup("product-card-image")).shouldBe(visible),
                    name = it.find(byDataTestGroup("product-card-name")).shouldBe(visible).text,
                    description = it.find(byDataTestGroup("product-card-description")).shouldBe(visible).text,
                    price = it.find(byDataTestGroup("product-card-price"))
                        .shouldBe(visible).text.filter { it.isDigit() }.toFloat() / 100f,
                    quantity = it.find(byDataTestGroup("product-card-qty"))
                        .shouldBe(visible).text.toInt(),
                  //  btnIncrement = it.find(byDataTestGroup("product-card-increment")).shouldBe(visible),
                  //  btnDecrement = it.find(byDataTestGroup("product-card-decrement")).shouldBe(visible)
                )
            }
    }
}
data class ProductItem(
  //  val image: SelenideElement,
    val name: String,
    val description: String,
    val price: Float,
   // val btnDecrement: SelenideElement,
    var quantity: Int,
   // val btnIncrement: SelenideElement,
)