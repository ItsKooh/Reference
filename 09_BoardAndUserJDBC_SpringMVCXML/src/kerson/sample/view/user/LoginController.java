package kerson.sample.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kerson.sample.biz.user.UserService;
import kerson.sample.biz.user.UserVO;

public class LoginController implements Controller {
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("====> id : " + request.getParameter("id"));
		System.out.println("====> password : " + request.getParameter("password"));

		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		UserVO user = userService.getUser(vo);    
		
		ModelAndView mav = new ModelAndView();
		
		if ( user.getId() != null ) {
			System.out.println("====> 로그인 성공!!");  
			mav.setViewName("getBoardList.do");
		} else {
			System.out.println("====> 로그인 실패");
			mav.setViewName("login.jsp");
		}  
		
		return mav;
	}
}
