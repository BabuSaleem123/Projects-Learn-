package EmailApplication;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.security.PublicKey;
import java.util.Random;
import java.util.Scanner;

public class Email {
    Scanner sc = new Scanner(System.in);
    private String fname;
    private String lname;
    private String email;
    private String dept;
    private String password;
    private String alter_email;
    private int mailcapacity = 500;

    Email(String fname, String lname)
    {
        this.fname = fname;
        this.lname = lname;

        //Calling methods
        this.dept = this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateMail();
    }

    private String generateMail()
    {
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept+"company.com";
    }

    private String setDept()
    {
        System.out.println("Department codes \n1 for FS OPS \n2 IT \n3 for Algo \n4 Accounting \5 BD \n0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter the Department Code");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    return "FS OPS";
                case 2:
                    return "IT";
                case 3:
                    return "Algo";
                case 4:
                    return "Accounts";
                case 5:
                    return "BD";
                case 0:
                    return "None";
                default:
                    System.out.println("invalid choice please choose it again");
            }
        }
        while (!flag);
        {
            return null;
        }
    }
    private String generatePassword(int len)
    {
        Random r = new Random();
        String CapitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallChar = "abcdefghiklmnopqrstuvwxyz";
        String Numbers = "123456789";
        String Symbols = "~!@#$%^&*?<>";
        String values = CapitalChar+SmallChar+Numbers+Symbols;
        String password = "";
         for (int i=0; i<len; i++){
             password = password+values.charAt(r.nextInt(values.length()));
         }
         return password;
    }
    public void changePassword()
    {
        boolean flag = false;
        do {
            System.out.println("Do you wan to change Password ?");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y')
            {
                flag = true;
                System.out.println("Enter Current Password");
                String temp = sc.next();
                if (temp.equals(this.password))
                {
                    System.out.println("Enter new password");
                    this.password = sc.next();
                    System.out.println("Password changed successfully");
                }
                else {
                    System.out.println("Incorrect Password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled");
            }
            else System.out.println("Enter a valid choice");
        }
        while (!flag);
    }
    //Set mailbox capacity
    public void setCap()
    {
        System.out.println("Corrent Capacity = " + this.mailcapacity);
        System.out.println("Enter new mailbox capacity");
        this.mailcapacity = sc.nextInt();
        System.out.println("Mailbox Capacity is successfully updated");
    }
    public void alternateMail()
    {
        System.out.println("Enter the alernate Email");
        this.alter_email = sc.next();
        System.out.println("Alternate email is set successfully");
    }

    public void getInfo()
    {
        System.out.println("New : "+this.fname+" "+this.lname);
        System.out.println("Email : "+this.email);
        System.out.println("Department : "+this.dept);
        System.out.println("Password :"+this.password);
        System.out.println("Mail box capacity :"+this.mailcapacity);
        System.out.println("Alternate email :"+this.alter_email);
    }
    //Store in a file
    public void storeFile()
    {
        try {
            FileWriter fl = new FileWriter("C:\\Users\\babus\\Downloads\\Document.rtf");
            fl.write("First name : "+this.fname);
            fl.append("\nLast name : "+this.lname);
            fl.append("\nEmail : "+this.email);
            fl.append("\nPassword : "+this.password);
            fl.append("\nCapacity : "+this.mailcapacity);
            fl.append("\nAlternate email : "+this.alter_email);
            fl.close();
            System.out.println("Data Stored");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //read file
    public void readFile()
    {
        try {
            FileReader fr = new FileReader("C:\\Users\\babus\\Downloads\\Document.rtf");
            int i;
            while ((i=fr.read())!=-1){
                System.out.print((char) i);
            }
            System.out.println();
            fr.close();
        }
        catch (Exception e){System.out.println(e);
        }

    }


}
