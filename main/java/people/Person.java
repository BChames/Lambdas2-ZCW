package people;

import java.time.LocalDate;
import java.util.List;


public class Person implements PersonCheck {
    private static List<Person> list;
    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private int age;


    public enum Sex {
        MALE, FEMALE
    }

    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println();
    }

    public List<Person> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Person p){

        if(p instanceof Person){
            return true;
        }
        return false;
    }

    public static void printPersonsOlderThan(List<Person> list, int age) {
        for (Person p : list) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, PersonCheck tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void printPersonsOlderThanLambda(List<Person> list, int age) {

        list.stream().forEach(person -> {
            if (person.getAge() > age) person.printPerson();
        });

    }

    public static void printPersonsWithinAgeRangeLambda(List<Person> roster, int low, int high) {

        list.stream().forEach(person -> {
            if (low <= person.getAge() && person.getAge() < high) person.printPerson();
        });

    }

    public static void printPersonsLambda(List<Person> list, PersonCheck tester) {

        list.stream().forEach(person -> {
            if (tester.test(person)) person.printPerson();
        });


    }
}
