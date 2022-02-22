package com.motadata.Task4;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by rahil on 21/12/21.
 */
public class DatabaseAccess extends ActionSupport
{
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String confirm_password;
    private String auth;
    private String status;
    private String department;
    private String rolegroup;
    private String description;
    public String execute()throws Exception{
        System.out.println("here");
        System.out.println("jdbc connection");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Task4?autoReconnect=true&useSSL=false", "root", "Mind@123");

        try {

            try {
                Statement st = con.createStatement();
                int value = st
                        .executeUpdate("INSERT INTO userInfo(name,surname,username,email,password,confirm_password,auth,status,department,rolegroup,description) "
                                + "VALUES('"
                                + getName()
                                + "','"
                                + getSurname()
                                + "','"
                                + getUsername()
                                + "','"
                                + getEmail()
                                + "','"
                                + getPassword()
                                + "','"
                                + getConfirm_password()
                                + "','"
                                + getAuth()
                                + "','"
                                + getStatus()
                                + "','"
                                + getDepartment()
                                + "','"
                                + getRolegroup()
                                + "','"
                                + getDescription()
                                +
                                "')");
            } catch (SQLException ex) {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResultSet rs = getRS();


        return SUCCESS;
    }
    public ResultSet getRS() throws SQLException
    {
        ResultSet rs=null;
        Connection conupd=null;
        try {
            conupd = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Task4?autoReconnect=true&useSSL=false", "root", "Mind@123");
            String sql = "select * from userInfo";
            PreparedStatement ps = conupd.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conupd!= null) {
                conupd.close();
            }
        }

    }
    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRolegroup() {
        return rolegroup;
    }

    public void setRolegroup(String rolegroup) {
        this.rolegroup = rolegroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
