package entities;

import com.github.javafaker.Faker;

public class Patient {
    private final String firstName;
    private final String lastName;
    Faker faker = new Faker();

    public Patient() {
        this.firstName = "AQA_" + faker.name().firstName();
        this.lastName = "AQA_" + faker.name().lastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
