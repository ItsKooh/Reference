package kerson.sample.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boardService")
public class BoardServiceImpl implements BoardService {
    
	@Autowired
    private BoardDAO dao;
    
    @Override
    public void insertBoard(BoardVO vo) {
        dao.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        dao.updateBoard(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        dao.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return dao.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return dao.getBoardList(vo);
    }
    
    

}
