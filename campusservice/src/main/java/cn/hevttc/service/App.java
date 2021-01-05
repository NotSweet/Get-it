package cn.hevttc.service;

import com.blade.Blade;
import com.blade.mvc.annotation.GetRoute;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Blade.me()
                .get("/",	(request, response) -> response.text("Hello World"))
                .addStatics("/mui-0.9.27")
                .start(App.class, args);
    }


}
