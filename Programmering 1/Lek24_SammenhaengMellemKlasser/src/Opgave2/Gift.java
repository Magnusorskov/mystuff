package Opgave2;

public class Gift {
    private String description;
    private double price;
    private Person givenBy;

    public Gift(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Person getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(Person person) {
        if (givenBy != person) {
            givenBy = person;
        }
    }

    @Override
    public String toString() {
        return description;
    }
}
