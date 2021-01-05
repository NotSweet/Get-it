package cn.hevttc.service.authentication;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据访问请求
 *
 * @author NiuHeng
 * @date 2018/1/8 13:34
 */
public class HttpRequest {

    public String authen(String usname,String password) {
        //http://jwsys.ctbu.edu.cn/
        //http://jwgl.cmc.edu.cn/
        //http://60.8.4.248:10003/
        //http://jwgl.wmu.edu.cn/
        //http://jwgl.wmu.edu.cn/
        String url = "http://121.22.25.47/";
        String uri = url + "default2.aspx";
        String uricode = url + "CheckCode.aspx";
        String result="";
        HttpUtil httpUtil = new HttpUtil();
        try {
            String view = httpUtil.get(uri);
            String code = httpUtil.getCode(uricode);
            HashMap map = httpUtil.post(uri, usname, password, code, view);
            System.out.println(view);
            System.out.println(code);
            result = (String) map.get(HttpUtil.RESULT_KEY);
            System.out.println(result);
            String cookie = "";
            System.out.println("Post logon cookies:");
            List<Cookie> cookies = (List<Cookie>) map.get(HttpUtil.COOKIES_KEY);
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (Cookie cooky : cookies) {
                    System.out.println("- " + cooky.toString());
                    cookie = "ASP.NET_SessionId="+cooky.getValue();
                    System.out.println(cookie);
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            httpUtil.close();
        }




//        String postresult = httpUtil.getOther(url+"xs_main.aspx");
//        System.out.println(postresult);
//        String postresult = httpUtil.getOther(url+"xskbcx.aspx?xh=0951160716");
//        System.out.println(postresult);

        return result;

    }
}
