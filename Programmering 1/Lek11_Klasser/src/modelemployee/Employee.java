package modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 */
public class Employee {
    /*
     * Attributter der beskriver den ansattes tilstand
     */
    private String firstName;
    private boolean trainee;
    private int age;
    private String lastName;

    /*
     * Constructor, når den ansatte oprettes, skal den have et navn. Ved
     * oprettelse er den ansatte en trainee
     */
    public Employee(String inputFirstName, String inputLastName, int inputAge) {
        firstName = inputFirstName;
        trainee = true;
        age = inputAge;
        lastName = inputLastName;
    }

    public Employee() {

    }

    /*
     * Den ansattes navn kan ændres ved kald af setName metoden
     */
    public void setName(String inputName) {
        firstName = inputName;
    }

    /*
     * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
     */
    public String getName() {
        return firstName;
    }

    public void setLastName(String inputLastName) {
        lastName = inputLastName;
    }

    public String getLastName() {
        return lastName;
    }

    /*
     * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
     */
    public void setTrainee(boolean isTrainee) {
        trainee = isTrainee;
    }

    /*
     * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
     * isTrainee
     */
    public boolean isTrainee() {
        return trainee;
    }

    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
        System.out.println("Trainee: " + trainee);
		System.out.println("Age: " + age);
        System.out.println("*******************");
    }


    /*
     * Returnerer en kort tekst repræsentation af objektet
     */
    public String toString() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int inputAge) {
        age = inputAge;
    }

    public void birthday() {
        age++;
    }
}

