# 企业级合规培训认证

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 LMS 开源版增加合规认证门禁。

`POST /api/enterprise/lms/compliance-certification-gate` 汇总课程完成度、考试成绩、身份核验、实操考核、制度签收和证书有效期，返回 `CERTIFIED / RENEWAL_DUE / BLOCKED`。

企业应用可将证书同步至岗位资质、现场准入或排班系统；签发、撤销、复训和续证过程应保留完整审计日志。
