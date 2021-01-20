package com.dsc.mall.demo;

import com.dsc.mall.model.PmsProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationContext.class)
public class MallApplicationTest {
    private Logger logger = LoggerFactory.getLogger(MallApplication.class);
    @Test
    public void contextLoads() {
    }

    @Test
    public void testLogStash() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PmsProduct product = new PmsProduct();
        product.setId(1L);
        product.setName("小米手机");
        product.setBrandName("小米");
        logger.info(mapper.writeValueAsString(product));
        logger.error(mapper.writeValueAsString(product));
    }

}
