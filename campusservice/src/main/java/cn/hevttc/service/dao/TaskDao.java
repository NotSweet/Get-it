package cn.hevttc.service.dao;


import cn.hevttc.service.bean.Task;
import cn.hevttc.service.bean.User;

public interface TaskDao {
    String insertTask(User user, Task task);
    String selectTasks(int sch_no);
    String allTasks(int sch_no);
}
