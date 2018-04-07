package test.java.service;

/**
 * Created by slzZp on 2018/1/31.
 */


import dao.StoneDao;
import domain.Stone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


import java.util.ArrayList;
import java.util.List;

public class StoneDaoImplTests {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception
    {
        applicationContext=new ClassPathXmlApplicationContext("classpath:mvc-dispatcher-servlet.xml");

    }

    public void testFindStoneByCategories() throws Exception {
        StoneDao stoneDao=(StoneDao) applicationContext.getBean("stoneDao");
//        Stone stone=stoneDao.findStoneByCategories("0-2.35水碎");
//        String[] str = {"测试数据","1234","测试数据2","1234","测试数据3","1234","测试数据4","12345"};
        String[] str = {"测试数据4","1234","20170809"};
        List<Stone> list = new ArrayList<Stone>();
//        for(int i = 0;i<str.length;i++){
//            Stone stone = new Stone();
//            if(i%2==0){stone.setStone_categories(str[i]);stone.setSheer_weight(Float.valueOf(str[i+1])); stone.setWeighing_date( str[i+2]);if(stone!=null){list.add(stone);}else {}}
//        }
        Stone stone =new Stone();
        stone.setStone_categories(str[0]);stone.setSheer_weight(Float.valueOf(str[1])); stone.setWeighing_date( str[2]);if(stone!=null){list.add(stone);}else {}
        stoneDao.batchInsert(list);


    }

    public void testFindStone() throws Exception{
        StoneDao stoneDao =(StoneDao) applicationContext.getBean("stoneDao");
        List<Stone> listStone = stoneDao.findStone();
        System.out.println(listStone);
    }

    public void testaddSumByCategories() throws Exception{
        StoneDao stoneDao =(StoneDao) applicationContext.getBean("stoneDao");
        float sum = stoneDao.addSumByCategories("水稳碎石1#（19-26.5）");
        System.out.println(sum);
    }

    public void testfindStoneByWeighingDate() throws Exception{
        StoneDao stoneDao =(StoneDao) applicationContext.getBean("stoneDao");
        List<Stone> listStone = stoneDao.findStoneByWeighingDate("20170701");
        System.out.println(listStone);
    }
    @Test
    public void testaddSumByWeighingDate() throws Exception{
        StoneDao stoneDao =(StoneDao) applicationContext.getBean("stoneDao");
        Float f = stoneDao.addSumByWeighingDate("20170711");
        System.out.println(f);
    }


}
