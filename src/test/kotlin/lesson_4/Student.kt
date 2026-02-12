package lesson_4

data class Student(
    val person: Person,
    val courseName: String,
    var streamNumber: Int? = 1
) {
}

data class Person(val name: String, val age: Int)
