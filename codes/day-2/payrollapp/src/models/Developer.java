package models;

public class Developer extends Employee {
    private double incentivePayment;

    public Developer(int id) {
        super(id);
    }

    public Developer(int id, String name, double incentivePayment, double basicPayment, double daPayment,
            double hraPayment) {
        super(id, name, basicPayment, daPayment, hraPayment);
        this.incentivePayment = incentivePayment;
    }

    public double getIncentivePayment() {
        return incentivePayment;
    }

    public void setIncentivePayment(double incentivePayment) {
        this.incentivePayment = incentivePayment;
    }

    @Override
    public void calculateSalary() {
        super.calculateSalary();
        double total = getTotalPayment() + this.incentivePayment;
        setTotalPayment(total);
    }
}
