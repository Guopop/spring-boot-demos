package me.guopop.jpademo.repository.sxuh;

import me.guopop.jpademo.entity.sxuh.FerryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guopop
 * @date 2020/12/22 14:29
 */
@Repository
public interface FerryLogRepository extends JpaRepository<FerryLog, Long> {
}
