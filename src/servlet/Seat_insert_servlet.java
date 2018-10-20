package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Seat_bean;
import services.Seat_service;

@WebServlet("/seat_insert_servlet")
public class Seat_insert_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于get请求的乱码解决，先采用iso8859-1编码，再使用utf-8解码
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码0
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		int T_id=Integer.parseInt(id==null|"".equals(id)?"0":id);
		String number=request.getParameter("number");
		String state=request.getParameter("state");
		String start=request.getParameter("start");
		Date e=new Date();
		Seat_bean t=new Seat_bean();
		t.setS_id(T_id);
		t.setS_number(number);
		t.setS_state(state);
		t.setS_time(e.toLocaleString());
		t.setS_start(start);
        Seat_service a=new Seat_service();
        a.add(t);
	}
}
