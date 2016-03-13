package kerson.sample.view.board;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertBoardController {  

	@Autowired
	private BoardService boardService;

	@RequestMapping(path="/insertBoard.do")
	public String handleRequest(BoardVO vo) throws Exception {
		System.out.println("====> ÀÔ·Â°ª : " + vo.toString());
		boardService.insertBoard(vo);
		return "redirect:/getBoardList.do";
	}

}
