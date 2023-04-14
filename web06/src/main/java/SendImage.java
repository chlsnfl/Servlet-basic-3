

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SendImage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//서블릿과 컨테이너의 연동에 사용됨, 서블릿끼리의 자원 공유
		ServletContext sc = getServletContext();
		
		try(InputStream is = sc.getResourceAsStream("images/desert-g97cc09207_1920.jpg")){
			
			OutputStream os = res.getOutputStream();
			if(is==null) {
				res.setContentType("text/plain");
				os.write("Failed to send Image".getBytes());
			}else {
				res.setContentType("image/jpeg");
				byte[] buffer = new byte[1024];
				int byteRead;
				
				while((byteRead = is.read(buffer))!=-1) {
					os.write(buffer,0,byteRead);
				}
			}
		}
	}
		
	}

