package ch.hslu.sw07;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int lastnameComparison = o1.getLastname().compareTo(o2.getLastname());

        if (lastnameComparison == 0) {
            return o1.getFirstname().compareTo(o2.getFirstname());
        }

        return lastnameComparison;
    }
}
