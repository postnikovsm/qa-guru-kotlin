package lesson_5

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
}