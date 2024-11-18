package Opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        gifts = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Gift addGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.add(gift);
        }
        return gift;
    }

    public double totalValueOfGifts() {
        double sum = 0;
        for (Gift gift : gifts) {
            sum += gift.getPrice();
        }
        return sum;
    }

    public void removeGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.remove(gift);
        }
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public ArrayList<Person> thankYouNoteList() {
        ArrayList<Person> thankYouNotes = new ArrayList<>();
        for (Gift gift : gifts) {
            if (!thankYouNotes.contains(gift.getGivenBy())) {
                thankYouNotes.add(gift.getGivenBy());
            }
        }
        return thankYouNotes;
    }

}
