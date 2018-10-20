package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Seat_service;
import bean.Seat_bean;

@WebServlet("/seat_delete_servlet")
public class Seat_delete_servlet extends HttpServlet {

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
		String id=request.getParameter("id");
		int S_id=Integer.parseInt(id==null||"".equals(id)?"0":id);
		String number=request.getParameter("number");
		String start=request.getParameter("start");
		Seat_bean a=new Seat_bean();
		a.setS_id(S_id);
		a.setS_number(number);
		a.setS_start(start);
		Seat_service b=new Seat_service();
		int n=b.del(a);
		if(n==1)
			out.print("ok");
		else
			out.print("no-ok");
	}
}
