import java.time.LocalDate;

public class DrivingLicenseApplication {
    private String name;
    private LocalDate dateOfBirth;
    private int age;

    public DrivingLicenseApplication() {
    }

    public DrivingLicenseApplication(String name, LocalDate dateOfBirth) throws AgeLessThanPermissibleLimitException {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        computeAge();
    }

    private void computeAge() throws AgeLessThanPermissibleLimitException {
        LocalDate currentDate = LocalDate.now();
        age = currentDate.getYear() - dateOfBirth.getYear();
        if (age < 18)
            throw new AgeLessThanPermissibleLimitException(age + " <- current age less than permissible limit of 18");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws AgeLessThanPermissibleLimitException {
        this.dateOfBirth = dateOfBirth;
        computeAge();
    }

    public int getAge() {
        return age;
    }
}
