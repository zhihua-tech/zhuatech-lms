/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="lms_assessment") public class Assessment extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String assessmentNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private LearningPlan learningPlan;
    @Column(nullable=false,length=30) private String assessmentType; @Column(nullable=false) private int assessmentQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Assessment(){} /**
                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                              */
public Assessment(String assessmentNo,LearningPlan learningPlan,String assessmentType,int assessmentQty,int defectQty,Result result,String inspector){this.assessmentNo=assessmentNo;this.learningPlan=learningPlan;this.assessmentType=assessmentType;this.assessmentQty=assessmentQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getAssessmentNo(){return assessmentNo;} /**
                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                           */
public LearningPlan getLearningPlan(){return learningPlan;} /**
                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                       */
public String getAssessmentType(){return assessmentType;} /**
                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                 */
public int getAssessmentQty(){return assessmentQty;} /**
                                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                      */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                   */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                             */
public String getInspector(){return inspector;}
}
