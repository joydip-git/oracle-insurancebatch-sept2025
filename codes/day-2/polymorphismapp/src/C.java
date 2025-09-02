public class C extends A {
    private String subject;

    public C() {
        super();
    }

    public C(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String print() {
        return getName() + ", Subject: " + subject;
    }
}
