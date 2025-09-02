public class App {
    public static void main(String[] args) throws Exception {
        int x = 10;
        add(x);
        // Contact c = new Contact();
        Contact c = null;
        // c = new Contact(1, "John Doe", "New York", "john.doe@example.com",
        // 9090909090L);
        // c.id=100;
        c = new Contact(100);
        c.setName("joydip");
        c.setMobileNo(9090909090L);
        c.setEmailid("joydip@oracle.com");
        c.setLocation("Bangalore");
        // c.company = "Oracle";

        System.out.println(
                "Id: " + c.getId()
                        + ", Name: " + c.getName()
                        + ", Location: " + c.getLocation()
                        + ", Email: " + c.getEmailid()
                        + ", Mobile: " + c.getMobileNo());
    }

    static void add(int a) {
        int res = a + 10;
        System.out.println(res);
    }
}
