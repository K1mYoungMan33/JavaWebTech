package pro07.DAO;

import pro07.DAO.JDBCConnection;
import pro07.DTO.Board;
import pro07.DTO.User;

import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends JDBCConnection {
    SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public UserDAO() throws NamingException {
    }

    public User select(String userid) {
        User user = new User();
        String sql = "SELECT * "
                + " FROM User"
                + " WHERE userid = ?";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString( 1, userid );
            rs = psmt.executeQuery();

            if ( rs.next() ) {
                user.setUserid(rs.getString( "userid" ) );
                user.setUsername( rs.getString( "username" ) );
                user.setPassword( rs.getString( "password" ) );
            }
            else
            {
                System.out.println( "사용자가 없습니다.");
            }
        }catch ( SQLException e ) {
            e.printStackTrace();
        }

        return user;
    }

    public int insert(User user)  {
        int result = 0;
        String sql = "INSERT INTO User(userid, username, password)"
                + " VALUES(?,?,?) ";

        Savepoint savepoint = null;
        try{
            savepoint = con.setSavepoint("insertSavePoint");
            psmt = con.prepareStatement(sql);
            psmt.setString(1, user.getUserid());
            psmt.setString(2, user.getUsername());
            psmt.setString(3, user.getPassword());
            result = psmt.executeUpdate();

            if( result > 0) {
                con.commit();
            }
        }catch (SQLException e){
            try{
                con.rollback(savepoint);
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            System.out.println("게시글 등록 시, 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    public List<User> selectList() {
        LinkedList<User> userList = new LinkedList<>();


        String sql = " SELECT * "
                + " FROM User "
                + " ORDER BY uid ASC";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                User user = new User();
                user.setUid( rs.getInt( "uid" ) );
                user.setUserid( rs.getString( "userid" ) );
                user.setUsername( rs.getString( "username" ));
                user.setPassword( rs.getString( "password" ));
                userList.add(user);
            }
        }catch( SQLException e ) {
            System.out.println( "게시글 목록 받아오기 실패");
            e.printStackTrace();
        }
        catch ( NullPointerException e ) {
            System.out.println( "게시글 내용 중 null값이 있습니다.");
            e.printStackTrace();
        }
        return userList;
    }

    public Board select( int board_no ){

        String sql = " SELECT * "
                + " FROM board "
                + " WHERE board_no = ?";
        Board board = new Board();


        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt( 1, board_no );
            rs = psmt.executeQuery();

            if ( rs.next() ) {
                board.setBoard_no( rs.getInt( "board_no" ) );
                board.setTitle( rs.getString( "title" ));
                board.setWriter( rs.getString( "writer" ));
                board.setContent( rs.getString( "content" ));
                board.setReg_date( dataFormat.format( rs.getTimestamp( "reg_date" )) );
                board.setUpd_date( dataFormat.format( rs.getTimestamp( "upd_date" )));
                {
                    Blob blob = rs.getBlob( "file" );


//                    blob =
                }
                InputStream fis = rs.getBinaryStream( "file" );
//                board.setFile( fis );
                board.setFisFile( fis );
            }
            else {
                System.out.println( board_no + "번 게시물은 존재하지 않습니다.");
                board = null;

            }
        } catch ( SQLException e ) {
            System.out.println( "게시물 조회시 예외 발생..." );
            e.printStackTrace();
        }

        return board;
    }

    public int update( User user ) {
        int result = 0;
        String sql = " UPDATE Board"
                + " SET title=?"
                + ", writer = ?"
                + ", content = ?"
                + ", upd_date = now()"
                + " WHERE board_no = ?";

        Savepoint savepoint = null;

        try{
            savepoint= con.setSavepoint("UpdateSavePoint");
            psmt = con.prepareStatement( sql );
//            psmt.setString( 1, board.getTitle() );
//            psmt.setString( 2, board.getWriter() );
//            psmt.setString( 3, board.getContent() );
//            psmt.setInt( 4, board.getBoard_no() );

            result = psmt.executeUpdate();

            if ( result > 0 ) {
                con.commit();
            }
        } catch( SQLException e ) {
            try {
                con.rollback( savepoint );
            }catch ( SQLException e2 ) {
                System.out.println( "게시글 수정 시 예외 발생 code2");
                e2.printStackTrace();
            }

            System.out.println( "게시글 수정 시 예외 발생 code1");
            e.printStackTrace();
        }


        return result;
    }


    public int delete( int board_no ) {
        int result = 0;

        String sql = " DELETE FROM Board "
                + " WHERE board_no= ?";

        Savepoint savepoint = null;

        try{
            savepoint= con.setSavepoint("DeleteSavePoint");
            psmt = con.prepareStatement( sql );
            psmt.setInt( 1, board_no );

            result = psmt.executeUpdate();

            if ( result > 0 ) {
                con.commit();
            }
        } catch( SQLException e ) {
            try {
                con.rollback(savepoint);
            } catch ( SQLException e2 ) {
                System.out.println( "게시글 삭제 시 예외 발생 code2" );
                e2.printStackTrace();
            }

            System.out.println( "게시글 삭제 시 예외 발생 code1" );
            e.printStackTrace();
        }

        return result;
    }

    public int selectTotalCount() {
        String sql = "SELECT count(*) "
                + "From Board "
                + " ORDER BY reg_date DESC";
        int result = 0;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql );
            if (rs.next()) {
                result = rs.getInt(1);
            }
            System.out.println( "총 게시물 : " + rs );
//            result = rs.getInt( 1 );
            System.out.println( "rulst : " + result );
        }catch ( SQLException e ) {
            System.err.println( "게시물 카운터 조회 시 예외 발생 " );
            e.printStackTrace();
        }


        return result;
    }

    public List<Board> selectPageList( int pageNo ) {
        LinkedList<Board> boardList = new LinkedList<>();
        String sql = "SELECT * "
                + " FROM Board "
                + " ORDER BY reg_date DESC limit ? offset ?";
        try {
            final int VIEWCOUNT = 15;  // 가져올 게시물 갯수

            psmt = con.prepareStatement( sql );
            psmt.setInt( 1, VIEWCOUNT );
            psmt.setInt( 2, pageNo * VIEWCOUNT );
            rs = psmt.executeQuery();
            while ( rs.next() ) {
                Board board = new Board();
                board.setBoard_no( rs.getInt( "board_no" ) );
                board.setTitle( rs.getString( "title" ));
                board.setWriter( rs.getString( "writer" ));
                board.setContent( rs.getString( "content" ));
                board.setReg_date( dataFormat.format( rs.getTimestamp( "reg_date" )));
                board.setUpd_date( dataFormat.format( rs.getTimestamp( "upd_date" )));
                boardList.add(board);
            }
        } catch ( SQLException e ) {

            e.printStackTrace();
        }
        return boardList;
    }

}
