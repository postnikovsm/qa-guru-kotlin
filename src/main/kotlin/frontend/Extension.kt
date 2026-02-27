package org.example.frontend

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

fun ElementsCollection.findByTextOrFail(name: String): SelenideElement {
    val link = this.find { it.text == name }
        ?: error("Элемент '$name' не найден в коллекции")
    return link
}