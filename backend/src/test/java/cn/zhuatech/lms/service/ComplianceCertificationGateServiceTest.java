/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ComplianceCertificationGateServiceTest {
    private final ComplianceCertificationGateService service = new ComplianceCertificationGateService();

    @Test void certifiesACompleteLearnerRecord() {
        var result = service.assess(new ComplianceCertificationGateService.Request(
            "ENR-001", "SAFE-101", true, 100, 92, 80, true, true, true, true, 365));
        assertThat(result.decision()).isEqualTo(ComplianceCertificationGateService.Decision.CERTIFIED);
        assertThat(result.compliant()).isTrue();
    }

    @Test void blocksIncompleteComplianceTraining() {
        var result = service.assess(new ComplianceCertificationGateService.Request(
            "ENR-002", "SAFE-101", true, 80, 60, 80, false, true, false, false, 365));
        assertThat(result.decision()).isEqualTo(ComplianceCertificationGateService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(5);
    }

    @Test void createsRenewalWorkForExpiringCertificate() {
        var result = service.assess(new ComplianceCertificationGateService.Request(
            "ENR-003", "SAFE-101", true, 100, 90, 80, true, false, false, true, 20));
        assertThat(result.decision()).isEqualTo(ComplianceCertificationGateService.Decision.RENEWAL_DUE);
    }
}
