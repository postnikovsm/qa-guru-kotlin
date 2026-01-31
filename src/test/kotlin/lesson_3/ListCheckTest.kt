package lesson_3

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ListCheckTest {
    @Test
    @DisplayName("Массив НЕ пустой")
    fun checkNoEmptyListTest() {
        val list = listOf(1, 2, 3, 4, 5)
        list.shouldNotBeEmpty()
    }

    @Test
    @DisplayName("Массив пустой")
    fun checkEmptyListTest() {
        val emptyList = emptyList<Int>()
        emptyList.shouldBeEmpty()
    }

    @Test
    @DisplayName("Первый элемент массива")
    fun checkFirstElementListTest() {
        val list = listOf(1, 2, 3, 4, 5)
        list.first().shouldBe(1)
    }
}