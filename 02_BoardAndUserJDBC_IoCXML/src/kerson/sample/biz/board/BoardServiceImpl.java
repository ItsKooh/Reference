package kerson.sample.biz.board;

import java.util.List;

public class BoardServiceImpl implements BoardService {
    
    private BoardDAO dao;
    
    public BoardServiceImpl() {
        dao = new BoardDAO();
    }

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
