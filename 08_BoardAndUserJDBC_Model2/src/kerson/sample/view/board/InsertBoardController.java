package kerson.sample.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kerson.sample.biz.board.BoardDAO;
import kerson.sample.biz.board.BoardVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));    
		
		System.out.println("====> ÀÔ·Â°ª : " + vo.toString());
		
		dao.insertBoard(vo);
		
		response.sendRedirect("getBoardList.do");  
		
		return new ModelAndView();
	}

}
