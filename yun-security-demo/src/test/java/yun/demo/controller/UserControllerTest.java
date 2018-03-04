package yun.demo.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author yzhang
 * @date 2018/3/3 18:58
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * 构建mvc测试环境
     */
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void whenQuerySuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "aaa")
                .param("age", "22")
                .param("ageTo", "20-30")
                .param("xxxx", "xxxx")
//                .param("size","3")
//                .param("page","1")
//                .param("sort","username desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenGetInfoSuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenCreateSuccess() throws Exception{

        Date date = new Date();
        String content = "{\"username\":\"tom\",\"password\":\"pass\",\"date\":\""+date.getTime()+"\"}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void whenEditSuccess() throws Exception{

        Date date = new Date(LocalDateTime.now()/*.plusYears(1)*/.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        System.out.println(date);
        String content = "{\"username\":\"tom\",\"password\":null,\"date\":\""+date.getTime()+"\"}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }
}
