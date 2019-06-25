package cn.itcast.dao.imp;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: day15_response--cn.itcast.dao
 * @author: WaHotDog 2019-06-20 07:56
 **/


public class UserDaoImp implements UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ? limit 1";
            User users = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return users;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void delete(int i) {
        String sql = "delete from user where id = ?";
        template.update(sql, i);
    }

    @Override
    public User findid(int id) {
        String sql = "select * from user where id = ? limit 1";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ?  where id = ? ";
        System.out.println(user.toString());
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {

//        定义一个模板sql
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
//        遍历map
        Set<String> keySet = condition.keySet();
//        定义参数集合
        List<Object> paramres = new ArrayList<Object>();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //根据key获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append("  and " + key + " like ? ");
                paramres.add("%" + value + "%"); // ? 条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(paramres);
        int totalCount = template.queryForObject(sb.toString(), Integer.class,paramres.toArray());
        return totalCount;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
//        创建sql模板
        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
//        遍历map
        Set<String> keySet = condition.keySet();
        List<Object> paramers = new ArrayList<Object>();
        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
//            当key不为空时进行操作
            if (key!=null && !"".equals(key)){
//                拼接sql
                sb.append(" and " + key + " like ? ");
                paramers.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        paramers.add(start);
        paramers.add(rows);
        System.out.println(sb.toString());
        System.out.println(paramers);
        List<User> list = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), paramers.toArray());
        return list;
    }

}
