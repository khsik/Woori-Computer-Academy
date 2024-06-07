package com.ex.data;

import java.time.LocalDateTime;

import lombok.Data;

/*
create table myboard(
   num         number         primary key,
   writer      varchar2(100),
   title      varchar2(100),
   content      varchar2(4000),
   passwd      varchar2(100),
   readCount   number         default 0,
   ref         number,
   re_step      number,
   re_level   number,
   reg         date         default sysdate
);
create sequence myboard_seq nocache;
*/

@Data
public class BoardDTO {
    private int num; 
    private String writer;
    private String title;
    private String content;
    private String passwd;
    private int readCount;
    private int ref;
    private int re_step;   
    private int re_level;
    private LocalDateTime reg;
}
