package pro07.Service;


import pro07.DTO.Board;

import java.util.List;

public interface BoardService {
    List<Board> list();
    Board select( int boardNo );
    int insert( Board board );
    int update(Board board);
    int delete(int boardNo );
    List<Board> pageList( int pageNo );
    int totalListCount();
}
