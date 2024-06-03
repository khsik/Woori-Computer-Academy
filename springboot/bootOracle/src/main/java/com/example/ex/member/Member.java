package com.example.ex.member;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

	@Id
	private String id;
	
	@Nonnull
	private String pw;
	
	@Column(unique = true)
	@Nonnull
	private String email;
	
	@Nonnull
	private String gender;
	
	@Nonnull
	private String country;
	
	@Nonnull
	private List<String> hobbies;
}
