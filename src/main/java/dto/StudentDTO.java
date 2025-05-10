package dto;

import java.time.LocalDate;

public class StudentDTO {
    private String name;
    private int registration;
    private String phone;
    private LocalDate birthdate;
    private String course;

    public StudentDTO(
            String name,
            int registration,
            String phone,
            LocalDate birthdate,
            String course
    ) {
        this.name = name;
        this.registration = registration;
        this.phone = phone;
        this.birthdate = birthdate;
        this.course = course;
    }

    public String getName() { return name; }
    public int getRegistration() { return registration; }
    public String getPhone() { return phone; }
    public LocalDate getBirthdate() { return birthdate; }
    public String getCourse() { return course; }
}