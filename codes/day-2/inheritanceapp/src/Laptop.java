public class Laptop extends Device {
    private boolean isHDDAvailable;
    private boolean isSSDAvailable;

    public Laptop() {
    }

    public Laptop(String modelName, String brandName, double price, int makeYear, boolean isHDDAvailable,
            boolean isSSDAvailable) {
        super(modelName, brandName, price, makeYear);
        this.isHDDAvailable = isHDDAvailable;
        this.isSSDAvailable = isSSDAvailable;
    }

    public boolean isIsHDDAvailable() {
        return isHDDAvailable;
    }

    public void setIsHDDAvailable(boolean isHDDAvailable) {
        this.isHDDAvailable = isHDDAvailable;
    }

    public boolean isIsSSDAvailable() {
        return isSSDAvailable;
    }

    public void setIsSSDAvailable(boolean isSSDAvailable) {
        this.isSSDAvailable = isSSDAvailable;
    }
}
