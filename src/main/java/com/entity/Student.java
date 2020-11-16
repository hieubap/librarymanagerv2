package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mssv;
    private String cource;
    private String institute;
    private String phone;
    private boolean gender;


    public Student(){}

    public Student(long id, String name, String mssv) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
    }

    public void setAll(Student student){
        if (student.getName() != null)
        this.name = student.getName();
        if (student.getCource() != null)
        this.cource = student.getCource();
        if (student.getInstitute() != null)
        this.institute = student.getInstitute();
        if (student.getPhone() != null)
        this.phone = student.getPhone();

        this.gender = student.gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
