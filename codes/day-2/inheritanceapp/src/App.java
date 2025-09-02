public class App {
    public static void main(String[] args) throws Exception {

        Mobile onePlusMobile = new Mobile("One Plus Flip", "One Plus", 120000, 2022,
                true);

        Laptop dellLaptop = new Laptop("Dell XPS 13", "Dell", 150000, 2021, true, false);

        printDeviceInfo(onePlusMobile);
        printDeviceInfo(dellLaptop);
    }

    // device argument/parameter can store reference of any child class object
    // (Laptop/Mobile/...)
    static void printDeviceInfo(Device device) {
        System.out.println(device.getModelName());
        if (device instanceof Mobile) {
            // down-catsing
            Mobile mobile = (Mobile) device;
            System.out.println("Is flip mobile: " + mobile.getIsFlip());
        }
        if (device instanceof Laptop laptop) {
            System.out.println("Is SSD available: " + laptop.getIsSSDAvailable());
        }
    }
    // static void printDeviceInfo(Mobile mobile) {
    // System.out.println(mobile.getModelName());
    // }

    // static void printDeviceInfo(Laptop laptop) {
    // System.out.println(laptop.getModelName());
    // }
}
