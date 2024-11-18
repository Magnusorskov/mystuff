package Name;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (middleName == null) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleName + " " + lastName;
        }
    }

    public String getInit() {
        if (middleName == null) {
            return "" + Character.toUpperCase(firstName.charAt(0)) + Character.toUpperCase(getLastName().charAt(0));
        } else {
            return "" + Character.toUpperCase(firstName.charAt(0)) + Character.toUpperCase(middleName.charAt(0))
                    + Character.toUpperCase(lastName.charAt(0));
        }
    }

    public String getUsername() {
        String username;
        if (middleName == null) {
            username = firstName.substring(0, 2).toUpperCase() + lastName.substring(lastName.length() - 1);
        } else {
            username = firstName.substring(0, 2).toUpperCase() + middleName.length() + lastName.substring(lastName.length() - 2);
        }
        return username;
    }

    public String getCryptoINIT(int count) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        char[] initials = new char[getInit().length()];
        for (int i = 0; i < getInit().length(); i++) {
            initials[i] = getInit().charAt(i);
        }
        for (int i = 0; i < initials.length; i++) {
            boolean found = false;
            for (int j = 0; j < alphabet.length && !found; j++) {
                if (alphabet[j] == initials[i]) {
                    initials[i] = alphabet[(j + count) % 26];
                    found = true;
                }
            }
        }
        return new String(initials);
    }
}


