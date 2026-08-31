/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.controller;

import cn.zhuatech.lms.common.ApiResponse;
import cn.zhuatech.lms.service.ComplianceCertificationGateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/lms")
public class ComplianceCertificationGateController {
    private final ComplianceCertificationGateService service;
    public ComplianceCertificationGateController(ComplianceCertificationGateService service) { this.service = service; }

    @PostMapping("/compliance-certification-gate")
    public ApiResponse<ComplianceCertificationGateService.Assessment> assess(
        @Valid @RequestBody ComplianceCertificationGateService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
