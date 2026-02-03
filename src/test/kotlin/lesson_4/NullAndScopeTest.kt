package lesson_4

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NullAndScopeTest {

    val person = Person("Semyon", 32)
    @Test
    @DisplayName("Проверка дефолтного значения номера потока")
    fun checkDefaultStreamNumberTest() {

        val student = Student(person, "Kotlin")

        student.streamNumber?.let { println("Stream number: $it") } ?: println("Stream number is null")

        student.streamNumber.shouldBe(1)
        student.streamNumber.shouldNotBeNull()
    }

    @Test
    @DisplayName("Проверка null значения номера потока")
    fun checkNullStreamNumberTest() {
        val student = Student(person, "Kotlin", null)

        student.streamNumber?.let { println("Stream number: $it") } ?: println("Stream number is null")

        student.person.name.shouldBe("Semyon")
        student.streamNumber.shouldBeNull()
    }

    @Test
    @DisplayName("Проверка apply для значения номера потока")
    fun checkApplyStreamNumberTest() {
        val student = Student(person, "Kotlin", null)

        val updatedStudent = student.apply {
            student.streamNumber = 5
        }

        updatedStudent.streamNumber.shouldBe(5)
    }
}