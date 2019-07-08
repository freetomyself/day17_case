package cn.itcast.dao;

import cn.itcast.domain.Person;

/**
 * @program: day17_case--cn.itcast.dao
 * @author: WaHotDog 2019-07-08 15:00
 **/


public interface PersonDao {
    Person findUserByUsernamePass(Person person);
}
