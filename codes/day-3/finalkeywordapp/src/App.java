public class App {
    public static void main(String[] args) throws Exception {
        final String message = "Hello, World !!!";
        // message = "";
        System.out.println(message);
        System.out.println(B.COMPANY_NAME);

        B instanceOfB = new B(100);
        System.out.println(instanceOfB.printInfo());

        // get the reference of instance of Class<B> which stores metedata of B class

        // a. using .class property with the class name
        // Class<B> instanceRef = B.class;

        // b. using getClass() method (inherited from Object class by every
        // class/interface) on the instance
        Class<?> instanceReference = instanceOfB.getClass();
        // if (instanceRef == instanceReference) {
        // System.out.println("same");
        // }
        System.out.println("Type Name: " + instanceReference.getTypeName());
        System.out.println("Is interface: " + instanceReference.isInterface());
        System.out.println("Name: " + instanceReference.getSimpleName());
    }
}
