import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        PersonGenerator personGenerator = new PersonGenerator(names, families);
        Collection<Person> persons = personGenerator.generate(10_000_000);

        long underageCount = persons.stream().filter(p -> p.getAge() < 18).count();

        List<String> conscripts = persons.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        List<Person> workers = persons.stream()
                .filter(p -> p.getEducation() == Education.HIGHER && p.getAge() >= 18 &&
                        ((p.getSex() == Sex.WOMAN && p.getAge() <= 60) || (p.getSex() == Sex.MAN && p.getAge() <= 65)))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
