package application;

import entities.Account;
import entities.SaldoInsuficienteException;
import entities.LimiteSaqueExcedidoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Holder: ");
        String holder = scanner.nextLine();
        System.out.print("Initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawalLimit = scanner.nextDouble();

        Account account = new Account(number, holder, balance, withdrawalLimit);

        System.out.print("Enter amount for withdraw: ");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        } catch (SaldoInsuficienteException | LimiteSaqueExcedidoException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}