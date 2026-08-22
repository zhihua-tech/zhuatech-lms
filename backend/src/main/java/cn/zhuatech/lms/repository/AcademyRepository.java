/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.repository; import cn.zhuatech.lms.model.Academy; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface AcademyRepository extends JpaRepository<Academy,Long>{Optional<Academy> findByCode(String code);}
