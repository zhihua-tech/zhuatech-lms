/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.repository; import cn.zhuatech.lms.model.Assessment; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AssessmentRepository extends JpaRepository<Assessment,Long>{List<Assessment> findTop10ByOrderByIdDesc();long countByResult(Assessment.Result result);}
