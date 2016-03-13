package kerson.sample.biz.board;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {

    public void insertBoard(BoardVO vo);

    public void updateBoard(BoardVO vo);

    public void deleteBoard(BoardVO vo);

    public BoardVO getBoard(BoardVO vo);

    public List<BoardVO> getBoardList(BoardVO vo);

	public void insertAndUpdate(BoardVO vo);

}