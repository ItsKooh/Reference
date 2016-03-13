package kerson.sample.view.board;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetBoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(path="/getBoard.do")
	public ModelAndView handleRequest(BoardVO vo, ModelAndView mav) throws Exception {
		System.out.println("====> 입력값 : " + vo.toString());
		BoardVO board = boardService.getBoard(vo);
		System.out.println("====> 결과값 : " + board.toString());
		
		mav.setViewName("getBoard");
		mav.addObject("board", board); 
		
		return mav;   
	}

}
