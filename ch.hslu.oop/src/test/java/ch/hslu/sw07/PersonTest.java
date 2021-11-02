package ch.hslu.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void Constructor_SetID_IDIsSet() {
        long id = 1;
        String firstname = "Firstname";
        String lastname = "Lastname";
        Person person;

        person = new Person(id, firstname, lastname);

        assertEquals(id, person.getID());
    }

    @Test
    public void Constructor_SetFirstname_FirstnameIsSet() {
        long id = 1;
        String firstname = "Firstname";
        String lastname = "Lastname";
        Person person;

        person = new Person(id, firstname, lastname);

        assertEquals(firstname, person.getFirstname());
    }

    @Test
    public void Constructor_SetLastname_LastnameIsSet() {
        long id = 1;
        String firstname = "Firstname";
        String lastname = "Lastname";
        Person person;

        person = new Person(id, firstname, lastname);

        assertEquals(lastname, person.getLastname());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void equals_isEqual() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(2, "Firstname", "Lastname");

        boolean isEqual = person.equals(person2);

        assertEquals(false, isEqual);
    }

    @Test
    public void equals_isNotEqual() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(1, "Firstname", "Lastname");

        boolean isEqual = person.equals(person2);

        assertEquals(true, isEqual);
    }

    @Test
    public void getHashCode_isEqual() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(1, "Firstname", "Lastname");

        int hashCode = person.hashCode();
        int hashCode2 = person2.hashCode();

        assertEquals(hashCode, hashCode2);
    }

    @Test
    public void getHashCode_isNotEqual() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(2, "Firstname", "Lastname");

        int hashCode = person.hashCode();
        int hashCode2 = person2.hashCode();

        assertNotEquals(hashCode, hashCode2);
    }

    @Test
    public void compare_isSmaller() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(2, "Firstname", "Lastname");

        int result = person.compareTo(person2);

        assertEquals(-1, result);
    }


    @Test
    public void compare_isGreater() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(2, "Firstname", "Lastname");

        int result = person2.compareTo(person);

        assertEquals(1, result);
    }

    @Test
    public void compare_isEqual() {
        var person = new Person(1, "Firstname", "Lastname");
        var person2 = new Person(1, "Firstname", "Lastname");

        int result = person.compareTo(person2);

        assertEquals(0, result);
    }
}