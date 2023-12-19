package pro07.Service;


import pro07.DAO.UserDAO;
import pro07.DTO.User;

import javax.naming.NamingException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO = new UserDAO();

    public UserServiceImpl() throws NamingException {
    }

    @Override
    public User select(String userid) {
        return userDAO.select( userid);
    }

    public List<User> selectList() { return userDAO.selectList(); }
    @Override
    public int insert(User user) {
        return userDAO.insert( user);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(String uid) {
        return 0;
    }
}
