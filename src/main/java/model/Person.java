package model;

public abstract class Person {
    protected String nin;
    protected String name;
    protected String surname;

    public Person(String nin, String name, String surname) {
        this.nin = nin;
        this.name = name;
        this.surname = surname;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
