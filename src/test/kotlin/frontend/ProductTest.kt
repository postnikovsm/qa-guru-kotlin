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
    fun checkPopularAndAllProductsTest() {
        val firstPopularItem = MainPage()
            .getProducts()

        HeaderComponent()
            .clickLink("Products")
        val firstItem = ProductsPage().getProducts()

        firstItem.shouldContainAllInAnyOrder(firstPopularItem)
    }
}