package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Userinfo;
import util.Md5Utils;
import dao.UserinfoDao;
import dao.UserinfoDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet.do", urlPatterns = { "/LoginServlet.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAccount=request.getParameter("userAccount");
		String passwd = request.getParameter("passwd");
		passwd = Md5Utils.md5(passwd);
		UserinfoDao  uDao = new UserinfoDaoImpl();
		Userinfo user = uDao.findByAccount(userAccount);
		if(user != null){
			if(passwd.equals(user.getUserPass())){
				if(user.getLocked()==0)
				{
					//会话
					HttpSession session = request.getSession(true);
					session.setAttribute("userAccount", userAccount);
					if(user.getRole() == 0){
						response.sendRedirect("manager/manager.jsp");
					}else if(user.getRole() == 1){
						response.sendRedirect("cooker/cooker.jsp");
					}else if(user.getRole() == 2){
						response.sendRedirect("waiter/waiter.jsp");					    
					}
				}
				else
				{
					request.setAttribute("errMsg", "您的账号被锁定，请联系人事经理！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
	
			}else{
				request.setAttribute("errMsg", "用户名不存在或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}else {
			request.setAttribute("errMsg", "用户名不存在或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
