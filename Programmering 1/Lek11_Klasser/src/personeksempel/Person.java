package personeksempel;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int companies;

    public Person(String inputName) {
        name = inputName;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String inputAdress) {
        address = inputAdress;
    }

    public String getAddress() {
        return address;
    }

    public void setMonthlySalary(double inputMonthlySalary) {
        monthlySalary = inputMonthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void printPerson() {
        System.out.println(name);
        System.out.println(address);
        System.out.println("Monthly salary: " + monthlySalary);
        System.out.println("Companies: " + companies);
        System.out.println("Yearly salary: " + yearlySalary());
    }

    public double yearlySalary(){
        return monthlySalary * 12 * 1.025;
    }

    public void setCompanies(int inputPrevCompanies) {
        companies = inputPrevCompanies;
    }

    public int getCompanies(){
        return companies;
    }

    public void newCompany(){
        companies++;
    }
    }
