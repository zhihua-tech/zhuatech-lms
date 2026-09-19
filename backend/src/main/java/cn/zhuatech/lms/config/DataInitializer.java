/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.config;

import cn.zhuatech.lms.model.*;
import cn.zhuatech.lms.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Configuration
public class DataInitializer {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Bean
    CommandLineRunner seed(AcademyRepository academys, LearningPlanRepository orders,
                           CourseRepository courses, AssessmentRepository assessments,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (academys.count() > 0) return;
            Academy chemistry = academys.save(new Academy("ACD-CHEM", "专业能力学院", "人才发展中心", 180));
            Academy micro = academys.save(new Academy("ACD-MICRO", "领导力学院", "研发中心", 120));
            Academy material = academys.save(new Academy("ACD-MAT", "新员工学院", "工程中心", 96));

            LearningPlan t1 = orders.save(new LearningPlan("LP-260801-018", "GB-T-228", "项目经理能力认证", material, 24, 16, 1, LocalDate.now().plusDays(1), LearningPlan.Status.RUNNING, "S260801-A"));
            LearningPlan t2 = orders.save(new LearningPlan("LP-260801-021", "HPLC-042", "新员工入职培养", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), LearningPlan.Status.RUNNING, "S260801-C"));
            LearningPlan t3 = orders.save(new LearningPlan("LP-260802-006", "ISO-4833", "信息安全年度必修", micro, 12, 0, 0, LocalDate.now().plusDays(3), LearningPlan.Status.RELEASED, "S260802-B"));
            LearningPlan t4 = orders.save(new LearningPlan("LP-260731-015", "ICP-017", "领导力训练营", chemistry, 20, 20, 1, LocalDate.now(), LearningPlan.Status.COMPLETED, "S260731-D"));

            courses.saveAll(List.of(
                new Course("CRS-HPLC-03", "项目管理实战课 03", chemistry, Course.Status.RUNNING, 88),
                new Course("CRS-ICP-02", "领导力案例课程", chemistry, Course.Status.IDLE, 76),
                new Course("CRS-UTM-05", "新员工文化课程", material, Course.Status.RUNNING, 91),
                new Course("CRS-INC-08", "信息安全课程 08", micro, Course.Status.ALARM, 62)
            ));
            assessments.saveAll(List.of(
                new Assessment("ASM-260801-032", t1, "留样考核", 6, 0, Assessment.Result.PASSED, "周妍"),
                new Assessment("ASM-260801-011", t2, "前处理考核", 3, 0, Assessment.Result.PASSED, "陆承"),
                new Assessment("ASM-260801-018", t4, "结果考核", 5, 1, Assessment.Result.FAILED, "周妍"),
                new Assessment("ASM-260802-003", t3, "收样确认", 4, 0, Assessment.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.LEARNER, "ACD-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.LMS_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
