package frontend

import io.kotest.matchers.collections.shouldContainAllInAnyOrder
import org.example.frontend.components.HeaderComponent
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.MainPage
import org.example.frontend.pages.ProductsPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductTest: BaseUITest() {

    @Test
    @DisplayName("Popular Products присутствую в списке All Products")
    fun testProductsInCart() {
        val firstPopularItem = MainPage()
            .getPopularProducts()
            .map { Triple(it.name, it.description, it.price) }

        HeaderComponent()
            .clickLink("Products")
        val firstItem = ProductsPage().getProducts()
            .map { Triple(it.name, it.description, it.price) }

        firstItem.shouldContainAllInAnyOrder(firstPopularItem)
    }
}