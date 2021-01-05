package cn.hevttc.service.dao;

import cn.hevttc.service.bean.Admin;
import cn.hevttc.service.bean.User;

public interface AdminDao {
    void insertAdmins(Admin admin);
    boolean login(Admin admin);
    int adminId(Admin admin);
}
