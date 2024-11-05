//> using scala 3.5.2
//> using jvm 21

case class Person(name: String, hobbies: Option[Set[String]])

@main
def findPeopleWithoutHobbies(): Unit =
    val people = List(
        Person("John", Some(Set("Skiing", "Hiking"))),
        Person("Steve", Some(Set.empty)),
        Person(name = "Jack", hobbies = None),
        "Not a Person"
    )

    people
        .collect:
            case p @ Person(_, h) if h.forall(_.isEmpty) => p
        .foreach: p =>
            println(s"${p.name} has no hobbies")
