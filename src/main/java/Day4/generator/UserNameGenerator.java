package Day4.generator;

@FunctionalInterface
public interface UserNameGenerator {
    String generate(String firstName, String lastName, int yearOfBirth, int id);
}
