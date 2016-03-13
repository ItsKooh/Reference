package kerson.sample.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kerson.sample.biz.board.BoardDAO;
import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GetBoardController implements Controller {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();    
		System.out.println("====> 입력값 : " + request.getParameter("seq"));
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		System.out.println("====> 입력값 : " + vo.toString());

		BoardVO board = boardService.getBoard(vo);
		System.out.println("====> 결과값 : " + board.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard.jsp");
		mav.addObject("board", board); 
		
		return mav;   
	}

}
