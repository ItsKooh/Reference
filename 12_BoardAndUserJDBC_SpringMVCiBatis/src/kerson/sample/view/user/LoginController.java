package kerson.sample.view.user;

import kerson.sample.biz.user.UserService;
import kerson.sample.biz.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(path="/login.do")
	public String handleRequest(UserVO vo) throws Exception {
		UserVO user = userService.getUser(vo);    
		
		if ( user.getId() != null ) {
			System.out.println("====> 로그인 성공!!");  
			return "redirect:/getBoardList.do";
		} else {
			System.out.println("====> 로그인 실패");
			return "redirect:/login.jsp";
		}   
	}
}
