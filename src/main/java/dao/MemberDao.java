package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
 
public class MemberDao {
 
    private Connection con = null;  // コネクションオブジェクト
    private Statement stmt = null;  // ステートメントオブジェクト
    private ConnectionManager cm; // コネクションマネージャー
 
    // Connectionの取得
    private void getConnection() throws DAOException{
        if ( this.con != null ){ return;    }
        cm = ConnectionManager.getInstance();
        con = cm.getConnection(); // データベースへの接続の取得
    }
 
    // Statementの取得
    private void createStmt() throws DAOException{
        if ( this.stmt != null){    return; }
        try {
            stmt =con.createStatement();
        } catch (SQLException e) {  // SQLに関する例外処理
            throw new DAOException("[createStmt]異常", e);
        }
    }
 
    // データを追加
    public int insertMember(User user) throws DAOException {
        getConnection();
        int count = 0;
        String sql = "INSERT INTO users (email, password, name, role) VALUES(?, ?, ?, 'user')";
        
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
 
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            count += pstmt.executeUpdate();
        } catch(SQLException e) {
            throw new DAOException("[UserDAO#insertMember]異常", e);
        } finally {
            close();
        }
        return count;
    }
    
    public User findByLoginInfo(String email, String password, String role) {
        User user = null;

        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ? " )) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            
            //rs:SQL文(pstmt)を実行した結果が格納されている
            ResultSet rs = pstmt.executeQuery();
            //System.out.println(rs);
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
            //System.out.println(user);
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public List<User> findAll() {
    	List<User> users = new ArrayList<>();
    	User user = null;
    	try (Connection con = ConnectionManager.getInstance().getConnection();
    	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");
    	ResultSet rs = pstmt.executeQuery()) {
    		if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
    	return users;
    	}
    
    private void close() throws DAOException {
        try {
            if (stmt != null) { stmt.close(); }
        } catch (SQLException e) {
            throw new DAOException("[closeStatement]異常", e);
        } finally {
            this.stmt = null;
            this.cm = null;
        }
    }
}