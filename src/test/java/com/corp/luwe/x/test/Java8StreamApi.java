package com.corp.luwe.x.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamApi {

	public static void main(String[] args) {
		new Java8StreamApi();
	}

	public Java8StreamApi() {
		sobrenomesDosUsuariosAtivos(
			new User(11, "Nick", "Smith", false), 
			new User(89, "Ken", "Pratt", true), 
			new User(23, "Jack", "Sparrow", true)
		).forEach(System.out::println);
	}
	
	private List<String> sobrenomesDosUsuariosAtivos(User... users) {
		
		return Arrays.asList(users).stream()
			.filter(user -> user.getActive())
			.sorted((user1, user2) -> Integer.compare(user1.getId(), user2.getId()))
			.map(user -> user.getLastName())
			.collect(Collectors.toList());
	}
	
}

class User {
	public int	   id;
	public String  firstName;
	public String  lastName;
	public Boolean active;

	public User(int id, String firstName, String lastName, Boolean active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + "]";
	}
	
}