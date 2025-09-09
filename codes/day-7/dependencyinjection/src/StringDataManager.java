import java.util.List;

public class StringDataManager implements  DataManager<String>{
    //pass the reference of an instance of any class which implements the DataRepository interface 
    //this instance will be shared by every method
    private final DataRespository<String> repo;

    public StringDataManager(DataRespository<String> repo) {
        this.repo = repo;
    }

    @Override
    public String fetchData() {
        return repo.getData();
    }
    
    @Override
    public List<String> fetchAll(){
        return repo.getAll();
    }
}