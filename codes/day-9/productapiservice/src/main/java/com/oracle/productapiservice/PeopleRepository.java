package com.oracle.productapiservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
//import org.jvnet.hk2.annotations.Service;

//@Service
public class PeopleRepository implements Repository<Person> {
	private static final List<Person> people = new ArrayList<Person>();

	public PeopleRepository() {
		System.out.println("repository created");
	}

	@Override
	public Person fetch(int id) throws Exception {
		if (people.isEmpty())
			throw new Exception("no records present");

		if (!people.stream().anyMatch(p -> p.getId() == id))
			throw new Exception("person with id " + id + " does not exist");
		else {
			Optional<Person> found = people.stream().filter(p -> p.getId() == id).findFirst();
			return found.get();
		}
	}

	@Override
	public List<Person> fetchAll() throws Exception {
		if (people.isEmpty())
			throw new Exception("no records found");
		else
			return people;
	}

	@Override
	public Person insert(Person person) throws Exception {

		if (!people.isEmpty()) {
			Predicate<Person> isPresent = (p) -> p.getId() == person.getId();
			if (people.stream().anyMatch(isPresent)) {
				throw new Exception("person with id: " + person.getId() + " exists");
			}
		}
		people.add(person);
		return person;
	}

	@Override
	public Person remove(int personId) throws Exception {
		if (people.isEmpty())
			throw new Exception("no records present");
		else {
			if (!people.stream().anyMatch(p -> p.getId() == personId))
				throw new Exception("person with id " + personId + " does not exist");
			else {
				Optional<Person> found = people.stream().filter(p -> p.getId() == personId).findFirst();
				Person p = found.get();
				boolean status = people.remove(p);
				return status ? p : null;
			}
		}
	}

	@Override
	public Person modify(int id, Person data) throws Exception {
		if (people.isEmpty())
			throw new Exception("no records at all");
		else {
			if (!people.stream().anyMatch(p -> p.getId() == id))
				throw new Exception("person with id " + id + " does not exist");
			else {
				Optional<Person> found = people.stream().filter(p -> p.getId() == id).findFirst();
				Person p = found.get();
				p.setName(data.getName());
				return p;
			}
		}
	}
}
