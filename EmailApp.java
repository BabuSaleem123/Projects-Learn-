package EmailApplication;
import java.io.FileWriter;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        //User info
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String f_name = sc.next();
        System.out.println(":Enter last name");
        String l_name = sc.next();

        //creating object for email
        Email eml = new Email(f_name,l_name);
        int choice = -1;
        do {
            System.out.println("\n**********\nEnter your Choice\n1. Show Info \n2. Change Password \n3. Change Email Capacity \n4. Set Alternate mail \n5. Store Data in a file \n6. Display stored data \n7. Exit");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    eml.getInfo();
                    break;
                case 2:
                    eml.changePassword();
                    break;
                case 3:
                    eml.setCap();
                    break;
                case 4:
                    eml.alternateMail();
                    break;
                case 5:
                    eml.storeFile();
                    break;
                case 6:
                    eml.readFile();
                    break;
                case 7:
                    System.out.println("Thanks for using this application");
                    break;
                default:
                    System.out.println("Invalid chocw! \nEnter the choice again");
            }
        }
        while (choice!=7);

    }
}
