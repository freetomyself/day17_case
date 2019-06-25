package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @program: day15_response--cn.itcast.dao
 * @author: WaHotDog 2019-06-20 07:54
 **/


public interface UserDao {

//    查所有人
    List<User> findAll();
//     登录
    User findUserByUsernameAndPassword(String username, String password);
//    添加
    void add(User user);
//    删除
    void delete(int i);
//    通过id查询
    User findid(int id);
//    更新用户
    void updateUser(User user);
//    查询总记录数
    int findTotalCount(Map<String, String[]> condition);
//    分页查询每页数据
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
