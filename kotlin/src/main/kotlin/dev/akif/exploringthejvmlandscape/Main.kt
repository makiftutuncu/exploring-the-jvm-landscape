package dev.akif.exploringthejvmlandscape

data class Person(val name: String, val hobbies: Set<String>?)

inline fun <reified T> Iterable<*>.filterBy(predicate: (T) -> Boolean): List<T> =
    this.filterIsInstance<T>().filter(predicate)

fun main() {
    val people = listOf(
        Person("John", setOf("Skiing", "Hiking")),
        Person("Steve", setOf()),
        Person(name = "Jack", hobbies = null),
        "Not a Person"
    )

    people
        .filterBy<Person> { it.hobbies?.isEmpty() ?: true }
        .forEach { println("${it.name} has no hobbies") }
}
