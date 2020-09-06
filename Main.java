
/*PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
This is the main driver class of the program, by running this class you can run the entire project.
This class uses:
Medicine (-> Stock)
CrudMedicine
ValidateAdmin
Admin
*/
import java.util.Scanner;

import CONTROLLER.CrudMedicine;
import CONTROLLER.ValidateAdmin;
import MODEL.Admin;
import MODEL.Medicine;

public class Main {

    public static void main(String[] args) {
        System.out.println("***********************Welcome to Medicine ordering system*********************** \n");
        Scanner scanner = new Scanner(System.in);
        login(scanner);

        System.out.println("********************************************************************************* \n");
        System.out.println("*********************Great! you can start managing you store********************* \n");
        System.out.println("********************************************************************************* \n");

        program(scanner);

        scanner.close();
    }

    private static void login(Scanner scanner) {

        System.out.print("Hello admin, please enter your username: \n");
        String username;
        username = scanner.nextLine();
        System.out.print("now enter password: \n");
        String password = scanner.nextLine();
        System.out.print("\n validing.... \n");

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        ValidateAdmin vad = new ValidateAdmin();
        if (vad.validate(admin)) {
            System.out.print("Login successfull! \n");
        } else {
            System.out.print("Username or password incorrect! \n");
            login(scanner);
        }
    }

    private static void program(Scanner scanner) {
        System.out.println("\n\n");
        System.out.println("Press 1 to add medicine\n");
        System.out.println("Press 2 to update medicine\n");
        System.out.println("Press 3 to print all medicines\n");
        System.out.println("Enter 4 to delete medicine\n");
        System.out.println("Enter 5 to search a medicine\n");
        System.out.println("Enter 6 to Exit program \n");

        int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("Enter medicine name to add: \n");
                scanner.nextLine();
                String medName = scanner.nextLine();
                try {
                    if (new CrudMedicine().searchMedicine(medName)) {
                        System.out.println("***********Medicine already exists!");
                    } else {
                        Medicine med = new Medicine();
                        med.setName(medName);
                        new CrudMedicine().addMedicine(med);
                        System.out.println("***********medicine added successfully! \n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                program(scanner);
                break;
            case 2:
                System.out.println("Enter medicine name you want to change: \n");
                scanner.nextLine();
                Medicine before = new Medicine();
                before.setName(scanner.nextLine());
                try {
                    if (new CrudMedicine().searchMedicine(before.getName())) {
                        System.out.println("Enter new name: \n");
                        Medicine after = new Medicine();
                        after.setName(scanner.nextLine());

                        new CrudMedicine().updateMedicine(before, after);

                        System.out.println("********Updated successfully!");

                    } else {
                        System.out.println("medicine does not exist");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                program(scanner);
                break;
            case 3:
                System.out.println("***************4Printing all medicines \n");
                try {
                    new CrudMedicine().printAllMedicines();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("************************************** \n");
                program(scanner);
                break;
            case 4:
                System.out.println("Enter the name of medicine you want ot delete");
                scanner.nextLine();
                String name = scanner.nextLine();
                try {
                    if (new CrudMedicine().searchMedicine(name)) {
                        Medicine m = new Medicine();
                        m.setName(name);
                        new CrudMedicine().removeMedicine(m);
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Medicine does not exist");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                program(scanner);
                break;
            case 5:
                System.out.println("Enter the name of medicine you want ot search:");
                scanner.nextLine();
                String med = scanner.nextLine();
                try {
                    if (new CrudMedicine().searchMedicine(med)) {

                        System.out.println("Medicine " + med + " exists");
                    } else {
                        System.out.println("Medicine " + med + " does not exist");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                program(scanner);
                break;
            case 6:
                System.out.println("\n*********************************************************\n");
                System.out.println("*************Thank you for using our program*************\n");
                System.out.println("*********************************************************\n");
                System.exit(0);
            default:
                System.out.println("Please enter a valid number\n");
                program(scanner);
                break;
        }
    }
}