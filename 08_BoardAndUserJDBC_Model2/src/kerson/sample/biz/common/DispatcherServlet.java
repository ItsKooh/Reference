package kerson.sample.biz.common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 0.���ڵ� ����
			request.setCharacterEncoding("EUC-KR");
			
			// 1.PATH �˻�
			String uri = request.getRequestURI();
			String path = uri.substring(uri.lastIndexOf("/"));
			
			// 2.HandlerMapping���� Controller GET
			HandlerMapping handlerMapping = new HandlerMapping();
			Controller controller = handlerMapping.getController(path);
			
			// 3.Controller ȣ��
			ModelAndView modelAndView = controller.handleRequest(request, response);
			
			// 4.��°� SET  
			
			// 5.��� �������� redirect
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}
}
