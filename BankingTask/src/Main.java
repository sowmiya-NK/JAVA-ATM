import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int balance = 10000;
    private static List<Integer> debitList = new ArrayList<>();
    private static List<Integer> credtitList = new ArrayList<>();

    public static void getBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void credit(int credit) {
        balance += credit;
        credtitList.add(credit);
        getBalance();
    }

    public static void debit(int debit) {
        if (debit > balance) {
            System.out.println("Insufficient Balance!!!");
        } else {
            balance -= debit;
            debitList.add(-debit); // Add negative value to represent debit
            getBalance();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---------------Banking Application------------------");
            System.out.println("1. Debit\n2. Credit\n3. Current Balance\n4.view Transaction\n5. Exit");
            System.out.println("----------Please Enter your choice-----------");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How many debit entries do you want?");
                    int d = scanner.nextInt();
                    while (d > 0) {
                        System.out.println("Enter debit amount");
                        int debit = scanner.nextInt();
                        debit(debit);
                        d--;
                    }
                    break;

                case 2:
                    System.out.println("How many credit entries do you want?");
                    int c = scanner.nextInt();
                    while (c > 0) {
                        System.out.println("Enter credit amount");
                        int credit = scanner.nextInt();
                        credit(credit);
                        c--;
                    }
                    break;

                case 3:
                    getBalance();
                    break;

                case 4:
                    System.out.println("Debits: " + debitList);
                    System.out.println("credits: " + credtitList);
                    System.out.println("current balance: " + balance);
                    break;

                case 5:
                    System.out.println("Thank you!!!!!!");
                    break;

                default:
                    System.out.println("Please enter a correct choice");
            }
        } while (choice != 5);
    }
}
