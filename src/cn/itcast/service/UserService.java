package cn.itcast.service;

import cn.itcast.domain.PageBeen;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @program: day15_response--cn.itcast.service
 * @author: WaHotDog 2019-06-20 08:38
 **/


public interface UserService {
    /**
     * 获取所有联系人
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 保存User信息
     * @param user
     * @return
     */
    public void addUser(User user);

    /**
     * 删除Userxinxi
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBeen<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 批量删除用户
     * @param uids
     */
    void delSelectUser(String[] uids);
}
