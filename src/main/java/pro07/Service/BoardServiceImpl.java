package pro07.Service;


import pro07.DAO.BoardDAO;
import pro07.DTO.Board;

import javax.naming.NamingException;
import java.util.List;

public class BoardServiceImpl implements BoardService{
    private BoardDAO boardDAO = new BoardDAO();

    public BoardServiceImpl() throws NamingException {
    }

    @Override
    public List<Board> list() {
        return boardDAO.selectList();
    }

    @Override
    public Board select(int boardNo) {
        return boardDAO.select( boardNo );
    }

    @Override
    public int insert(Board board) {
        return boardDAO.insert( board );
    }

    @Override
    public int update(Board board) {
        return boardDAO.update( board );
    }

    @Override
    public int delete(int boardNo) {
        return boardDAO.delete( boardNo );
    }

    @Override
    public List<Board> pageList(int pageNo) {
        return boardDAO.selectPageList( pageNo );
    }

    @Override
    public int totalListCount() {
        return boardDAO.selectTotalCount();
    }
}
