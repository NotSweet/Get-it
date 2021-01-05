package cn.hevttc.service.dao;

import cn.hevttc.service.bean.Task;
import cn.hevttc.service.bean.User;
import cn.hevttc.service.connections.CassandraConn;
import cn.hevttc.service.utils.UniCodeUtil;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.ArrayList;

public class UserImp implements UserDao{

    @Override
    public void insertUser(User user) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();

        String sql="insert into user(user_id,user_name,password,phone_number,stu_no,score,createAt,updateAt,is_certify,user_score,score_number) values(?,?,?,?,?,?,?,?,?,?,?);";
        cassandraconn.executeSQL(sql,new Object[]{UniCodeUtil.randInt(),user.getUser_name(),user.getPassword(),user.getPhone_number(),user.getSch_no(),0,System.currentTimeMillis(),System.currentTimeMillis(),false,0,0});
        cassandraconn.close();
    }

    @Override
    public User selectUser(int id) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();

        String sql="SELECT user_name,stu_no,phone_number,score,user_score,score_number FROM user WHERE user_id = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{id});
        Row row = resultSet.one();
        User user = new User();
        user.setUser_id(id);
        user.setUser_name(row.getString("user_name"));
        user.setSch_no(row.getInt("stu_no"));
        user.setPhone_number(row.getString("phone_number"));
        user.setScore(row.getInt("score"));
        user.setUser_score(row.getFloat("user_score"));
        user.setScore_number(row.getFloat("score_number"));
        cassandraconn.close();
        return user;
    }
    @Override
    public User isCertify(int id) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();

        String sql="SELECT is_certify FROM user WHERE user_id = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{id});
        Row row = resultSet.one();
        System.out.println(row.isNull(0));
        cassandraconn.close();
        return null;

    }
    @Override
    public boolean hasPhone(String phone) {
        System.out.println(phone);
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="SELECT user_id FROM user WHERE phone_number = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{phone});
        Row row = resultSet.one();
        cassandraconn.close();
        return row == null;

    }

    /**
     *
     * @param name
     * @return true ok false no
     */
    @Override
    public boolean hasName(String name) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="SELECT user_id FROM user WHERE user_name = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{name});
        Row row = resultSet.one();

        cassandraconn.close();
        return row == null;
    }

    @Override
    public int userId(User user) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="";
        ResultSet resultSet=null;
        if(user.getUser_name()!=null){
            sql="SELECT user_id FROM user WHERE user_name = ?;";
            resultSet = cassandraconn.executeSQL(sql,new Object[]{user.getUser_name()});
        }
        else if(user.getPhone_number()!=null){
            sql = "SELECT user_id FROM user WHERE phone_number = ?;";
            resultSet = cassandraconn.executeSQL(sql, new Object[]{user.getPhone_number()});
        }
        Row row = resultSet.one();
        cassandraconn.close();
        return row.getInt("user_id");
    }


    @Override
    public void alterPassword(User user) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="UPDATE user set password = ? WHERE user_id = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{user.getPassword(),user.getUser_id()});
        Row row = resultSet.one();
        cassandraconn.close();
    }
    @Override
    public void alterScore(User user, int score, Boolean isAdd) {
        String sql="";
        if(isAdd)
            score = user.getScore()+score;

        else
            score = user.getScore()-score;
        sql="UPDATE user set user_score = "+score+" WHERE user_id = "+user.getUser_id()+";";
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();

        ResultSet resultSet = cassandraconn.executeSQL(sql);
        Row row = resultSet.one();
        cassandraconn.close();
    }
    @Override
    public void alterStar(User user) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="UPDATE user set user_score = ?,score_number = ? WHERE user_id = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{user.getUser_score(),user.getScore_number(),user.getUser_id()});
        Row row = resultSet.one();
        cassandraconn.close();
    }
    @Override
    public boolean login(User user) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="";
        ResultSet resultSet=null;
        if(user.getUser_name()!=null){
            sql="SELECT password FROM user WHERE user_name = ?;";
            resultSet = cassandraconn.executeSQL(sql,new Object[]{user.getUser_name()});
        }
        else if(user.getPhone_number()!=null){
            sql = "SELECT password FROM user WHERE phone_number = ?;";
            resultSet = cassandraconn.executeSQL(sql, new Object[]{user.getPhone_number()});
        }
        cassandraconn.close();
        assert resultSet != null;
        Row row = resultSet.one();
        if(row==null)
            return false;
        return user.getPassword() != null && user.getPassword().equals(row.getString("password"));
    }

    @Override
    public void deleteUser(String username) {

    }
}
