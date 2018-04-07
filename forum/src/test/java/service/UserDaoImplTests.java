package test.java.service;

/**
 * Created by slzZp on 2018/1/31.
 */

import dao.UserDao;
import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class UserDaoImplTests {
   @Resource
   private  UserDao userDao;
    @Test
    public void testFindUserById() throws Exception {
        User user = userDao.findUserById(1);

        System.out.println(user);
    }

}
