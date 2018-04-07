package com.springapp.mvc;

import dao.StoneDao;
import domain.Stone;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class mController {
    private ApplicationContext applicationContext;
    @RequestMapping(value="/index.html")
    public String index(){return "index";}
//    @RequestMapping(value="/test.html")
//    public @ResponseBody String ersubmit(
//            @RequestParam(value = "categories") String categories
//    ){
//            System.out.println(categories);
//            return "";
//    }
    @RequestMapping(value="/test.html")
    public @ResponseBody void ersubmit(
            @RequestParam Map<String, Object> param,HttpServletResponse response
    )throws  Exception{
        applicationContext=new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");
        StoneDao stoneDao=(StoneDao) applicationContext.getBean("stoneDao");

        System.out.println(param);
        Set<Map.Entry<String, Object>> ks = param.entrySet();
        Iterator<Map.Entry<String, Object>> it =  ks.iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> en = it.next();
            String key  = en.getKey();
            String value = (String) en.getValue();

            System.out.println("key="+key+"     "+"value="+value);  //前台封装的value,接下来拆解value
//            String[] v  = value.split("\\[");
//            String[] vd = v[1].split("]")[0].split("[{\\}]");
            String[] v = value.split("[|]");//多个条件使用|  隔开，[]为条件隔开
            String[] vd = v[0].split("[{\\}]");   //目的，只要花括号里面的内容
            System.out.println(v[0]);
            System.out.println(vd[1]);
//            DecimalFormat df = new DecimalFormat("########.##");//float转字符串
            List<Stone> listStone = new ArrayList<>();//创建列表，mybatis批量添加需要的参数是 列表
            for(int i=0 ; i<vd.length;i++){
                Stone stone = new Stone();
                if(i%2!=0){
                    stone.setStone_categories(vd[i].split(":|,")[1].trim().replace("\"",""));
                    stone.setSheer_weight(Float.valueOf(vd[i].split(":|,")[3].replace("\"","")));
//                  stone.setWeighing_date(simpleDateFormat.parse(vd[i].split(":|,")[5].replace("\"","")));
                    stone.setWeighing_date(vd[i].split(":|,")[5].replace("\"",""));
                    stone.setVendor(vd[i].split(":|,")[7].replace("\"",""));
                    if(stone!=null){listStone.add(stone);}
                }
            }
            try{
            stoneDao.batchInsert(listStone);}catch (Exception e){e.printStackTrace();}
            System.out.println(listStone);
//            System.out.println(vd[5].split(":|,")[1]);   确定奇数是要得到的 值
//            System.out.println(vd[5].split(":|,")[3]);
        }
        /**
         * 测试返回json格式的数据到前台ajax

        List<Stone> list = new ArrayList<>();
        for(int i=0;i<2;i++){
            Stone stone = new Stone();
            stone.setWeighing_date("20170702");
            stone.setVendor("Vogloe");
            stone.setStone_categories("碎石");
            list.add(stone);
        }

        System.out.println(list);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonArray);
         */
        /*
        List<Stone> listStone_ = stoneDao.findStone();
        JSONArray jsonArray = JSONArray.fromObject(listStone_);
        response.setContentType("text/html;charset=utf-8");
         */

    }
    @RequestMapping(value = "/display.html")
    public void display_echarts(HttpServletResponse response) throws  Exception{
        applicationContext=new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");
        StoneDao stoneDao=(StoneDao) applicationContext.getBean("stoneDao");

        List<Float> listSum = new ArrayList<>();
        String categories[] = {"水稳碎石1#（19-26.5）","水稳碎石2#（9.5-19）","水稳碎石3#（4.75-9.5）","水稳碎石4#（2.36-4.75）","水稳碎石5#（0-2.36）"};
        for(int i = 0;i<categories.length;i++){
            listSum.add(stoneDao.addSumByCategories(categories[i]));
        }
        JSONArray jsonArray = JSONArray.fromObject(listSum);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonArray);
    }
    @RequestMapping(value = "/display_.html")
    public void display_echarts_(HttpServletResponse response) throws Exception{
        applicationContext=new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");
        StoneDao stoneDao=(StoneDao) applicationContext.getBean("stoneDao");

        List<Stone> listSum = new ArrayList<>();
        int date = 20170701;
        String sdate = "";
        for(int i=0 ;i<31; i++){
            Stone stone = new Stone();
            sdate  = Integer.toString(date);
            Float sum = stoneDao.addSumByWeighingDate(sdate);
            if(sum!=null){System.out.println(sum+"-----------"+sdate);
                stone.setSheer_weight_sum(sum);
                stone.setWeighing_date(sdate);
                listSum.add(stone);}


            date+=1;
        }
        JSONArray jsonArray = JSONArray.fromObject(listSum);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonArray);
    }
}
