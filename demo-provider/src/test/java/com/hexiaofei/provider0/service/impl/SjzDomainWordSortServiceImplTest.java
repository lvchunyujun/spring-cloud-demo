package com.hexiaofei.provider0.service.impl; 

import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.service.AbstractTest;
import com.hexiaofei.provider0.service.SjzDomainWordSortService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* SjzDomainWordSortServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 28, 2019</pre> 
* @version 1.0 
*/

public class SjzDomainWordSortServiceImplTest extends AbstractTest {

    @Autowired
    SjzDomainWordSortService sjzDomainWordSortService;


    @Before
    public void before() throws Exception {

    } 

    @After
    public void after() throws Exception { 
    } 

        /** 
    * 
    * Method: addObject(SjzDomainWordSort mob) 
    * 
    */ 
    @Test
    public void testAddObject() throws Exception {
        SjzDomainWordSort sjzDomainWordSort = new SjzDomainWordSort();
        int resultId = sjzDomainWordSortService.addObject(sjzDomainWordSort);
        Assert.assertTrue("添加用户失败！",resultId > 0);
    } 

    /**
    * 
    * Method: deleteObjectById(int id) 
    * 
    */ 
    @Test
    public void testDeleteObjectById() throws Exception { 

    } 

        /** 
    * 
    * Method: updateObject(SjzDomainWordSort mob) 
    * 
    */ 
    @Test
    public void testUpdateObject() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getObjectById(int id) 
    * 
    */ 
    @Test
    public void testGetObjectById() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getPageVoObject(PageVo<SjzDomainWordSort> pageVo) 
    * 
    */ 
    @Test
    public void testGetPageVoObject() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getAllObject() 
    * 
    */ 
    @Test
    public void testGetAllObject() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getCursorByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) 
    * 
    */ 
    @Test
    public void testGetCursorByDomainSpiderTaskList() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getListByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) 
    * 
    */ 
    @Test
    public void testGetListByDomainSpiderTaskList() throws Exception { 
    //TODO: Test goes here... 
    } 

    
}
