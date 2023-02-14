package model;
 
import dao.DAOException;
import dao.MemberDao;
 
public class RegisterUserLogic {
  MemberDao memberDao = new MemberDao();
    public boolean exute(User user){
        boolean registCheck = false;
        //登録処理
        try {
            memberDao.insertMember(user);
            registCheck = true;
        } catch (DAOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return registCheck;
    }
}