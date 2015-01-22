package test.spring.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.examples.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by L.x on 15-1-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class SpringRequestScopedBeanTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @PostConstruct
    public void mockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private String perform() throws Exception {
        return mvc.perform(get("/user/zhangsan")).andReturn().getResponse().getContentAsString();
    }

    @Test
    public void returnUserName() throws Exception {
        assertThat(perform(), startsWith("zhangsan::"));
    }

    @Test
    public void createRequestScopeBeanPerRequest() throws Exception {
        assertThat(perform(), not(equalTo(perform())));
    }
}
