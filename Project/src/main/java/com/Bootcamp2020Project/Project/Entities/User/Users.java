package com.Bootcamp2020Project.Project.Entities.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    private Boolean isDeleted = false;
    private Boolean isActive = false;
    private Boolean isExpired = false;
    private Boolean isLocked = false;

    private Integer loginStatus = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "RoleId", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses;
    public Users() {

    }

    public Users(String email, String firstName, String middleName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isDeleted=" + isDeleted +
                ", isActive=" + isActive +
                ", isExpired=" + isExpired +
                ", isLocked=" + isLocked +
                '}';
    }
    public void addAddress(Address address){
        if(address!=null){
            if(addresses == null)
                addresses = new HashSet<Address>();

            System.out.println("address added");
            address.setUsers(this);
            addresses.add(address);
        }
    }

    public void addRole(Role role){
        if(roles==null)
            roles = new HashSet<>();

        roles.add(role);
    }

    public void setLoginStatus(boolean success){
        if(success) {
            loginStatus = 1;
            this.setLocked(false);
        }
        else {
            loginStatus--;
            if(loginStatus <= -2){
                setLocked(true);
            }
        }
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public boolean isActive() {
        return isActive;
    }
}
