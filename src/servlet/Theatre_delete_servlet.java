package servlet;
import services.Theatre_service;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Theatre_bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/theatre_delete_servlet")
public class Theatre_delete_servlet extends HttpServlet {

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
		int T_id=Integer.parseInt(id==null||"".equals(id)?"0":id);
		Theatre_bean a=new Theatre_bean();
		a.setId(T_id);
		Theatre_service b=new Theatre_service();
		try {
			if(b.del(a)==1)
				out.print("ok");
			else
				out.print("no-ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
