package cn.hevttc.service.dao;

import cn.hevttc.service.bean.Task;
import cn.hevttc.service.bean.User;
import cn.hevttc.service.connections.CassandraConn;
import cn.hevttc.service.response.JsonResponse;
import cn.hevttc.service.utils.UniCodeUtil;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import net.sf.json.JSONArray;

public class TaskImp implements TaskDao {
    /**
     *
     * @param user
     * @param task
     * @return 0011 code less  0012 error 0010 success
     */
    @Override
    public String insertTask(User user, Task task) {

        if(user.getScore()<task.getTask_score())
            return "0011";
        UserDao userImp = new UserImp();
        userImp.alterScore(user,task.getTask_score(),false);
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="insert into task_"+user.getSch_no()+"(task_id,task_title,task_score,task_context,task_phone,task_address,sch_no,task_type,task_author,status,createAt,updateAt) values(?,?,?,?,?,?,?,?,?,?,?,?);";
        cassandraconn.executeSQL(sql,new Object[]{UniCodeUtil.randInt(),task.getTask_title(),task.getTask_score(),task.getTask_context(),task.getTask_phone(),task.getTask_address(),user.getSch_no(),task.isTask_type(),user.getUser_id(),0,System.currentTimeMillis(),System.currentTimeMillis()});
        cassandraconn.close();
        return "0010";
    }
    @Override
    public String selectTasks(int sch_no) {
        JsonResponse jsonResponse = new JsonResponse();
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="SELECT task_id,task_title,task_score,task_context,task_phone,task_address,task_type,task_author,task_other,status,createAt,updateAt from task_"+sch_no+";";
        ResultSet resultSet = cassandraconn.executeSQL(sql);
        JSONArray jsonArray = new JSONArray();
        Task task = new Task();
        for (Row row:resultSet) {
            task.setTask_id(row.getInt("task_id"));
            task.setTask_title(row.getString("task_title"));
            task.setTask_score(row.getInt("task_score"));
            task.setTask_context(row.getString("task_context"));
            task.setTask_phone(row.getString("task_phone"));
            task.setTask_address(row.getString("task_address"));
            task.setTask_type(row.getBool("task_type"));
            task.setTask_author(row.getInt("task_author"));
            task.setTask_other(row.getInt("task_other"));
            task.setStatus(row.getInt("status"));
            task.setCreateAt(row.getTimestamp("createAt").getTime());
            task.setUpdateAt(row.getTimestamp("updateAt").getTime());
            jsonArray.add(task);
        }
        cassandraconn.close();
        return jsonResponse.outPutSuccess(jsonArray).toJSONString();
    }

    @Override
    public String allTasks(int sch_no) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="SELECT task_id,task_title,task_score,task_context,task_phone,task_address,task_type,task_author,task_other,status,createAt,updateAt from task_"+sch_no+";";
        ResultSet resultSet = cassandraconn.executeSQL(sql);

        JSONArray jsonArray = new JSONArray();
        Task task = new Task();
        for (Row row:resultSet) {
            task.setTask_id(row.getInt("task_id"));
            task.setTask_title(row.getString("task_title"));
            task.setTask_score(row.getInt("task_score"));
            task.setTask_context(row.getString("task_context"));
            task.setTask_phone(row.getString("task_phone"));
            task.setTask_address(row.getString("task_address"));
            task.setTask_type(row.getBool("task_type"));
            task.setTask_author(row.getInt("task_author"));
            task.setTask_other(row.getInt("task_other"));
            task.setStatus(row.getInt("status"));
            task.setCreateAt(row.getTimestamp("createAt").getTime());
            task.setUpdateAt(row.getTimestamp("updateAt").getTime());
            jsonArray.add(task);
        }

        cassandraconn.close();
        return jsonArray.toString();
    }
}
