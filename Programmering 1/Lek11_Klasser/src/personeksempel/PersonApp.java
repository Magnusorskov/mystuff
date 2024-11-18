package personeksempel;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Magnus");
        p1.setName("Magneser");
        System.out.println(p1.getName());
        p1.setAddress("Andebyvej 22");
        System.out.println(p1.getAddress());
        p1.setMonthlySalary(100000);
        System.out.println(p1.getMonthlySalary());
        System.out.println("------------");
        System.out.println("Print person:");
        p1.setCompanies(22);
        p1.newCompany();
        p1.printPerson();

    }



}
