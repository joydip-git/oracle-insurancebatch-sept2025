package com.oracle;

import java.util.List;

public class Repository implements RepositoryContract {
    @Override
    public List<Person> getPeople() {
        return List.of(new Person("joydip"), new Person("anil"));
    }

    @Override
    public Person getPerson(String name) {
        return new Person(name);
    }
}
