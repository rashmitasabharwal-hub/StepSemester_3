class FeeAccount {
    public void printPaymentInfo() {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void printPaymentInfo() {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class BatchPaymentProcessor {
    private int hostelCount = 0;
    private int dayScholarCount = 0;

    public void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.printPaymentInfo();
            hostelCount++;
        } else if (account instanceof FeeAccount) {
            account.printPaymentInfo();
            dayScholarCount++;
        }
    }

    public void printSummary() {
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000;
        BatchPaymentProcessor processor = new BatchPaymentProcessor();

        // Single pass payment processing with type-checking via instanceof
        for (FeeAccount acc : accounts) {
            processor.processPayment(acc, amount);
        }

        processor.printSummary();
    }
}