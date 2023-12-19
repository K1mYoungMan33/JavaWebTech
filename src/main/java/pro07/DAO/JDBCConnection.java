package pro07.DAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class JDBCConnection {
    public Connection con;
    public Statement stmt;
    public PreparedStatement psmt;
    public ResultSet rs;

    Context initContext = new InitialContext();
    Context envContext = (Context) initContext.lookup( "java:comp/env" );
    DataSource dataSource = (DataSource) envContext.lookup( "jdbc/MyDB" );

    public JDBCConnection() throws NamingException {
        try{
            con = dataSource.getConnection();
            con.setAutoCommit(false);

//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/BoardJava?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
//            String id = "root";
//            String pw = "1234";
//
//            con = DriverManager.getConnection(url, id, pw);
            System.out.println("DB연결 성공");
        }catch (Exception e){
            System.out.println("연결 실패");
            e.printStackTrace();
        }
    }


}
