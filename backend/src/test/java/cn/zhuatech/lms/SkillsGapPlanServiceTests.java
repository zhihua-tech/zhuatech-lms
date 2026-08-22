/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms;

import cn.zhuatech.lms.service.SkillsGapPlanService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillsGapPlanServiceTests {
    private final SkillsGapPlanService service = new SkillsGapPlanService();

    @Test
    void prioritizesCriticalRoleSkillGaps() {
        var result = service.plan(new SkillsGapPlanService.Request("E1001", "解决方案架构师", 4, List.of(
            new SkillsGapPlanService.SkillLevel("架构设计", 40, 80, 5, 40),
            new SkillsGapPlanService.SkillLevel("项目治理", 35, 70, 4, 30),
            new SkillsGapPlanService.SkillLevel("客户沟通", 75, 80, 3, 8))));

        assertEquals(2, result.criticalGaps());
        assertEquals("URGENT", result.decision());
        assertEquals("架构设计", result.prioritySkills().getFirst());
    }

    @Test
    void recognizesRoleReadyEmployee() {
        var result = service.plan(new SkillsGapPlanService.Request("E1002", "实施顾问", 4, List.of(
            new SkillsGapPlanService.SkillLevel("需求分析", 85, 80, 5, 10),
            new SkillsGapPlanService.SkillLevel("系统配置", 90, 85, 5, 10))));

        assertEquals("READY", result.decision());
        assertEquals(0, result.durationWeeks());
    }
}
