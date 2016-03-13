package kerson.sample.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kerson.sample.biz.board.BoardDAO;
import kerson.sample.biz.board.BoardVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		
		BoardVO vo = new BoardVO();    
		System.out.println("====> 입력값 : " + request.getParameter("seq"));
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		System.out.println("====> 입력값 : " + vo.toString());

		BoardVO board = dao.getBoard(vo);
		System.out.println("====> 결과값 : " + board.toString());
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		response.sendRedirect("getBoard.jsp");
		
		return new ModelAndView();
	}

}
