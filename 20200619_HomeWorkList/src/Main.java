import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Address address = new Address("Hauptstr", 1);
        Address address1 = new Address("Neustr", 2);
        Address address2 = new Address("Alexstr", 3);

        Person p = new Person("Anna", address);
        Person p1 = new Person("Alex", address1);
        Person p2 = new Person("Dan", address2);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        System.out.println(list);
    }
}
