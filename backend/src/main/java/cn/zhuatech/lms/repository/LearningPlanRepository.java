/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.lms.repository; import cn.zhuatech.lms.model.LearningPlan; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface LearningPlanRepository extends JpaRepository<LearningPlan,Long>{List<LearningPlan> findAllByOrderByDueDateAsc();List<LearningPlan> findByAcademyCodeOrderByDueDateAsc(String code);long countByStatus(LearningPlan.Status status);}
