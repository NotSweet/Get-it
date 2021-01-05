package cn.hevttc.service.dao;

import cn.hevttc.service.bean.User;
import java.util.ArrayList;

/**
 * Created by MY_PC on 2017/12/16.
 */

public interface UserDao {
    void insertUser(User user);
    boolean hasName(String user);
    boolean hasPhone(String phone);
    User isCertify(int id);
    public void alterPassword(User user);
    public void alterStar(User user);
    public void alterScore(User user, int score, Boolean isAdd);
    void deleteUser(String username);
    User selectUser(int id);
    boolean login(User user);
    int userId(User user);
}
