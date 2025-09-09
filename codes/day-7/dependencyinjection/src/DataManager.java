
import java.util.List;

public interface DataManager<T> {
    T fetchData();

    List<T> fetchAll();
}
