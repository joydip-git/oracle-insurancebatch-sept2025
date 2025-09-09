import java.util.List;

public class ProductDataManager implements DataManager<Product> {
    private final DataRespository<Product> repo;

    public ProductDataManager(DataRespository<Product> repo) {
        this.repo = repo;
    }

    @Override
    public Product fetchData() {
        return repo.getData();
    }

    @Override
    public List<Product> fetchAll() {
        return repo.getAll();
    }
}
