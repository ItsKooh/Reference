package kerson.sample.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kerson.sample.biz.board.BoardDAO;
import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GetBoardListController implements Controller {
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO();   
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		mav.addObject("boardList", boardList);
		
		return mav;
	}

}
