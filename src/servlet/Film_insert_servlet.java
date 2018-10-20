package servlet;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Film_bean;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


import services.Film_service;

@WebServlet("/film_insert_servlet")
@MultipartConfig
public class Film_insert_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletConfig config;

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
		try {
		SmartUpload us=new SmartUpload();
		PrintWriter out=response.getWriter();
		us.initialize(this.config, request, response);
		us.setAllowedFilesList("gif,bmp,jpg");
		us.setMaxFileSize(6*1024*1024);
		us.setTotalMaxFileSize(10*1024*1024);
		us.upload();
		String F_director=us.getRequest().getParameter("dir");
		String F_type=us.getRequest().getParameter("type");
		String F_region=us.getRequest().getParameter("reg");
		String F_language=us.getRequest().getParameter("lan");
		String F_performer=us.getRequest().getParameter("per");
		String F_time=us.getRequest().getParameter("temp");
		String F_name=us.getRequest().getParameter("name");
		com.jspsmart.upload.File f=us.getFiles().getFile(0);
		String path="F:/123/";
		String u_name=f.getFileName();
		path+=u_name;
		f.saveAs(path);
		File g=new File(path);
		byte[] T_url=null;
		FileInputStream in=new FileInputStream(g);
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		byte[] b=new byte[1000];
		int n;
		while((n=in.read(b))!=-1){
			baos.write(b, 0, n);
		}
		baos.close();
		in.close();
		T_url=baos.toByteArray();
		Film_bean a=new Film_bean();
		a.setDirector(F_director);
		a.setLanguage(F_language);
		a.setName(F_name);
		a.setPerformer(F_performer);
		a.setRegion(F_region);
		a.setTime(F_time);
		a.setType(F_type);
		a.setUrl(T_url);
		int r=0;
		Film_service q=new Film_service();
		r=q.add(a);
		if(r==1){
           out.print("添加成功");
           response.setHeader("refresh", "1;url=main-interface.html");
		}
		else{
	      out.print("添加失败");
	      response.setHeader("refresh", "1;url=main-interface.html");
		}
		}
		catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    
	    }
	}
	public void init(ServletConfig config)throws ServletException{
    	this.config=config;
	}
		/*FileInputStream input=new FileInputStream(f);
		FileOutputStream output=new FileOutputStream("f:/2/2.jpg");
		int in=input.read();
		while(in!=-1){
		output.write(in);
		in=input.read();
		}
		byte[] T_url=null;
		FileInputStream in=new FileInputStream(f);
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		byte[] b=new byte[1000];
		int n;
		while((n=in.read(b))!=-1){
			baos.write(b, 0, n);
		}
		baos.close();
		in.close();
		T_url=baos.toByteArray();
		Film_bean a=new Film_bean();
		a.setDirector(F_director);
		a.setLanguage(F_language);
		a.setName(F_name);
		a.setPerformer(F_performer);
		a.setRegion(F_region);
		a.setTime(F_time);
		a.setType(F_type);
		a.setUrl(T_url);
		int r=0;
		Film_service q=new Film_service();
		r=q.add(a);
		if(r==1){
           out.print("添加成功");
           response.setHeader("refresh", "1;url=main-interface.html");
		}
		else{
	      out.print("添加失败");
	      response.setHeader("refresh", "1;url=main-interface.html");
		}*/
	}
			

