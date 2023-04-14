

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns= {"/Login"}, initParams = {@WebinitParam(name="addEmail", vlaue = "we)})
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userEmail = req.getParameter("email");
		String userPassword = req.getParameter("password");
		
		String addEmail = getInitParameter("email");
		String addPass = getInitParameter("password");

		
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out =res.getWriter();
		out.println("<html><head><title>정보출력</title></head><body>");
		
		if(userEmail.equals(addEmail) && userPassword.equals(addPass))	{
			out.println("<script>alert('"+userEmail+"관리자님 반갑습니다.');location.href = 'admin'; </script>");
//			res.sendRedirect("admin");
		}else {
			out.println("<script>alert('입력한 정보가 틀렸습니다.');history-go(-1);</script>");
//			res.sendRedirect("login.html");
		}
				
		out.println("<ul>");
		out.println("<li><label>이메일</label>"+userEmail+"</li>");
		out.println("<li><label>비밀번호</label>"+userPassword+"</li>");
		out.println("<li><label>관리자 이메일</label>"+addEmail+"</li>");
		out.println("<li><label>관리자 비밀번호</label>"+addPass+"</li>");
		out.println("</ul></body></html>");
		

		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
