package me.guopop.jpademo.controller;

import cn.hutool.json.JSONUtil;
import me.guopop.jpademo.entity.main.Product;
import me.guopop.jpademo.entity.sxuh.FerryLog;
import me.guopop.jpademo.repository.main.ProductRepository;
import me.guopop.jpademo.repository.sxuh.FerryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author guopop
 * @date 2021/1/11 9:11
 */
@RestController
public class HelloController {

    @Autowired
    private FerryLogRepository ferryLogRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/hello")
    public String hello() {
        String s1 = "";
        Optional<FerryLog> any = ferryLogRepository.findAll().stream().findAny();
        if (any.isPresent()) {
             s1 = JSONUtil.toJsonStr(any.get());
        }

        Product product = new Product();
        product.setName("product1");
        product.setPrice(new BigDecimal(22));
        Product product1 = productRepository.save(product);
        String s2 = JSONUtil.toJsonStr(product1);

        return s1 + "---" + s2;
    }
}
