package servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Film_bean;
import dao.Film_dao;

@WebServlet("/yourclassname")
public class Test extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于get请求的乱码解决，先采用iso8859-1编码，再使用utf-8解码
		doPost(request, response);
		//response.setContentType("image/jpeg");
		Film_dao a=new Film_dao();
		Film_bean b=new Film_bean();
		b.setName("西邮快车");
	    Film_bean d=a.find(b);
	    byte[] c=d.getUrl();
	    File g=new File("F:/3/3.jpg");
	    FileOutputStream h=new FileOutputStream(g);
	    BufferedOutputStream baos=new BufferedOutputStream(h);
	    baos.write(c);
		/*ServletOutputStream sos=response.getOutputStream();
		response.setContentLength(c.length);
		sos.write(c);
		sos.close();*/

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码

	}
}
