public class Contact {
    private int id;
    private String name;
    private String location;
    private String emailid;
    private long mobileNo;
    // String company;

    // public Contact() {
    // }
    public Contact(int id) {
        this.id = id;
    }

    public Contact(int id, String name, String location, String emailId, long mobileNo) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.emailid = emailId;
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
