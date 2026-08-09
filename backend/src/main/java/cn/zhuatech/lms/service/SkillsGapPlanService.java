/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.lms.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SkillsGapPlanService {
    public Result plan(Request request) {
        List<GapItem> gaps = request.skills().stream().map(skill -> {
            int gap = Math.max(0, skill.targetLevel() - skill.currentLevel());
            return new GapItem(skill.skillName(), gap, skill.priority(),
                gap == 0 ? 0 : skill.estimatedLearningHours());
        }).filter(item -> item.gap() > 0)
            .sorted(Comparator.comparingInt((GapItem item) -> item.gap() * item.priority()).reversed())
            .toList();
        int weightedGap = gaps.stream().mapToInt(item -> item.gap() * item.priority()).sum();
        int totalHours = gaps.stream().mapToInt(GapItem::learningHours).sum();
        int criticalGaps = (int) gaps.stream()
            .filter(item -> item.gap() >= 30 && item.priority() >= 4).count();
        int durationWeeks = totalHours == 0 ? 0
            : (int) Math.ceil((double) totalHours / request.weeklyLearningHours());
        String decision = criticalGaps >= 2 || durationWeeks > 12 ? "URGENT"
            : gaps.isEmpty() ? "READY" : "PLAN";
        List<String> prioritySkills = gaps.stream().limit(3).map(GapItem::skillName).toList();
        return new Result(request.employeeNo(), request.targetRole(), weightedGap,
            criticalGaps, totalHours, durationWeeks, decision, prioritySkills);
    }

    public record Request(@NotBlank String employeeNo, @NotBlank String targetRole,
                          @Min(1) int weeklyLearningHours,
                          @NotEmpty List<@Valid SkillLevel> skills) {}

    public record SkillLevel(@NotBlank String skillName,
                             @Min(0) @Max(100) int currentLevel,
                             @Min(0) @Max(100) int targetLevel,
                             @Min(1) @Max(5) int priority,
                             @Min(1) int estimatedLearningHours) {}

    public record GapItem(String skillName, int gap, int priority, int learningHours) {}

    public record Result(String employeeNo, String targetRole, int weightedGap,
                         int criticalGaps, int totalLearningHours, int durationWeeks,
                         String decision, List<String> prioritySkills) {}
}
