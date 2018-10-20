package servlet;
import bean.Theatre_bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.Theatre_service;

@WebServlet("/theatre_update_servlet")
public class Theatre_update_servlet extends HttpServlet {

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
		HttpSession session=request.getSession();
		int oid=(int)session.getAttribute("id");
		String id=request.getParameter("id");
		int T_id=Integer.parseInt(id==null||"".equals(id)?"0":id);
		String T_name=request.getParameter("name");
		String rows=request.getParameter("rows");
		int T_row=Integer.parseInt(rows==null||"".equals(rows)?"0":rows);
		String cols=request.getParameter("cols");
		int T_cols=Integer.parseInt(cols==null||"".equals(cols)?"0":cols);
		String T_desc=request.getParameter("desc");
        Theatre_bean a=new Theatre_bean();
        a.setId(T_id);
        a.setCols(T_cols);
        a.setDesc(T_desc);
        a.setName(T_name);
        a.setRows(T_row);
        Theatre_service b=new Theatre_service();
        try {
        	int n;
			if(b.upd(a, oid)==1)
				out.print("ok");
			else
				out.print("no-ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
