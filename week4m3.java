public class StudentAccount {
    private String regNo;
    private double totalFee;

    public StudentAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // Final method preventing overriding in subclasses
    public final double calculateLateFee(int daysLate) {
        // Late fee is calculated at 1% per day late
        return this.totalFee * 0.01 * daysLate;
    }

    // Final method preventing overriding in subclasses
    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(this.regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(this.regNo + " | Total Fee: Rs " + this.totalFee + " | Late Fee: Rs " + lateFee);
        }
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        // Single pass batch processing
        for (int i = 0; i < regNos.length; i++) {
            StudentAccount account = new StudentAccount(regNos[i], totalFees[i]);
            account.printSummary(daysLate[i]);
        }
    }
}