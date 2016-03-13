package kerson.sample.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetBoardListController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(path="/getBoardList.do")
	public ModelAndView handleRequest(BoardVO vo, ModelAndView mav) throws Exception {
		List<BoardVO> boardList = boardService.getBoardList(vo);
		mav.setViewName("getBoardList");
		mav.addObject("boardList", boardList);
		 
		return mav;
	}

}
