package Opgave2;

public class App {
    public static void main(String[] args) {
        // Generating 5 people
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        Person person3 = new Person("Charlie", 28);
        Person person4 = new Person("Diana", 22);
        Person person5 = new Person("Edward", 35);

        // Generating 10 gifts
        Gift gift1 = new Gift("Book");
        gift1.setPrice(20.0);
        gift1.setGivenBy(person1);
        person1.addGift(gift1);
        Gift gift2 = new Gift("Laptop");
        gift2.setPrice(800.0);
        gift2.setGivenBy(person2);

        Gift gift3 = new Gift("Watch");
        gift3.setPrice(150.0);
        gift3.setGivenBy(person3);

        Gift gift4 = new Gift("Perfume");
        gift4.setPrice(60.0);
        gift4.setGivenBy(person4);

        Gift gift5 = new Gift("Guitar");
        gift5.setPrice(300.0);
        gift5.setGivenBy(person5);

        Gift gift6 = new Gift("Headphones");
        gift6.setPrice(50.0);
        gift6.setGivenBy(person1);

        Gift gift7 = new Gift("Backpack");
        gift7.setPrice(45.0);
        gift7.setGivenBy(person2);

        Gift gift8 = new Gift("Smartphone");
        gift8.setPrice(600.0);
        gift8.setGivenBy(person3);

        Gift gift9 = new Gift("Jacket");
        gift9.setPrice(75.0);
        gift9.setGivenBy(person4);

        Gift gift10 = new Gift("Shoes");
        gift10.setPrice(85.0);
        gift10.setGivenBy(person5);

        // Printing details for verification
//        System.out.println(person1 + " has given " + gift1 + ", " + gift6);
//        System.out.println(person2 + " has given " + gift2 + ", " + gift7);
//        System.out.println(person3 + " has given " + gift3 + ", " + gift8);
//        System.out.println(person4 + " has given " + gift4 + ", " + gift9);
//        System.out.println(person5 + " has given " + gift5 + ", " + gift10);
        System.out.println(person1.thankYouNoteList());
    }
}

