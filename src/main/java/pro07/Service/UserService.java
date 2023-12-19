package pro07.Service;


import pro07.DTO.User;

import java.util.List;

public interface UserService {
    User select(String userid );
    int insert( User user );
    int update( User user );
    int delete(String uid );

    List<User> selectList();
}
