package servlet;

import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;


@WebServlet("/LoginServlet")
public class LoginUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
 
        //フォワード先
        String forwardPath = "WEB-INF/jsp/loginForm.jsp";

        // 設定されたフォワード先を設定
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jspから入力されたメールアドレスとパスワードを取得
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // UserDaoのfindByLoginInfo()メソッドを呼び出す
        MemberDao userDao = new MemberDao();
        User user = userDao.findByLoginInfo(email, password, role);
        String forwardPath = null;
        
        

        // ログイン成功時
        if (user != null) {
            // セッションにユーザの情報を保存
        	HttpSession session = request.getSession();
        	String userRole = user.getRole();
        	System.out.println("userrole: " + userRole);
        	System.out.println("test2");
            session.setAttribute("user", user);
            
            
            
            if("user".equals(userRole)) {
            	forwardPath = "WEB-INF/jsp/loginSuccess.jsp";
            }else if("admin".equals(userRole)) {
            	
                List<User> users = userDao.findAll();
                for (User i : users) {
                    System.out.println(i.getEmail());
                }
                System.out.println("test");
                request.setAttribute("users", users);
                forwardPath = "WEB-INF/jsp/admin.jsp";
            }
            //System.out.println(forwardPath);
            System.out.println("test1");
            // ログイン成功画面へフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
            dispatcher.forward(request, response);
        } else{
            // ログイン失敗時
            request.setAttribute("errorMessage", "メールアドレスまたはパスワードが正しくありません");

            // ログイン画面へフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}

