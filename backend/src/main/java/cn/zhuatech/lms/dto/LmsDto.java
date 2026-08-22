/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class LmsDto { private LmsDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record LearningPlanView(Long id,String orderNo,String productCode,String productName,String academy,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record CourseView(String code,String name,String academy,String status,int oee,LocalDateTime lastHeartbeat){}
    public record AssessmentView(String assessmentNo,String orderNo,String productName,String assessmentType,int assessmentQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<LearningPlanView> learningPlans,List<CourseView> course,List<AssessmentView> assessments){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
