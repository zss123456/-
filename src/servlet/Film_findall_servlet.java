package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Film_base_service;
import services.Film_service;
import bean.Film_base_bean;
import bean.Film_bean;
import dao.Film_dao;

@WebServlet("/film_findall_servlet")
public class Film_findall_servlet extends HttpServlet {

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
		ArrayList<Film_bean> t=new ArrayList<>();
		Film_service b=new Film_service();
		t=b.all();
		Film_base_service c=new Film_base_service();
		PrintWriter out=response.getWriter();
		out.print(c.findAll(t).toString());
	}
}
