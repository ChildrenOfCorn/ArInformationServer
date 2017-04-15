package com.github.childrenofcorn.main;

/**
 * Created by grishberg on 15.04.17.
 */

import com.github.childrenofcorn.common.ConfigContext;
import com.github.childrenofcorn.common.ConfigReader;
import com.github.childrenofcorn.data.model.ProductInfo;
import com.github.childrenofcorn.services.accounts.AccountService;
import com.github.childrenofcorn.services.accounts.AccountServiceInMemoryImpl;
import com.github.childrenofcorn.services.info.InfoService;
import com.github.childrenofcorn.services.info.InfoServiceImpl;
import com.github.childrenofcorn.services.comment.CommentService;
import com.github.childrenofcorn.services.comment.CommentServiceImpl;
import com.github.childrenofcorn.services.link.LinkService;
import com.github.childrenofcorn.services.link.LinkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.github.childrenofcorn")
public class Application {
    public static void main(String[] args) {
        log.info("--------------");
        log.info("AR info server v.1.0.0");
        log.info("--------------");
        SpringApplication.run(Application.class, args);
    }

    //---- DI ------

    @Bean(name = "accountService")
    public AccountService accountService() {
        return new AccountServiceInMemoryImpl();
    }

    @Bean(name = "commentService")
    @Autowired
    public CommentService commentService() {
        return new CommentServiceImpl();
    }

    @Bean(name = "linkService")
    @Autowired
    public LinkService linkService() {
        return new LinkServiceImpl();
    }

    @Bean(name = "infoService")
    @Autowired
    public InfoService infoService() {
        InfoServiceImpl infoService = new InfoServiceImpl();
        initService(infoService);
        return infoService;
    }

    private void initService(InfoServiceImpl infoService) {
        ProductInfo[] productInfoList = importProducts();
        log.info(String.format("added %d items", productInfoList.length));
        for (ProductInfo productInfo : productInfoList) {
            infoService.addProductInfo(productInfo.getId(), productInfo);
        }
    }

    private ProductInfo[] importProducts() {
        ConfigContext configContext = ConfigReader.readConfig();
        if (configContext == null || configContext.getProductInfos() == null) {
            return new ProductInfo[0];
        }
        return configContext.getProductInfos();
    }
}
