package com.francis.entities;
abstract class Staff {
    private String name;
    private int age;
    private String email;
    private int id;
    private String address;
    private double salary;

    public Staff(String name, int age, String email, int id, String address, double salary) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
        this.address = address;
        this.salary = salary;
    }

    public Staff() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}

