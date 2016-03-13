package kerson.sample.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kerson.sample.biz.user.UserDAO;
import kerson.sample.biz.user.UserVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("====> request.getParameter('id') : " + request.getParameter("id")); 
		System.out.println("====> request.getParameter('password') : " + request.getParameter("password")); 

		UserDAO dao = new UserDAO();

		// 3.�Է°� SET �� �޼ҵ� ȣ��
		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password")); 
		
		System.out.println("====> �Է°� : " + vo); 
		UserVO user = dao.getUser(vo);    
		System.out.println("====> ����� : " + user);
		
		if ( user.getId() != null ) {
			System.out.println("====> �α��� ����!!");
			response.sendRedirect("getBoardList.do");
		} else {
			System.out.println("====> �α��� ����");
			response.sendRedirect("login_bs.jsp");
		}
		return new ModelAndView();
	}
}
