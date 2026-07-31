/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.lms.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="lms_assessment") public class Assessment extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String assessmentNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private LearningPlan learningPlan;
    @Column(nullable=false,length=30) private String assessmentType; @Column(nullable=false) private int assessmentQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected Assessment(){} public Assessment(String assessmentNo,LearningPlan learningPlan,String assessmentType,int assessmentQty,int defectQty,Result result,String inspector){this.assessmentNo=assessmentNo;this.learningPlan=learningPlan;this.assessmentType=assessmentType;this.assessmentQty=assessmentQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getAssessmentNo(){return assessmentNo;} public LearningPlan getLearningPlan(){return learningPlan;} public String getAssessmentType(){return assessmentType;} public int getAssessmentQty(){return assessmentQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
