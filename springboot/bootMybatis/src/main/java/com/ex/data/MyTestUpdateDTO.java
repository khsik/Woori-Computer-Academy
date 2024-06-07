package com.ex.data;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MyTestUpdateDTO {
	private String username;
	private String orgPassword;
	private String newPassword1;
	private String newPassword2;
	private LocalDate birth;
	private int age;
}
