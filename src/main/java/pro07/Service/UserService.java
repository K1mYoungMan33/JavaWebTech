package pro07.Service;


import pro07.DTO.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User select(String userid );
    int insert( User user );
    int update( User user );
    int delete( int  uid );

    List<User> selectList();

    void destroy() throws SQLException;
}
