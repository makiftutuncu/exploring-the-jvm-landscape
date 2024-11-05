import org.jetbrains.annotations.Nullable;
import java.util.*;

record Person(String name, @Nullable Set<String> hobbies) {}

void main() {
    final var people = List.of(
            new Person("John", Set.of("Skiing", "Hiking")),
            new Person("Steve", Set.of()),
            new Person("Jack", null),
            "Not a Person"
    );

    people
            .stream()
            .filter(p -> p instanceof Person(var _, var h) && (h == null || h.isEmpty()))
            .forEach(p -> System.out.println(STR."\{((Person) p).name()} has no hobbies"));
}
