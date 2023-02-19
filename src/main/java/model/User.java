package model;
 
import java.io.Serializable;
 
public class User implements Serializable {
private static final long serialVersionUID = 1L;


    //フィールド
    private String email;
    private String name;
    private String pass;
    private String role;
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return pass;
    }
    public void setPassword(String password) {
        this.pass = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
