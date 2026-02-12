package lesson_5

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import lesson_4.Person

import lesson_4.Student

fun Student.checkName(name: String) {
    person.name shouldBe name
}

fun Student.checkType() {
    inlineFunctionWithReifiedType<Person>(this)
}

inline fun <reified T : Any> inlineFunctionWithReifiedType(student: Student): T {
    return student.person.shouldBeInstanceOf<T>()
}