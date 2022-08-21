package com.example.springboot.bean;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
       private String student_no;
       private String the_password;
       private String institute;
       private Integer grade;
       private String the_class;
       private String the_name;
       public String getStudent_no(){
           return student_no;
       }
       public String getThe_password(){
           return the_password;
       }
       public String getThe_class(){
           return the_class;
       }
       public String getInstitute(){
           return institute;
       }
       public Integer getGrade(){
           return grade;
       }
       public String getThe_name() {
        return the_name;
       }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public void setThe_password(String password) {
        this.the_password = the_password;
    }

    public void setThe_name(String name) {
        this.the_name = the_name;
    }
    public void setInstitute(String institute){
           this.institute=institute;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setThe_class(String the_class) {
        this.the_class = the_class;
    }
    public User(){}
    public User(String student_no,String the_password,String institute,Integer grade,String the_class,String the_name){
        this.student_no = student_no;
        this.the_password=the_password;
        this.institute=institute;
        this.grade=grade;
        this.the_class=the_class;
        this.the_name=the_name;
    }
}
