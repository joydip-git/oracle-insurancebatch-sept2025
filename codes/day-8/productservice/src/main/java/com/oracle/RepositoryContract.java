package com.oracle;

import java.util.List;

public interface RepositoryContract {

    List<Person> getPeople();

    Person getPerson(String name);

}