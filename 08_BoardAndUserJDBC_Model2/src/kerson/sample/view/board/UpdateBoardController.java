package kerson.sample.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kerson.sample.biz.board.BoardDAO;
import kerson.sample.biz.board.BoardVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();

		System.out.println("====> chgDvcd : " + request.getParameter("chgDvcd"));
		System.out.println("====> seq : " + request.getParameter("seq")); 

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		if ( "U".equals(request.getParameter("chgDvcd")) ) {
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			
			System.out.println("====> 입력값 : " + vo.toString());
			
			dao.updateBoard(vo);
			
		} else if ( "D".equals(request.getParameter("chgDvcd")) ) {
			System.out.println("====> 입력값 : " + vo.toString());
			
			dao.deleteBoard(vo);
		}

		response.sendRedirect("getBoardList.do");
		
		return new ModelAndView();
	}

}
