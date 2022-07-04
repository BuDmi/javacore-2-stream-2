import java.util.*;

public class PersonGenerator {
    private List<String> names;
    private List<String> families;

    public PersonGenerator(List<String> names, List<String> families) {
        this.names = names;
        this.families = families;
    }

    public Collection<Person> generate(int num) {
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
