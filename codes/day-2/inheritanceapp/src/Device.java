public class Device {
    private String modelName;
    private String brandName;
    private double price;
    private int makeYear;

    public Device(String modelName, String brandName, double price, int makeYear) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.price = price;
        this.makeYear = makeYear;
    }

    public Device() {
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }
}