import java.util.List;

public interface DataRespository<T> {

    T getData();

    List<T> getAll();

}