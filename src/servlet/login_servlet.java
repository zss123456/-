package servlet;
import bean.Login_bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于get请求的乱码解决，先采用iso8859-1编码，再使用utf-8解码
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		session.setAttribute("user", "yes");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String userpwd=request.getParameter("userpwd");
		Login_bean a=new Login_bean();
		a.setUsername(userid);
		a.setUserpassword(userpwd);
		try {
			if(a.isLogin(userid, userpwd)){
				out.print("ok");
			}
			else{
				out.print("账户或密码错误！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
