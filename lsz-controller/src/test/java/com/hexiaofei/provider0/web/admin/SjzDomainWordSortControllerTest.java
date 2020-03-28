package com.hexiaofei.provider0.web.admin; 

import com.hexiaofei.provider0.LszControllerApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* SjzDomainWordSortController Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 28, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={LszControllerApplication.class})
@WebAppConfiguration
@ContextConfiguration
public class SjzDomainWordSortControllerTest {


    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    } 

    @After
    public void after() throws Exception { 
    } 

        /** 
    * 
    * Method: index() 
    * 
    */ 
    @Test
    public void testIndex() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: toAdd() 
    * 
    */ 
    @Test
    public void testToAdd() throws Exception {

    } 

        /** 
    * 
    * Method: add(SjzDomainWordSort sjzDomainWordSort) 
    * 
    */ 
    @Test
    public void testAdd() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: toUpdate(Integer id) 
    * 
    */ 
    @Test
    public void testToUpdate() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: update(SjzDomainWordSort sjzDomainWordSort) 
    * 
    */ 
    @Test
    public void testUpdate() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: listEventIndex(SjzDomainWordSort sjzDomainWordSort, @PathVariable int currentPage, @PathVariable int pageSize) 
    * 
    */ 
    @Test
    public void testListEventIndex() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getResultCode() 
    * 
    */ 
    @Test
    public void testGetResultCode() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: setResultCode(String resultCode) 
    * 
    */ 
    @Test
    public void testSetResultCode() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getResultMsg() 
    * 
    */ 
    @Test
    public void testGetResultMsg() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: setResultMsg(String resultMsg) 
    * 
    */ 
    @Test
    public void testSetResultMsg() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: getData() 
    * 
    */ 
    @Test
    public void testGetData() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: setData(Object data) 
    * 
    */ 
    @Test
    public void testSetData() throws Exception { 
    //TODO: Test goes here... 
    } 

        /** 
    * 
    * Method: toString() 
    * 
    */ 
    @Test
    public void testToString() throws Exception { 
    //TODO: Test goes here... 
    } 

    
    } 
