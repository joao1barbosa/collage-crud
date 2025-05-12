package dto;

import java.util.Date;

public class StudentPublicDTO {
    private int registration;
    private String name;
    private String phone;
    private Date birthdate;
    private String course;

    public StudentPublicDTO(){}

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

}
