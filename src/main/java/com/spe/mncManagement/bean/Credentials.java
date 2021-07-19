package com.spe.mncManagement.bean;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="credentials")
@Data
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private Long empId;


    @Column(name = "user_type", nullable = false)
    private String user_type;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public Credentials(Long empid, String username, String password, String user_type) {
        this.empId = empid;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }

    public Credentials( String username, String password,String user_type) {
        this.user_type = user_type;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "empid=" + empId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_type='" + user_type + '\'' +
                '}';
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empid) {
        this.empId = empid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }



    public Credentials() {}

}
