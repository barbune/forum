package service;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by slzZp on 2018/1/31.
 */
public class UserDaoImpl  extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        User user=sqlSession.selectOne("content.findUserById",id);


        return user;
    }





}
