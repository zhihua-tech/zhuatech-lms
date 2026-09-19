/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lms.service;
import jakarta.validation.constraints.*; import org.springframework.stereotype.Service; import java.util.ArrayList; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class CompletionRiskService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request r){
        double completion=r.assignedCourses()==0?100:r.completedCourses()*100.0/r.assignedCourses();
        int risk=(int)Math.round(Math.max(0,100-completion)*.35)+Math.min(30,r.overdueCourses()*8)+Math.min(20,r.daysInactive()/2)+Math.min(15,r.mandatoryOpen()*5)+Math.max(0,70-r.averageScore())/3-Math.min(10,r.managerCheckins()*2);
        risk=Math.max(0,Math.min(100,risk)); String level=risk>=70?"CRITICAL":risk>=45?"HIGH":risk>=20?"MEDIUM":"LOW";
        List<String> actions=new ArrayList<>(); if(r.overdueCourses()>0)actions.add("优先完成逾期和强制课程"); if(r.daysInactive()>14)actions.add("安排学习提醒或主管跟进"); if(r.averageScore()<70)actions.add("推荐补充材料与再次测评"); if(r.managerCheckins()==0)actions.add("增加主管学习辅导记录");
        return new Result(Math.round(completion*100)/100.0,risk,level,actions);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String learnerId,@Min(0) int assignedCourses,@Min(0) int completedCourses,@Min(0) int overdueCourses,
        @Min(0) @Max(100) int averageScore,@Min(0) int daysInactive,@Min(0) int mandatoryOpen,@Min(0) int managerCheckins){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(double completionRate,int riskScore,String riskLevel,List<String> actions){}
}

