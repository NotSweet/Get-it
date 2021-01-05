package cn.hevttc.service.authentication;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Http工具类
 *
 * @author NiuHeng
 * @date 2018/1/8 15:44
 */
public class HttpUtil {
    public static String RESULT_KEY = "result";
    public static String COOKIES_KEY = "cookies";
    private CloseableHttpClient httpclient = null;
//    private  Pattern alertPattern = Pattern.compile("<script(?:[^<]++|<(?!/script>))*+</script>");



    private static Pattern alertPattern = Pattern.compile("alert[('\")\\s]*([\\u4e00-\\u9fa5]*)");
    private static Pattern viewPattern = Pattern.compile("__VIEWSTATE\\W*\\w*\\W*([a-zA-Z0-9=]+)");

    private CookieStore cookieStore = null;
    private void createClient() {
        if(httpclient==null) {
            cookieStore = new BasicCookieStore();
            httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        }
    }

    public HashMap post(String uri, String username, String password, String code,String view) throws URISyntaxException, IOException {
        createClient();
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI(uri))
                .addHeader("Referer",uri)
                .addParameter("txtSecretCode", code)
                .addParameter("__VIEWSTATE", view)
                .addParameter("Button1", "")
                .addParameter("RadioButtonList1", "学生")
                .addParameter("txtUserName", username)
                .addParameter("TextBox2", password)
                .build();

        String response2 = httpclient.execute(login, getHandler());
        HashMap<String,Object> hashMap= new HashMap<>(16);

        String result = getAlert(response2);
        hashMap.put(RESULT_KEY,result);
        hashMap.put(COOKIES_KEY,cookieStore.getCookies());
        return hashMap;
    }

    public String get(String uri) throws URISyntaxException, IOException {
        createClient();
        HttpGet httpget = new HttpGet(uri);
        String result = httpclient.execute(httpget,getHandler());
        return getVIEWSTATE(result);
    }

    public String getOther(String uri) throws URISyntaxException, IOException {
        createClient();
        HttpGet httpget = new HttpGet(uri);
        httpget.addHeader("Referer","http://121.22.25.47:81/xs_main.aspx?xh=0951160716");
        String result = httpclient.execute(httpget,getHandler());
        return result;
    }

    //            BufferedImage img = new BufferedImage(72, 27, BufferedImage.TYPE_INT_RGB);
    //            img.getGraphics().drawImage(bufferedImage, 0, 0, 72, 27, null);

    public String getCode(String uri) throws URISyntaxException, IOException {
        GraphicC2Translator translator = GraphicC2Translator.getInstance();
        createClient();
        HttpGet getMethod = new HttpGet(uri);
        HttpResponse response = httpclient.execute(getMethod, new BasicHttpContext());
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        BufferedImage  bufferedImage = ImageIO.read(inputStream);
        String result = translator.translateimg(bufferedImage);
        inputStream.close();
        return result;

    }

    private ResponseHandler<String> getHandler(){
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else if (status == 302) {
                return "302";
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        return responseHandler;
    }

    private String getAlert(String s) {
        Matcher m = alertPattern.matcher(s);
        if(m.find()) {
            s = m.group(1);
        }
        return s;
    }
    private String getVIEWSTATE(String s) {
        Matcher m = viewPattern.matcher(s);
        if(m.find()) {
            s = m.group(1);
        }
        return s;
    }

    public void close() {
        try {
            if (httpclient!=null) {
                httpclient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
