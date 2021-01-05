package cn.hevttc.service.dao;

import cn.hevttc.service.connections.CassandraConn;
import cn.hevttc.service.utils.UniCodeUtil;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;


public class TokenImp implements TokenDao {
    @Override
    public String newToken(int user_id) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql = "INSERT into tokens (token_id,user_id,usedAt,user_token) values(?,?,?,?);";
        String s = UniCodeUtil.rand(20) + UniCodeUtil.rand(20);
        System.out.println(s);
        cassandraconn.executeSQL(sql, new Object[]{UniCodeUtil.randInt(), user_id, System.currentTimeMillis(), s});
        cassandraconn.close();
        return s;
    }

    //0101343PMT77MAA78TE902V245S2687U947S8HY8
    @Override
    public String reToken(int user_id, String token) {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql1 = "select user_token from tokens where user_id = " + user_id;
        ResultSet resultSet = cassandraconn.executeSQL(sql1);
        Row row = resultSet.one();
        String s = "";
        if (token.equals(row.getString("user_token"))) {
            String sql = "UPDATE tokens set usedAt = ?,user_token = ? WHERE user_id = ?;";
            s = UniCodeUtil.rand(20) + UniCodeUtil.rand(20);
            System.out.println(s);
            cassandraconn.executeSQL(sql, new Object[]{System.currentTimeMillis(), s, user_id});

        }
        cassandraconn.close();

        return s;
    }

    //    @Override
//    public String ne(User user) {
//        CassandraConn cassandraconn = new CassandraConn();
//        cassandraconn.createClient();
//        String sql="UPDATE user set user_score = ?,score_number = ? WHERE user_id = ?;";
//        ResultSet resultSet = cassandraconn.executeSQL(sql,new Object[]{user.getUser_score(),user.getScore_number(),user.getUser_id()});
//        Row row = resultSet.one();
//        cassandraconn.close();
//    }
    @Override
    public String tokenAuth(String tokens) {
        String token = tokens.substring(tokens.length() - 40);
        String user_id = tokens.substring(0, tokens.length() - 40);
        System.out.println(token);
        System.out.println(user_id);
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        String sql1 = "select user_token from tokens where user_id = " + user_id;
        ResultSet resultSet = cassandraconn.executeSQL(sql1);
        Row row = resultSet.one();
        String s = "Error";
        if (token.equals(row.getString("user_token"))) {
            s = user_id;
        }
        cassandraconn.close();
        return s;
    }
}
