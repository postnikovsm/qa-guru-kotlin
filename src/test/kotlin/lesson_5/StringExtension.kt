package lesson_5

import io.qameta.allure.Step

@Step("Строка содержит строку")
fun String.containsSubstring(substring: String): Boolean {
    if (!this.contains(substring)) {
        return false
    }
    return true
}

fun String.upperCaseAssertion(): Boolean {
    return this.isNotEmpty()
}

@Step("Строка в верхнем регистре")
fun String.isUpperCase(): Boolean {
    if (this != this.uppercase()) {
        return false
    }
    return true
}