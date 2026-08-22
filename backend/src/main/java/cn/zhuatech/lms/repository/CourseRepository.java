/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.repository; import cn.zhuatech.lms.model.Course; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface CourseRepository extends JpaRepository<Course,Long>{List<Course> findAllByOrderByCodeAsc();long countByStatus(Course.Status status);}
