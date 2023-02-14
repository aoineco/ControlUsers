package model;
 
import java.io.Serializable;
 
public class User implements Serializable {
 
    //フィールド
    private String email;
    private String name;
    private String pass;
 
    public User(){}
    public User(String email, String password, String name){
        this.email = email;
        this.name = password;
        this.pass = name;
    }
 
    //アクセッサ
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return pass;
    }
}