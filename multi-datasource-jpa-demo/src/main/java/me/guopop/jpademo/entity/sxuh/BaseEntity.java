package me.guopop.jpademo.entity.sxuh;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author guopop
 * @date 2020/12/22 11:01
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    private LocalDateTime createDate = LocalDateTime.now().withNano(0);

    private LocalDateTime lastDate = LocalDateTime.now().withNano(0);
}
