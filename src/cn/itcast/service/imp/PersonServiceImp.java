package cn.itcast.service.imp;

import cn.itcast.dao.PersonDao;
import cn.itcast.dao.imp.PersonDaoImp;
import cn.itcast.domain.Person;
import cn.itcast.service.PersonService;

/**
 * @program: day17_case--cn.itcast.service.imp
 * @author: WaHotDog 2019-07-08 14:59
 **/


public class PersonServiceImp implements PersonService {
    private PersonDao dao = new PersonDaoImp();
    @Override
    public Person login(Person person) {
        return dao.findUserByUsernamePass(person);
    }
}
