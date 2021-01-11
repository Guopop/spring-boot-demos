package me.guopop.jpademo.repository.main;

import me.guopop.jpademo.entity.main.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guopop
 * @date 2021/1/11 9:13
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
