package kerson.sample.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    
	@Autowired
    private BoardDAOSpring dao;
    
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
    
    @Override
    public void insertAndUpdate(BoardVO vo) {
    	insertBoard(vo);
    	updateBoard(vo);
    	
    	System.out.println(9/0);
    }
}
