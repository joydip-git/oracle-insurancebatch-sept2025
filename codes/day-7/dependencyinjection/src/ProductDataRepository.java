
import java.util.List;

public class ProductDataRepository implements DataRespository<Product>{
    
    @Override
    public Product getData() {
        return new Product();
    }

    @Override
    public List<Product> getAll() {
        return List.of(new Product(), new Product());
    }
    
}
