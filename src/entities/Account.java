package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawalLimit;

    public Account(int number, String holder, double balance, double withdrawalLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawalLimit = withdrawalLimit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
    }

    public void withdraw(double amount) throws SaldoInsuficienteException, LimiteSaqueExcedidoException {
        if (amount > withdrawalLimit) {
            throw new LimiteSaqueExcedidoException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > balance) {
            throw new SaldoInsuficienteException("Withdraw error: Not enough balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}