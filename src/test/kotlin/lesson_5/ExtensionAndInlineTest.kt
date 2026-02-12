package lesson_5

import io.kotest.matchers.shouldBe
import lesson_4.Person
import lesson_4.Student
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ExtensionAndInlineTest {
    val person = Person("Semyon", 32)
    @Test
    @DisplayName("Проверка имени студента")
    fun checkDefaultStreamNumberTest() {
        val student = Student(person, "Kotlin")
        student.checkName("Semyon")
    }

    @Test
    @DisplayName("Проверка типа объекта студент")
    fun checkTypeStudent() {
        val student = Student(person, "Kotlin")
        student.checkType()
    }

    @Test
    @DisplayName("Проверка, что название курса не в верхнем регистре")
    fun checkUpperCaseTest() {
        val student = Student(person, "Kotlin")
        student.courseName.isUpperCase().shouldBe(false)
    }

    @Test
    @DisplayName("Проверка название курса содержит 'Kot'")
    fun checkContainsSubstringTest() {
        val student = Student(person, "Kotlin")
        student.courseName.containsSubstring("Kot").shouldBe(true)
    }
}