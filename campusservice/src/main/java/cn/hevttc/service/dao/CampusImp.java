package cn.hevttc.service.dao;

import cn.hevttc.service.bean.CampusName;
import cn.hevttc.service.connections.CassandraConn;
import cn.hevttc.service.response.JsonResponse;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import net.sf.json.JSONArray;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class CampusImp implements CampusDao {
    @Override
    public void insertCampus(CampusName campusName) {

        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="INSERT into campus (campus_id,campus_name,campus_ip) VALUES(?,?,?);";
        cassandraconn.executeSQL(sql,new Object[]{campusName.getId(),campusName.getName(),campusName.getIp()});
        cassandraconn.close();
    }

    @Override
    public void alterCampus(CampusName campusName) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="UPDATE campus set campus_name = '"+campusName.getName()+"',campus_ip = '"+campusName.getIp()+"' where campus_id = "+campusName.getId()+";";
        cassandraconn.executeSQL(sql);
        cassandraconn.close();
    }

    @Override
    public String selectCampus() {
        JsonResponse jsonResponse = new JsonResponse();
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="SELECT JSON campus_id,campus_name from campus;";
        ResultSet resultSet = cassandraconn.executeSQL(sql);
        JSONArray jsonArray = new JSONArray();
        for (Row row:resultSet) {
            jsonArray.add(row.getString(0));
        }
        cassandraconn.close();
        return jsonResponse.outPutSuccess(jsonArray).toJSONString();
    }

    @Override
    public void deleteCampus(CampusName campusName) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql="DELETE FROM campus WHERE campus_id = ?;";
        cassandraconn.executeSQL(sql,new Object[]{campusName.getId()});
        cassandraconn.close();
    }
}
