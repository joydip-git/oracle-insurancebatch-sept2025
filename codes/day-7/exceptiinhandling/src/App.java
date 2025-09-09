
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        try {
            DrivingLicenseApplication applicationForm = new DrivingLicenseApplication("anil",
                    LocalDate.of(2010, 3, 23));
            System.out.println(applicationForm.getAge());
            int res = divide(12, 3);
            System.out.println(res);
            String data = getDataFromFile("");
            System.out.println(data);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AgeLessThanPermissibleLimitException e) {
            System.out.println("error message: "+e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // you can access ONLY the members of Exception base class as present in the
            // child class obejct
            e.printStackTrace();
        }
    }

    static int divide(int first, int second) {
        if (second == 0) {
            ArithmeticException e = new ArithmeticException("divisor should not be zero");
            throw e;
        }
        return first / second;
    }

    static String getDataFromFile(String filePath) throws FileNotFoundException, Exception {

        if (filePath.isBlank() || filePath.isEmpty())
            throw new Exception("file path is either blank or empty");

        FileReader reader = new FileReader(filePath);
        reader.close();

        return "data from file";
    }
}
