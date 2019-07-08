package cn.itcast.dao.imp;

import cn.itcast.dao.PersonDao;
import cn.itcast.domain.Person;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: day17_case--cn.itcast.dao.imp
 * @author: WaHotDog 2019-07-08 15:02
 **/


public class PersonDaoImp implements PersonDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Person findUserByUsernamePass(Person person) {
        String sql = "select * from regedit where username = ? and password = ? limit 1 ";
        try{
            Person user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), person.getUsername(), person.getPassword());
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
