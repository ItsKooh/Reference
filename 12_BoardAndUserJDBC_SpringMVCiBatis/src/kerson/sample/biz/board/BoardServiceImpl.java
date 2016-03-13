package kerson.sample.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    
	@Autowired
    private BoardDAOIBatis dao;
    
    @Override
    public void insertBoard(BoardVO vo) throws SQLException {
        dao.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) throws SQLException {
        dao.updateBoard(vo);
    } 

    @Override
    public void deleteBoard(BoardVO vo) throws SQLException {
        dao.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) throws SQLException {
        return dao.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
        return dao.getBoardList(vo);
    }
}
