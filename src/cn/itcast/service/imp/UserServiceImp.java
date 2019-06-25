package cn.itcast.service.imp;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.imp.UserDaoImp;
import cn.itcast.domain.PageBeen;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @program: day15_response--cn.itcast.service.imp
 * @author: WaHotDog 2019-06-20 08:41
 **/


public class UserServiceImp implements UserService {
    private UserDao dao = new UserDaoImp();

    @Override
    public List<User> findAll() {
//        调用Dao完成查询
        return dao.findAll();
    }


    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        int i = Integer.parseInt(id);
        dao.delete(i);
    }

    @Override
    public User findUserById(String id) {
        return dao.findid(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public PageBeen<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
//        1.创建空的PageBean对象
        PageBeen<User> pb = new PageBeen<User>();
//        2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);



//        3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

//        设置总页码数
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
//        4.调用dao查询所选页数据
        //计算开始的索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows,condition);
        pb.setList(list);

        return pb;
    }

    @Override
    public void delSelectUser(String[] uids) {
        if(uids !=null && uids.length>0){
            //  遍历需要删除的id
            for (String uid : uids) {
                    // 强转 调用dao
                dao.delete(Integer.parseInt(uid));
            }
        }


    }
}
