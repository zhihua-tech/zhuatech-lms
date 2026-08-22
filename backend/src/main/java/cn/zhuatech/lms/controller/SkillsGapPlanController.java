/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.controller;

import cn.zhuatech.lms.common.ApiResponse;
import cn.zhuatech.lms.service.SkillsGapPlanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lms/insights")
public class SkillsGapPlanController {
    private final SkillsGapPlanService service;

    public SkillsGapPlanController(SkillsGapPlanService service) {
        this.service = service;
    }

    @PostMapping("/skills-gap-plan")
    public ApiResponse<SkillsGapPlanService.Result> plan(
        @Valid @RequestBody SkillsGapPlanService.Request request) {
        return ApiResponse.ok(service.plan(request));
    }
}
