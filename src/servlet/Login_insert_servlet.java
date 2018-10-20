package servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import services.Login_service;
import bean.Login_bean;

@WebServlet("/login_insert_servlet")
public class Login_insert_servlet extends HttpServlet {

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
		String pwd=request.getParameter("password");
		String tel=request.getParameter("telephone");
		String email=request.getParameter("email");
		Login_bean a=new Login_bean();
		int n=0;
		a.setEmail(email);
		a.setTelephone(tel);
		a.setUsername(name);
		a.setUserpassword(pwd);
		Login_service b=new Login_service();
		n=b.add(a);
		if(n==1){
			SimpleEmail emaill=new SimpleEmail();
			emaill.setSSL(true);
			emaill.setHostName("smtp.qq.com");
			emaill.setAuthentication("1042940891", "hpwdlaqqiwylbbjg");
			try{
				
				emaill.addTo(email);
				emaill.setFrom("1042940891@qq.com");
				emaill.setSubject("注册成功！");
				emaill.setMsg("恭喜您，注册成功！您的账号为："+name+",密码为："+pwd+",请妥善保管！");
				emaill.send();
				out.print("ok");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else
			out.print("no-ok");
	}
}
