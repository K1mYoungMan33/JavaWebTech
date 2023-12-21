package pro07.Service;


import pro07.DAO.UserDAO;
import pro07.DTO.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    {
        try {
            userDAO = new UserDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserServiceImpl() throws NamingException {
    }

    @Override
    public User select(String userid) {
        return userDAO.select( userid);
    }

    public List<User> selectList() { return userDAO.selectList(); }

    @Override
    public void destroy() throws SQLException {
        userDAO.destroy();
    }

    @Override
    public int insert(User user) {
        return userDAO.insert( user);
    }

    @Override
    public int update(User user) {
        return userDAO.update( user);
    }

    @Override
    public int delete( int  uid) {
        return userDAO.delete( uid );
    }
}
