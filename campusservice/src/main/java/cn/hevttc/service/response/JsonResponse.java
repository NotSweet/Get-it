package cn.hevttc.service.response;


import java.util.ArrayList;
import java.util.HashMap;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.omg.CORBA.Any;

/**
 * Created by niuheng on 18/5/8.
 * @author niuheng
 * @date 18/5/8
 */
public class JsonResponse {

    private long serverProcessingDur = 0;
    private long serverProcessingFinishStamp = 0;

    private boolean error = false;
    public String returnCode = "PASS";
    public String returnMsg = "PASS_DESC";

    private long startStamp = 0;

    private JSON respData = null;

    public JsonResponse() {
        this.startStamp = System.currentTimeMillis();
    }

    public JsonResponse outPutSuccess(){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        return this;
    }

    public JsonResponse outPutSuccess(HashMap dataMap){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.respData = JSONObject.fromObject(dataMap);
        return this;
    }

    public JsonResponse outPutSuccess(ArrayList dataList){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.error = false;
        this.respData = JSONArray.fromObject(dataList);
        return this;
    }

    public JsonResponse outPutSuccess(JSON json){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.error = false;
        this.respData = json;
        return this;
    }
    public JsonResponse outPutSuccess(JSONArray json){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.respData = json;
        this.error = false;
        return this;
    }
    public JsonResponse outPutSuccessCassandra(JSON json){
        this.respData = json;
        return this;
    }

    public JsonResponse outPutSuccess(String string){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.error = false;
        HashMap map = new HashMap<String, Any>(16);
        map.put("string", string);
        this.respData = JSONObject.fromObject(map);
        return this;
    }
    public JsonResponse outPutSuccess(Boolean string){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.error = false;
        HashMap map = new HashMap<String, Any>(16);
        map.put("boolean", string);
        this.respData = JSONObject.fromObject(map);
        return this;
    }

    public JsonResponse outPutError(String returnCode, String returnMsg){
        this.serverProcessingFinishStamp = System.currentTimeMillis();
        this.serverProcessingDur = this.serverProcessingFinishStamp - this.startStamp;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.error = true;
        return this;
    }

    private JSONObject toJSON(){
        HashMap map = new HashMap<String, Any>(16);
        map.put("ProcessingDur", this.serverProcessingDur);
        map.put("FinishStamp", this.serverProcessingFinishStamp);
        map.put("Code", this.returnCode);
        map.put("Msg", this.returnMsg);
        map.put("Error", this.error);
        map.put("Data", this.respData);
        return JSONObject.fromObject(map);
    }

    public String toJSONString(){
        return this.toJSON().toString();
    }
}