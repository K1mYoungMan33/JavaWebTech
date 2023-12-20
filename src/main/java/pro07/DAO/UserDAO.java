package pro07.DAO;

import pro07.DAO.JDBCConnection;
import pro07.DTO.Board;
import pro07.DTO.User;

import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends JDBCConnection {
    SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public UserDAO() throws NamingException {
    }

    public User select(String userid) {
        Connection con = null;
        PreparedStatement pmst = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }

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
        }finally {
            try {
                if ( rs != null ) {
                    rs.close();
                }
                if ( pmst != null) {
                    pmst.close();
                }
                if ( con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public int insert(User user)  {
        Connection con;
        PreparedStatement pmst = null;
        int rs = 0;

        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }



        int result = 0;
        String sql = "INSERT INTO User(userid, username, password)"
                + " VALUES(?,?,?) ";

        Savepoint savepoint = null;
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            savepoint = conn.setSavepoint("insertSavePoint");
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUserid());
            psmt.setString(2, user.getUsername());
            psmt.setString(3, user.getPassword());
            result = psmt.executeUpdate();

            if( result > 0) {
                conn.commit();
            }
        }catch (SQLException e){
            try{
                conn.rollback(savepoint);
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            System.out.println("게시글 등록 시, 예외 발생");
            e.printStackTrace();
        }finally {
            try {
                if ( pmst != null) {
                    pmst.close();
                }
                if ( con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public List<User> selectList() {
        Connection con;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }

        LinkedList<User> userList = new LinkedList<>();

        String sql = " SELECT * "
                + " FROM User "
                + " ORDER BY uid ASC";

        try {
            con.setAutoCommit(false);

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
            System.out.println( "사용자 목록 받아오기 실패");
            e.printStackTrace();
        }
        catch ( NullPointerException e ) {
            System.out.println( "사용자 내용 중 null값이 있습니다.");
            e.printStackTrace();
        }finally {
            try {
                if ( rs != null ) {
                    rs.close();
                }
                if ( stmt != null) {
                    stmt.close();
                }
                if ( con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userList;
    }


    public int update( User user ) {
        Connection con;
        PreparedStatement psmt = null;
        int result = 0;

        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }


        String sql = " UPDATE User"
                + " SET username=?"
//                + ", writer = ?"
                + " WHERE userid = ?";

        Savepoint savepoint = null;

        try{
            savepoint= con.setSavepoint("UpdateSavePoint");
            psmt = con.prepareStatement( sql );
            psmt.setString( 1, user.getUsername() );
            psmt.setString( 2, user.getUserid() );

            result = psmt.executeUpdate();

            if ( result > 0 ) {
                con.commit();
            }
        } catch( SQLException e ) {
            try {
                con.rollback( savepoint );
            }catch ( SQLException e2 ) {
                System.out.println( "사용자 수정 시 예외 발생 code2");
                e2.printStackTrace();
            }

            System.out.println( "사용자 수정 시 예외 발생 code1");
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psmt != null) {
                    psmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    public int delete( int uid ) {
        Connection con;
        PreparedStatement psmt = null;
        int result = 0;

        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }


        String sql = " DELETE FROM User "
                + " WHERE uid = ?";

        Savepoint savepoint = null;

        try{

            savepoint= con.setSavepoint("DeleteSavePoint");
            psmt = con.prepareStatement( sql );
            psmt.setInt( 1, uid );

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
        }finally {
            try {
                if ( rs != null ) {
                    rs.close();
                }
                if ( psmt != null) {
                    psmt.close();
                }
                if ( con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return result;
    }

    public int selectTotalCount() {
        String sql = "SELECT count(*) "
                + "From Board "
                + " ORDER BY reg_date DESC";
        int result = 0;

        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
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
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            final int VIEWCOUNT = 15;  // 가져올 게시물 갯수

            psmt = conn.prepareStatement( sql );
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
