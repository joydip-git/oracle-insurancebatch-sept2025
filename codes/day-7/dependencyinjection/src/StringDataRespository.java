
import java.util.List;

// @Deprecated(since = "this is an old repository. use the new repository")
public class StringDataRespository implements DataRespository <String>{
    @Override
    public String getData() {
        return "data";
    }

    @Override
    public List<String> getAll() {
        return List.of("anil", "sunil");
    }
}
