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

		// 3.입력값 SET 및 메소드 호출
		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password")); 
		
		System.out.println("====> 입력값 : " + vo); 
		UserVO user = dao.getUser(vo);    
		System.out.println("====> 결과값 : " + user);
		
		if ( user.getId() != null ) {
			System.out.println("====> 로그인 성공!!");
			response.sendRedirect("getBoardList.do");
		} else {
			System.out.println("====> 로그인 실패");
			response.sendRedirect("login_bs.jsp");
		}
		return new ModelAndView();
	}
}
