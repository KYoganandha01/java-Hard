import java.util.*;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

    public Patient(String name, int age, String gender, String phoneNumber) {
        setName(name);
        setAge(age);
        setGender(gender);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class PatientManagementSystem {
    private List<Patient> patients;

    public PatientManagementSystem() {
        patients = new ArrayList<>();
    }

    public void registerPatient(String name, int age, String gender, String phoneNumber) {
        Patient newPatient = new Patient(name, age, gender, phoneNumber);
        patients.add(newPatient);
    }

    public void deletePatient(String name) {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.getName().equals(name)) {
                iterator.remove();
                System.out.println("Patient record deleted successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    public void updatePatient(String name, int age, String gender, String phoneNumber) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                patient.setAge(age);
                patient.setGender(gender);
                patient.setPhoneNumber(phoneNumber);
                System.out.println("Patient record updated successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientManagementSystem system = new PatientManagementSystem();

        while (true) {
            System.out.println("\nHospital Management System Menu:");
            System.out.println("1. Register Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter patient phone number: ");
                    String phoneNumber = scanner.nextLine();
                    system.registerPatient(name, age, gender, phoneNumber);
                    System.out.println("Patient registered successfully.");
                    break;
                case 2:
                    System.out.print("Enter patient name to delete: ");
                    String deleteName = scanner.nextLine();
                    system.deletePatient(deleteName);
                    break;
                case 3:
                    System.out.print("Enter patient name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new gender: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    system.updatePatient(updateName, newAge, newGender, newPhoneNumber);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
