/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.controller;
import cn.zhuatech.lms.common.ApiResponse; import cn.zhuatech.lms.service.CompletionRiskService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") public class CompletionRiskController {private final CompletionRiskService service; /**
                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                   */
public CompletionRiskController(CompletionRiskService service){this.service=service;} /**
                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                         */
@PostMapping("/completion-risk") public ApiResponse<CompletionRiskService.Result> evaluate(@Valid @RequestBody CompletionRiskService.Request request){return ApiResponse.ok(service.evaluate(request));}}

