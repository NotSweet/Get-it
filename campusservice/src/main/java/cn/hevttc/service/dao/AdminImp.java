package cn.hevttc.service.dao;

import cn.hevttc.service.bean.Admin;
import cn.hevttc.service.connections.CassandraConn;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class AdminImp implements AdminDao{
    @Override
    public void insertAdmins(Admin admin) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql = "INSERT into admins (admin_id,name,password,createAt,power) VALUES(?,?,?,?,?);";
        cassandraconn.executeSQL(sql, new Object[]{admin.getAdmin_id(), admin.getName(),admin.getPassword(),System.currentTimeMillis(),admin.getPower()});
        cassandraconn.close();
    }
    @Override
    public boolean login(Admin admin) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="";
        sql="SELECT password FROM admins WHERE name = ?;";
        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{admin.getName()});
        cassandraconn.close();
        assert resultSet != null;
        Row row = resultSet.one();
        if(row==null)
            return false;
        return admin.getPassword() != null && admin.getPassword().equals(row.getString("password"));
    }

    @Override
    public int adminId(Admin admin) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="";
        ResultSet resultSet=null;

        sql="SELECT admin_id FROM admins WHERE name = ?;";
        resultSet = cassandraconn.executeSQL(sql,new Object[]{admin.getName()});
        Row row = resultSet.one();
        cassandraconn.close();
        return row.getInt("admin_id");
    }

}
