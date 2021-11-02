package ch.hslu.sw07;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final long ID;
    private String firstname;
    private String lastname;

    public Person(long ID, String firstname, String lastname) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;

        }
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;
        return this.ID == person.ID
                && Objects.equals(this.firstname, person.firstname)
                && Objects.equals(this.lastname, person.lastname);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.ID, this.firstname, this.lastname);
    }

    @Override
    public int compareTo(Person person) {
        return Long.compare(this.ID, person.ID);
    }
}
