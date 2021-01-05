package cn.hevttc.service.resources;
import cn.hevttc.service.connections.CassandraConn;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;


import org.omg.CORBA.Any;

import java.util.*;

import java.util.HashMap;

public class RestResources {
    private String version = "ver1";


/**-------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 查询的注释
     * GET方法

     * @return 返回 JSON（查询结果及查询条件）
     * @throws Exception 异常
     */

    public String select(String agent) throws Exception {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();

        String sql = "select * from emp where emp_name='"+agent+"'";
        ResultSet rs = cassandraconn.executeSQL(sql);
        HashMap dataMap = new HashMap<String, Any>(16);
        Row row = rs.one();
        dataMap.put("user_name",row.getString("emp_name"));
        dataMap.put("emp_city",row.getString("emp_city"));
        dataMap.put("AgentCode", agent);

        return null;
    }
    /**
     * 查询所有的注释
     * GET方法

     * @return 返回 JSON（查询结果）
     * @throws Exception 异常
     */

    public String selectall() throws Exception {
        CassandraConn cassandraconn =new CassandraConn();
        cassandraconn.createClient();
        ResultSet rs = cassandraconn.executeSQL("select * from emp limit 4");

        String[] keyArray = {"emp_id","emp_name","emp_city"};
        List<Row> row = new ArrayList<Row>();
        row = rs.all();
        HashMap dataMap = new HashMap<String, Any>(16);
//        /*声明1个json数组*/
//        JSONArray gCmtTable = new JSONArray();
//        /*声明json对象*/
//        JSONObject outData = new JSONObject();
//        /*把json数组加到json对象中*/
//        outData.put("CmtTable", gCmtTable);
//        /*此时创建出来的如下:jsonData={"CmtTable":[]};把json数据加到json数组中*/
//        for (int i = 0; i < row.size(); i++) {
//            JSONObject node = new JSONObject();
//            node.put(keyArray[0],row.get(i).getInt("emp_id"));
//            node.put(keyArray[1],row.get(i).getString("emp_name"));
//            node.put(keyArray[2],row.get(i).getString("emp_city"));
//
//        }

        return null;
    }



    /**
     * 删除的注释
     * GET方法发送POST请求
     * @param agent  参数（删除条件）
     * @return 返回 JSON（删除条件）
     * @throws Exception 异常
     */

    public String delete( String agent) throws Exception {
        CassandraConn cassandraconn = new CassandraConn();
        cassandraconn.createClient();
        cassandraconn.executeSQL("Delete from emp where emp_id="+agent+"");
        HashMap dataMap = new HashMap<String, Any>(16);
        dataMap.put("user_id", agent);
        //String jsonStr = yxResp.outPutSuccess(dataMap).toJSONString();
        return null;
    }

    /**
     * 插入的注释
     * GET方法发送POST请求
     * @param req request请求
     * @param resp response请求
     * @param agent 参数（插入数据value） city
     * @param agent1 参数（插入数据value）name
     * @param agent2 参数（插入数据value）id
     * @return 返回 JSONString（插入value）
     * @throws Exception 异常
     */

//    public String insert(    ) throws Exception {
//        CassandraConn cassandraconn = new CassandraConn();
//        cassandraconn.createClient();
//        resp.setCharacterEncoding("UTF-8");
//        String sql = "INSERT INTO emp(emp_id, emp_city, emp_name) VALUES ("+agent2+", '"+agent+"', '"+agent1+"')";
//        cassandraconn.executeSQL(sql);
//        YxJsonResponse yxResp = new YxJsonResponse();
//        HashMap dataMap = new HashMap<String, Any>(16);
//        dataMap.put("emp_city", agent);
//        dataMap.put("emp_name", agent1);
//        dataMap.put("emp_id", agent2);
//        String jsonStr = yxResp.outPutSuccess(dataMap).toJSONString();
//        return jsonStr;
//    }

    /**
     * 更新的注释
     * GET方法发送POST请求
     * @param req request请求
     * @param resp response请求
     * @param agent  agent 参数（更新数据value）
     * @param agent1 agent1 参数（更新数据value）
     * @param agent2 agent2 参数（更新条件value）
     * @return 返回 JSONString（更新value）
     * @throws Exception Exception 异常
     */
//    @GET
//    @Path("update")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String update(@Context HttpServletRequest req, @Context HttpServletResponse resp
//            ,@QueryParam("agent") String agent,@QueryParam("agent1") String agent1,@QueryParam("agent2") String agent2
//    ) throws Exception {
//        CassandraConn cassandraconn = new CassandraConn();
//        cassandraconn.createClient();
//        resp.setCharacterEncoding("UTF-8");
//        resp.addHeader("Access-Control-Allow-Origin", "*");
//        cassandraconn.executeSQL("update emp set emp_city='"+agent+"',emp_name='"+agent1+"' where emp_id="+agent2+"");
//        YxJsonResponse yxResp = new YxJsonResponse();
//        HashMap dataMap = new HashMap<String, Any>(16);
//        dataMap.put("emp_city", agent);
//        dataMap.put("emp_name", agent1);
//        dataMap.put("emp_id", agent2);
//        String jsonStr = yxResp.outPutSuccess(dataMap).toJSONString();
//        return jsonStr;
//    }
}