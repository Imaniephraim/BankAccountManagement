package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //create scanner object
        Scanner scanner = new Scanner(System.in);

        //create a new bank object
        Bank cplBank = new Bank();

        //a variable to save the user choice from the menu
        int userChoice;

        do {
            System.out.println("\n1. Add Account");
            System.out.println("2, Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // consumes the new line character

            switch (userChoice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("Enter initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();  //consumes new line character

                    System.out.print("Enter The Account Type (e.g Savings, Checking): ");
                    String accountType = scanner.nextLine();

                    cplBank.addAccount(accountNumber, accountHolderName, balance, accountType);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = cplBank.getAccount(accountNumber);

                    if (account != null) {
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account Not Found!!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);

                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter the account number: ");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Transaction History For Account: " + accountNumber);
                        List<String> transactions = account.getTransactionHistory();
                        for (String transaction : transactions){
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("Account not found !!!");
                    }
                    break;
                case 5:
                    System.out.println("Exit The Program.... ");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter choice between 1 and 4.");
            }
        }while (userChoice != 4) ;


            //close the scanner object
            scanner.close();


    }
}


