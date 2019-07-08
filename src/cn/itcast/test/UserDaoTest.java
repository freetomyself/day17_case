package cn.itcast.test;

import cn.itcast.dao.PersonDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.imp.PersonDaoImp;
import cn.itcast.dao.imp.UserDaoImp;
import cn.itcast.domain.Person;
import cn.itcast.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @program: day15_response--cn.itcast.test
 * @author: WaHotDog 2019-06-20 09:08
 **/


public class UserDaoTest {

    @Test
    public void test(){
        UserDao dao = new UserDaoImp();
        List<User> users = dao.findAll();
        System.out.println(users);
    }

    @Test
    public void UserService(){
        UserDao dao = new UserDaoImp();
        User user = dao.findUserByUsernameAndPassword("zhangsan", "123");
        System.out.println(user);
    }

    @Test
    public void FindById(){
        UserDaoImp dao = new UserDaoImp();
        User user = dao.findid(1);
        System.out.println(user);
    }

    @Test
    public void test1(){
        PersonDao dao = new PersonDaoImp();
        Person person = new Person();
        person.setUsername("张三");
        person.setPassword("123");
        Person user = dao.findUserByUsernamePass(person);
        System.out.println(user);
    }
}
