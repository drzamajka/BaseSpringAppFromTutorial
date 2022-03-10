package com.example.basespringappfromtutorial;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Developer")
public class Developer {

    @Id
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="firstName", nullable=false, length=255)
	private String firstName;
	@Column(name="lastName", nullable=false, length=255)
	private String lastName;
	@Column(name="email", nullable=false, length=255)
	private String email;
	@ManyToMany
	private List<Skill> skills;

	public Developer() {
		super();
	}

	public Developer(String firstName, String lastName, String email,
			List<Skill> skills) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.skills = skills;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public boolean hasSkill(Skill skill) {
		for (Skill containedSkill: getSkills()) {
			if (containedSkill.getId() == skill.getId()) {
				return true;
			}
		}
		return false;
	}

}
