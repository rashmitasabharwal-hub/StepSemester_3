import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingSalary) {
        if (openingSalary < 0) {
            System.out.println("Warning: Opening salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Bonus must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid percentage. Must be between 0 and 100.");
        } else {
            double taxAmount = this.basicSalary * (percent / 100.0);
            this.basicSalary -= taxAmount;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class M2_Payroll {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}