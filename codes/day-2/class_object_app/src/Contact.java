public class Contact {
    private int id;
    private String name;
    private String location;
    private String emailid;
    private long mobileNo;

    public Contact(int id) {
        this.id = id;
    }

    public Contact(String emailid, int id, String location, long mobileNo, String name) {
        this.emailid = emailid;
        this.id = id;
        this.location = location;
        this.mobileNo = mobileNo;
        this.name = name;
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
