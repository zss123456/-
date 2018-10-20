package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Login_service;
import bean.Login_bean;

@WebServlet("/login_delete_servlet")
public class Login_delete_servlet extends HttpServlet {

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
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		int n=0;
		Login_bean g=new Login_bean();
		g.setUsername(name);
		Login_service d=new Login_service();
		n=d.del(g);
		if(n==1){
			out.print("删除成功！");
		    response.setHeader("refresh", "1;url=http://localhost:8080/TTMS/main-interface.html");
	}
		else{
			out.print("删除失败！");
			response.setHeader("refresh", "1;url=http://localhost:8080/TTMS/main-interface.html");
		}
		}
}
