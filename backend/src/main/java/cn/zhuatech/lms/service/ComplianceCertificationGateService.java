/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComplianceCertificationGateService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (request.mandatory() && request.completionPercent() < 100) blockers.add("必修课程尚未完成");
        if (request.examScore() < request.passingScore()) blockers.add("考试成绩未达到合格线");
        if (!request.identityVerified()) blockers.add("学习与考试身份未核验");
        if (request.practicalAssessmentRequired() && !request.practicalPassed()) blockers.add("实操考核未通过");
        if (!request.policyAcknowledged()) blockers.add("相关制度尚未签收确认");
        if (!blockers.isEmpty()) {
            actions.add("完成补训或复核后重新执行认证门禁");
            return new Assessment(Decision.BLOCKED, false, blockers, actions);
        }
        if (request.certificateExpiryDays() <= 30) {
            actions.add("证书将在 30 天内到期，创建复训和续证任务");
            return new Assessment(Decision.RENEWAL_DUE, true, blockers, actions);
        }
        actions.add("签发证书并写入岗位合规档案");
        return new Assessment(Decision.CERTIFIED, true, blockers, actions);
    }

    public record Request(@NotBlank String enrollmentId, @NotBlank String courseCode,
                          boolean mandatory, @Min(0) @Max(100) int completionPercent,
                          @Min(0) @Max(100) int examScore,
                          @Min(0) @Max(100) int passingScore, boolean identityVerified,
                          boolean practicalAssessmentRequired, boolean practicalPassed,
                          boolean policyAcknowledged, @Min(0) int certificateExpiryDays) {}
    public record Assessment(Decision decision, boolean compliant, List<String> blockers,
                             List<String> actions) {}
    public enum Decision { CERTIFIED, RENEWAL_DUE, BLOCKED }
}
