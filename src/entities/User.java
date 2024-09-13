package entities;

import enums.Role;


public class User {

    // Instance variables
    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;

    // Constructor
    public User(String firstName, String lastName, Role role, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    // No setter for ID to prevent manual modification

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "User{\n" +
                "\tid=" + id +",\n"+
                "\tfirstName= '" + firstName + '\'' +",\n"+
                "\tlastName= '" + lastName + '\'' +",\n"+
                "\trole= " + role +",\n"+
                "\temail= " + email +",\n"+
                '}';
    }
}
