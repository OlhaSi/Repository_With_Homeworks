import java.util.*;

public class Person {

    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person: " +
                 name +
                ", " + address;
    }

    public static List<Address> getAddresses(List<Person> persons){
        List<Address> list = new LinkedList<>();
        for (Person p : persons) {
            list.add(p.address);
        }
        return list;
    }
}
