public class Mobile extends Device {
    private boolean isFlip;

    public Mobile() {
    }

    public Mobile(String modelName, String brandName, double price, int makeYear, boolean isFlip) {
        super(modelName, brandName, price, makeYear);
        this.isFlip = isFlip;
    }

    public boolean getIsFlip() {
        return isFlip;
    }

    public void setIsFlip(boolean isFlip) {
        this.isFlip = isFlip;
    }
}
