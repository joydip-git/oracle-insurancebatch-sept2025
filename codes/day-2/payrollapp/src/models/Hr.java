package models;
public class Hr extends Employee {
    private double gratuityPayment;

    public Hr(int id) {
        super(id);
    }

    public Hr(int id, String name, double basicPayment, double daPayment, double hraPayment, double gratuityPayment) {
        super(id, name, basicPayment, daPayment, hraPayment);
        this.gratuityPayment = gratuityPayment;
    }

    public double getGratuityPayment() {
        return gratuityPayment;
    }

    public void setGratuityPayment(double gratuityPayment) {
        this.gratuityPayment = gratuityPayment;
    }

    @Override
    public void calculateSalary() {
        super.calculateSalary();
        setTotalPayment(gratuityPayment + getTotalPayment());
    }
}
