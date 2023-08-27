package com.francis.entities;

public class Manager extends Staff{
    private String office;

    public Manager(String office, String name, int age, String email, int id, String address, double salary) {
        super(name, age, email, id, address, salary);
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "office='" + office + '\'' +
                '}';
    }
}
