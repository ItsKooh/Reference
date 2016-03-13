package kerson.sample.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {

    public void insertBoard(BoardVO vo) throws SQLException;

    public void updateBoard(BoardVO vo) throws SQLException;

    public void deleteBoard(BoardVO vo) throws SQLException;

    public BoardVO getBoard(BoardVO vo) throws SQLException;

    public List<BoardVO> getBoardList(BoardVO vo) throws SQLException;
}