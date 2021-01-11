package me.guopop.jpademo.entity.sxuh;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author guopop
 * @date 2020/12/22 10:58
 */
@Getter
@Setter
@Entity
@Table(name = "FERRY_LOG")
public class FerryLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ferryLogGenerator")
    @SequenceGenerator(name = "ferryLogGenerator", sequenceName = "ferry_log_sequence", allocationSize = 1)
    private Long id;

    private String serviceName;

    private String apiPath;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private String message;

    public enum Type {
        REQUEST,
        RESPONSE
        ;
    }
}
