/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.lms.controller;
import cn.zhuatech.lms.common.ApiResponse; import cn.zhuatech.lms.service.CompletionRiskService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin") public class CompletionRiskController {private final CompletionRiskService service; public CompletionRiskController(CompletionRiskService service){this.service=service;} @PostMapping("/completion-risk") public ApiResponse<CompletionRiskService.Result> evaluate(@Valid @RequestBody CompletionRiskService.Request request){return ApiResponse.ok(service.evaluate(request));}}

