package kerson.sample.view.board;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteBoardController {
	
	@Autowired 
	private BoardService boardService;
	
	@RequestMapping(path="/deleteBoard.do")
	public String handleRequest(BoardVO vo) throws Exception {
		System.out.println("====> chgDvcd : " + vo.getChgDvcd());
		System.out.println("====> seq : " + vo.getSeq()); 

		if ( "U".equals(vo.getChgDvcd()) ) {
			boardService.updateBoard(vo); 
			
		} else if ( "D".equals(vo.getChgDvcd()) ) {
			boardService.deleteBoard(vo);
		} 

		return "redirect:/getBoardList.do";
	}

}
