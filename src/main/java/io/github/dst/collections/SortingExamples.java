package io.github.dst.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public void multiKeySorting() {
        List<Person> people = Arrays.asList(
                new Person("Zofia", 2),
                new Person("Szymon", 2),
                new Person("Zdzisław", 101)
        );

        Comparator<Person> oldestFirstThenByNameComparator = Comparator
                .comparing(Person::getAge, Comparator.reverseOrder())
                .thenComparing(Person::getName);

        people.sort(oldestFirstThenByNameComparator);

        assert people.get(0).name.equals("Zdzisław");
        assert people.get(1).name.equals("Szymon");
        assert people.get(2).name.equals("Zofia");
    }
}
