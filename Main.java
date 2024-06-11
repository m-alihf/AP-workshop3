import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Address {
    private String zipCode;
    private String country;
    private String city;

    public Address(String country, String city, String zipCode) {
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Address(String city) {
        this.city = city;
    }

    public Address() {
    }

    public String getZipCode() {
        if (this.zipCode == null) {
            this.zipCode = "no input";
        }
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        if (this.country == null) {
            this.country = "no input";
        }
        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getCity() {
        if (this.city == null) {
            this.city = "no input";
        }
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private boolean nullFinder(String input) {
        if (input == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String info = "";
        if (this.country == null) {
            this.country = "no input";
        }
        if (this.city == null) {
            this.city = "no input";
        }
        if (this.zipCode == null) {
            this.zipCode = "no input";
        }
        info += "Your contry is: " + country + "\nYour city is: " + city + "\nZipe code: " + zipCode + "\n";
        return info;
    }
}


public class Contact {
    private PhoneNumber phoneNumber;
    private Address address;
    private String group;
    private String email;
    private String firstName;
    private String lastName;

    public Contact(PhoneNumber phoneNumber, Address address, String firstName, String lastName, String group, String email) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.email = email;
    }

    public Contact(PhoneNumber phoneNumber, Address address, String firstName, String lastName, String group) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Contact(Contact contact) {
        this.phoneNumber = contact.phoneNumber;
        this.address = contact.address;
        this.firstName = contact.firstName;
        this.lastName = contact.lastName;
        this.group = contact.group;
        this.email = contact.email;
    }

    public Contact(PhoneNumber phoneNumber, Address address, String firstName, String lastName) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGroup() {
        if (this.group == null) {
            this.group = "no input";
        }
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        if (this.email == null) {
            this.email = "no input";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        if (this.firstName == null) {
            this.firstName = "no input";
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        if (this.lastName == null) {
            this.lastName = "no input";
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String hold = "";
        hold += "Full Name: " + firstName + " " + lastName;
        if (email == null) {
            email = "no input";

        }
        if (group == null) {
            group = ("no input");
        }
        hold += "\nEmail: " + email;
        hold += "\ngroup: " + group + "\n";
        hold += phoneNumber;
        hold += "\n" + address;
        System.out.println(address);
        return hold;
    }
}


public class MenuType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        try {
            while (true) {
                menu();
                int x = scanner.nextInt();
                if (x == 1) {
                    System.out.print("Enter the firstName:");
                    String firstName = scanner.next();
                    System.out.print("Enter the lastName:");
                    String lastName = scanner.next();
                    System.out.print("Enter the group:");
                    String group = scanner.next();
                    System.out.print("Enter your email:");
                    String email = scanner.next();
                    System.out.print("Enter you country code:");
                    String countryCode = scanner.next();
                    String number = "";
                    while (true) {
                        System.out.print("Enter your number(just valid number):");
                        number = scanner.next();
                        if (number.length() != 10) {
                            System.out.println("not valid");
                            System.out.print("Try again:");
                        } else
                            break;
                    }
                    System.out.print("Enter the Country:");
                    String country = scanner.next();
                    System.out.print("Enter the city:");
                    String city = scanner.next();
                    System.out.print("Enter the zipcode:");
                    String zipecode = scanner.next();
                    Contact firstOne = new Contact(new PhoneNumber(countryCode, number), new Address(country, city, zipecode), firstName, lastName, group, email);
                    if (phoneBook.addContact(firstOne)) {
                        System.out.println("\n****Add successfully****\n");
                    } else
                        System.out.println("\n****the contact already exits****\n");
                } else if (x == 2) {
                    System.out.print("Enter the firstName:");
                    String firstName = scanner.next();
                    System.out.print("Enter the lastName:");
                    String lastName = scanner.next();
                    if (phoneBook.deleteContact(firstName, lastName)) {
                        System.out.println("\n****delete successfully****\n");
                    } else
                        System.out.println("\n****the contact doesn't exist****\n");
                } else if (x == 3) {
                    System.out.print("Enter the firstName:");
                    String firstName = scanner.next();
                    System.out.print("Enter the lastName:");
                    String lastName = scanner.next();
                    System.out.println(phoneBook.findContact(firstName, lastName));
                } else if (x == 4) {
                    phoneBook.printContact();
                } else if (x == 5) {
                    break;
                } else
                    System.out.println("\n****invalid input****\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Bru Enter a number");
        }


    }

    private static void menu() {
        System.out.println("1_add contact");
        System.out.println("2_delete contact");
        System.out.println("3_find contact");
        System.out.println("4_show All contacts");
        System.out.println("5_Exit");
        System.out.print("Enter your choose:");
    }
}


public class PhoneBook {
    private Contact[] contacts;

    public PhoneBook() {
        this.contacts = new Contact[100];
    }

    public PhoneBook(Contact contacts) {
        this.contacts = new Contact[100];
        int i;
        for (i = 0; i < this.contacts.length && this.contacts[i] != null; i++) {
        }
        this.contacts[i] = contacts;
    }

    public PhoneBook(Contact[] contacts) {
        this.contacts = new Contact[100];
        for (int i = 0; i < this.contacts.length && this.contacts[i] != null && contacts[i] != null; i++) {
            this.contacts[i] = contacts[i];
        }
    }

    public boolean addContact(Contact contact) {
        int i;
        for (i = 0; i < this.contacts.length && this.contacts[i] != null; i++) {
            if (this.contacts[i].getFirstName().equals(contact.getFirstName()) && this.contacts[i].getLastName().equals(contact.getLastName())) {
                return false;
            }
        }
        this.contacts[i] = new Contact(contact);
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        int i = 0;
        int j = 0;
        for (i = 0; i < this.contacts.length && this.contacts[i] != null; i++) {
            if (this.contacts[i].getFirstName().equals(firstName) && this.contacts[i].getLastName().equals(lastName)) {
                for (j = i; j < this.contacts.length - 1 && this.contacts[i] != null; j++) {
                    this.contacts[j] = this.contacts[j + 1];
                }
                this.contacts[j] = null;
                return true;
            }
        }
        return false;
    }

    public Contact findContact(String firstName, String lastName) {
        for (int i = 0; i < contacts.length && contacts[i] != null; i++) {
            if (contacts[i].getFirstName().equals(firstName) && contacts[i].getLastName().equals(lastName))
                return contacts[i];
        }
        return null;
    }

    public Contact[] findContacts(String group) {
        Contact[] hold = new Contact[100];
        for (int i = 0, j = 0; i < contacts.length && contacts[i] != null; i++) {
            if (contacts[i].getGroup().equals(group)) {
                hold[j] = contacts[i];
                j++;
            }
        }
        return hold;
    }

    public void printContact() {
        if (contacts[0] == null) {
            System.out.println("\n***your phonebook is empty***\n");
        } else {
            for (int i = 0; i < contacts.length && contacts[i] != null; i++) {
                System.out.printf("%d*******************************************\n", i+1);
                System.out.println("Full Name: " + contacts[i].getFirstName() + " " + contacts[i].getLastName());
                if (contacts[i].getEmail() == null) {
                    contacts[i].setEmail("-");
                }
                if (contacts[i].getGroup() == null) {
                    contacts[i].setGroup("-");
                }
                System.out.println("Email: " + contacts[i].getEmail());
                System.out.println("Group: " + contacts[i].getGroup());
                System.out.println(contacts[i].getPhoneNumber());
                System.out.println(contacts[i].getAddress());
            }
        }

    }

    public void printContact(Contact[] contacts) {
        for (int i = 0; i < contacts.length && contacts[i] != null; i++) {
            System.out.println("Full Name: " + contacts[i].getFirstName() + " " + contacts[i].getLastName());
            if (contacts[i].getEmail() == null) {
                contacts[i].setEmail("-");
            }
            if (contacts[i].getGroup() == null) {
                contacts[i].setGroup("-");
            }
            System.out.println("Email: " + contacts[i].getEmail());
            System.out.println("Group: " + contacts[i].getGroup());
            System.out.println(contacts[i].getPhoneNumber());
            System.out.println(contacts[i].getAddress());
        }

    }
}


public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        setNumber(number);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() != 10) {
            System.out.println("invalid number");
            return;
        }
        this.number = number;
    }
    @Override
    public String toString() {
        String info = "";
        info += "Your number is : (" + countryCode+") " + number;
        return info;
    }
}



public class Main {
    public static void main(String[] args) {
        // for having menu run the MenuType Class



        //testing the PhoneNumber class
        PhoneNumber P1 = new PhoneNumber("099", "9494949494"); //creating the PhoneNumber class
        System.out.println(P1.getCountryCode());                                //getter setter class
        P1.setCountryCode("022");
        System.out.println(P1.getCountryCode());
        System.out.println(P1.getNumber());
        P1.setNumber("232");                                                    //test invalid number
        P1.setNumber("2323232323");
        System.out.println(P1.getNumber());
        System.out.println(P1);                                                 //test toSting method
        System.out.println();


        //testing the Address class
        Address A1 = new Address("Mashad", "Iran", "324234324");//creating object
        Address A2 = new Address("Usa", "torento");
        Address A3 = new Address("kerman");
        System.out.println(A1.getCountry() + " " + A1.getCity() + " " + A1.getZipCode());//testing getter method
        System.out.println(A2.getZipCode());                                        //testing empty field
        A2.setZipCode("099");                                                       //testing set method
        A2.setCountry("UK");
        A2.setCity("landon");
        System.out.println(A2.getCountry() + " " + A2.getCity() + " " + A2.getZipCode());
        System.out.println();
        System.out.println(A1);                                                     //testing to sting method
        System.out.println(A3);


        //testing contact class
        Contact firstOne = new Contact(new PhoneNumber("098", "9307359198"),//creating object
                new Address("IRAN", "TEHRAN", "1234567890"),
                "Amir Hossein", "Motaghian", "family", "AmirHossein98@gmail.com");//full info
        Contact secondOne = new Contact(new PhoneNumber("098", "9306165863"),
                new Address("USA", "NewYork"),
                "jacob", "jimi", "friends");             //no email
        Contact thirdOne = new Contact(P1, A1, "ahmad", "rezaii");//no group and email
        System.out.println(firstOne.getPhoneNumber() + " " + firstOne.getAddress() + "" + firstOne.getFirstName() + " " + firstOne.getLastName()
                + " " + firstOne.getGroup() + " " + firstOne.getEmail());//testing getters
        System.out.println(secondOne.getEmail());
        secondOne.setEmail("asjdflalskdjfljasldf@gmail.com");//test setter
        System.out.println(secondOne.getEmail());
        System.out.println();


        //testing our phone book
        PhoneBook phoneBook = new PhoneBook();//create phone book
        phoneBook.printContact();
        if (phoneBook.addContact(firstOne)) {               //test add method
            System.out.println("added successfully");
        } else
            System.out.println("the contact is already in book");
        if (phoneBook.addContact(firstOne)) {               //test an existing person to add
            System.out.println("added successfully");
        } else
            System.out.println("the contact is already in book");       //add other
        if (phoneBook.addContact(secondOne)) {
            System.out.println("added successfully");
        } else
            System.out.println("the contact is already in book");
        if (phoneBook.addContact(thirdOne)) {
            System.out.println("added successfully");
        } else
            System.out.println("the contact is already in book");
        System.out.println();
        phoneBook.printContact();//print contact method
        if (phoneBook.deleteContact("Amir Hossein", "Motaghian")) {//test delete contact method
            System.out.println("deleted successfully");
        } else
            System.out.println("there is no guy with this information ");
        if (phoneBook.deleteContact("Amir Hossein", "Motaghian")) { //test delete contact method on a student that does not exist
            System.out.println("deleted successfully");
        } else
            System.out.println("there is no guy with this information ");
        System.out.println();
        phoneBook.printContact();
        System.out.println(phoneBook.findContact("amir", "asd"));               // test findContact  method
        System.out.println(phoneBook.findContact("ahmad", "rezaii"));
        if (phoneBook.addContact(firstOne)) {
            System.out.println("added successfully");
        } else
            System.out.println("the contact is already in book");
        phoneBook.printContact(phoneBook.findContacts("family"));//test findContacts method
    }
}