package model;

import java.sql.Date;

public class Student {
    private int id;
    private int registration;
    private String name;
    private String phone;
    private Date birthdate;
    private String course;
    private String cpf;

    public Student(){}

    public Student(
            int registration,
            String name,
            String phone,
            Date birthdate,
            String course,
            String cpf
    ){
        this.registration = registration;
        this.name = name;
        this.phone = phone;
        this.birthdate = birthdate;
        this.course = course;
        this.cpf = cpf;
    }

    public int getId() { return id; }

    public int getRegistration() { return registration; }
    public void setRegistration(int registration) { this.registration = registration; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getBirthdate() { return birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
