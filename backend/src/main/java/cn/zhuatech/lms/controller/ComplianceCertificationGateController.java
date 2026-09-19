/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.controller;

import cn.zhuatech.lms.common.ApiResponse;
import cn.zhuatech.lms.service.ComplianceCertificationGateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/lms")
public class ComplianceCertificationGateController {
    private final ComplianceCertificationGateService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ComplianceCertificationGateController(ComplianceCertificationGateService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/compliance-certification-gate")
    public ApiResponse<ComplianceCertificationGateService.Assessment> assess(
        @Valid @RequestBody ComplianceCertificationGateService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
