import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            //make arrayList to store all bank names
            //make a bank object


            Cliente one = new Cliente("Pedro", 20, "pegradowski@hotmail.com", "09202376905", "pp", "BB");
            Cliente two = new Cliente("Anthony", 19, "anthony@gmail.com", "00000000000", "aa", "BB");

            ArrayList<String> allBanks = new ArrayList<String>();
            ArrayList<Cliente> allUsers = new ArrayList<Cliente>();
            allUsers.add(one);
            allUsers.add(two);
            allBanks.add("BB");

            Cliente user = null;
            //make a menu that will prompt the user to choose between 7 options:
            //1. Make new user
            //2. Withdraw money
            //3. Deposit money
            //4. Check balance
            //5. Pay a bill
            //6. Change password
            //7. Exit

            //if the user chooses option 1, prompt the user to enter their name, email1 address, CPF and password
            //if the user chooses option 2, prompt the user to enter the amount they want to withdraw
            //if the user chooses option 3, prompt the user to enter the amount they want to deposit
            //if the user chooses option 4, display the user's balance
            //if the user chooses option 5, prompt the user to enter the amount they want to pay and to what bank
            //if the user chooses option 6, prompt the user to enter their current password and then their new password
            //if the user chooses option 7, exit the program
            //if the user chooses an invalid option, display an error message

            //create a new user

            //create a scanner object
            System.out.println("Welcome to the bank! Please enter your username:");
            Scanner scanner1 = new Scanner(System.in);
            String email1 = scanner1.next();
            for (int i = 0; i < allUsers.size(); i++) {
            // Printing and display the elements in ArrayList
                if (allUsers.get(i).getEmail().equals(email1)) {
                    System.out.println("Welcome back, " + allUsers.get(i).getNome());
                    user = allUsers.get(i);
                    break;
                }
                if (i == allUsers.size()) {
                    System.out.println("You are not a registered user. Please create an account.");
                    System.out.println("Enter your name:");
                    String name = scanner1.next();
                    System.out.println("Enter your age:");
                    Integer age = scanner1.nextInt();
                    System.out.println("Enter your email1 address:");
                    String email = scanner1.next();
                    System.out.println("Enter your CPF:");
                    String cpf = scanner1.next();
                    System.out.println("Enter your password:");
                    String password = scanner1.next();
                    System.out.println("Enter the name of the bank:");
                    String bankName = scanner1.next();
                    for (int j = 0; j < allBanks.size(); j++) {
                        if (allBanks.get(j).equals(bankName)) {
                            break;
                        } else {
                            allBanks.add(bankName);
                            Banco newBank = new Banco(bankName);
                        }
                    }
                    Cliente newUser = new Cliente(name, age, email, cpf, password, bankName);
                    user = newUser;
                    break;

                }

            }
            oQueFazer(user);


    }

    public static void oQueFazer(Cliente user) {
        System.out.println("Please choose an option:");
        System.out.println("Your balance: R$ " + user.getBalance());
        System.out.println("1. Withdraw money");
        System.out.println("2. Deposit money");
        System.out.println("3. Check balance");
        System.out.println("4. Pay a bill");
        System.out.println("5. Change password");
        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the amount you want to withdraw:");
                    double amount = scanner.nextDouble();
                    user.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit:");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your balance is: " + user.getBalance());
                    break;
                case 4:
                    System.out.println("Enter the amount you want to pay:");
                    double billAmount = scanner.nextDouble();
                    user.payBill(billAmount);
                    break;
                case 5:
                    System.out.println("Enter your current password:");
                    String currentPassword = scanner.next();
                    System.out.println("Enter your new password:");
                    String newPassword = scanner.next();
                    user.updatePassword(currentPassword, newPassword);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        oQueFazer(user);
    }
}