package com.ex.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyTestDTO {
	private String username;
	private String password;
	private LocalDate birth;
	private int age;
	private LocalDateTime reg;
}

/*
create table mytest(
    username varchar2(50) primary key,
    password varchar2(50),
    birth date,
    age number,
    reg date default sysdate
);
*/