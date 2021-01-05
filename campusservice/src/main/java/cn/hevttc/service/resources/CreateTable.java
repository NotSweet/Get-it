package cn.hevttc.service.resources;

import cn.hevttc.service.bean.CampusName;
import cn.hevttc.service.connections.CassandraConn;
import cn.hevttc.service.dao.CampusImp;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import org.omg.CORBA.Any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateTable {
    public static void main(String[] args) {

//        new CampusImp().selectCampus();
        //new CampusImp().alterCampus(new CampusName(5,"test","123"));

        //campus table
        String sql="CREATE TABLE campus(" +
                "campus_id int PRIMARY KEY," +
                "campus_name text," +
                "campus_ip text)" ;



        String sql2="INSERT into campus (campus_id,campus_name,campus_ip) VALUES(2, '测试','1.1.1.1')" ;








        String sql3="CREATE TABLE user(" +
                "user_id int PRIMARY KEY," +
                "user_name text," +
                "password varchar," +
                "phone_number varchar," +
                "sch_no int," +
                "score int," +
                "createAt timestamp," +
                "updateAt timestamp," +
                "is_certify boolean," +
                "user_score float," +
                "score_number float" +
                ")" ;
        String sql4="CREATE TABLE task_3(" +
                "task_id int PRIMARY KEY," +
                "task_title text," +
                "task_score int," +
                "task_context text," +
                "task_phone varchar," +
                "task_address text," +
                "sch_no int," +
                "task_type boolean," +
                "task_author int," +
                "task_other int," +
                "status int," +
                "receive_time timestamp," +
                "createAt timestamp," +
                "updateAt timestamp" +
                ")" ;
        String token="CREATE TABLE tokens(" +
                "token_id int," +
                "user_id int PRIMARY KEY," +
                "usedAt timestamp," +
                "user_token varchar)" ;
        String admin="CREATE TABLE admins(" +
                "admin_id int PRIMARY KEY," +
                "name varchar," +
                "password varchar," +
                "createAt timestamp," +
                "loginAt timestamp," +
                "power int)" ;
        try {
            new CreateTable().createTable(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     * 删除的注释
     * GET方法发送POST请求
     *
     * @return 返回 JSON（删除条件）
     * @throws Exception 异常
     */

    public String createTable(String sql) throws Exception {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        cassandraconn.executeSQL(sql);
        cassandraconn.close();
        return null;
    }

    /**
     * 删除的注释
     * GET方法发送POST请求
     *
     * @param agent 参数（删除条件）
     * @return 返回 JSON（删除条件）
     * @throws Exception 异常
     */

    public String deleteTable(String agent) throws Exception {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        cassandraconn.executeSQL("Delete from emp where emp_id=" + agent + "");
        HashMap dataMap = new HashMap<String, Any>(16);
        dataMap.put("user_id", agent);
        //String jsonStr = yxResp.outPutSuccess(dataMap).toJSONString();
        return null;
    }

}