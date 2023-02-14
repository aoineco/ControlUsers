package servlet;
 
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RegisterUserLogic;
import model.User;
 
/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
 
        //フォワード先
        String forwardPath = null;
 
        //サーブレットクラスの動作を決定する「action」の値を
        //リクエストパラメータから取得
        String action = request.getParameter("action");
 
        //「登録の開始」をリクエストされたときの処理
        if(action == null){
            //フォワード先を設定
            forwardPath = "/WEB-INF/jsp/registerForm.jsp";
        }
        //登録確認画面から「登録実行」をリクエストされたときの処理
        else if(action.equals("done")){
        	//registerDone.jspでactionのパラメータを`done`にしている
        	
            //registerUser:セッションスコープに保存された登録ユーザ
            HttpSession session = request.getSession();
            User registerUser = (User)session.getAttribute("registerUser");
 
            //登録処理の呼び出し
            RegisterUserLogic logic = new RegisterUserLogic();
            logic.exute(registerUser);
 
            //不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("registerUser");
 
            //登録後のフォワード先を設定
            forwardPath = "/WEB-INF/jsp/registerDone.jsp";
 
        }
 
        // 設定されたフォワード先を設定
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //registerFormからPostされた
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      doGet(request, response);
 
        //HTTPリクエストで送られてきたパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
 
        //登録するユーザの情報を設定
        User registerUser = new User(email, password, name);
 
        //セッションスコープに登録ユーザを保存
        HttpSession session = request.getSession();
        session.setAttribute("registerUser", registerUser);
 
        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
        dispatcher.forward(request, response);
    }
}