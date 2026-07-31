/* Copyright 2026 上海如静知华信息科技有限公司 */
export const domain={
 code:'LMS',systemName:'企业学习管理系统',englishName:'LEARNING MANAGEMENT SYSTEM',
 theme:{primary:'#1f746d',dark:'#19302d',accent:'#b47735'},
 workspace:'人才发展中心 / 学习中心运营',fieldWorkspace:'专业能力学院',period:'2026-08-01 · 周六',liveText:'课程数据链路正常',
 fieldContextLabel:'当前学习中心',fieldContext:'日班 · 08:30—17:30',fieldUser:'陆承',fieldRole:'学习者',adminUser:'周妍',adminRole:'学习中心主管',
 adminTitle:'学习中心运营驾驶舱',adminBreadcrumb:'学习中心运营 / 今日态势',adminSubtitle:'集中查看收样、学习、考核、课程与时限风险。',exportAction:'导出学习日报',createAction:'新建学习任务',
 chartTitle:'学习完成趋势',chartSubtitle:'当日累计完成率 / 计划目标',chartLabels:['08:30','09:30','10:30','11:30','13:30','14:30','15:30','16:30','17:30'],loadTitle:'学习中心负荷',loadSubtitle:'在检任务占可用能力',recordsTitle:'在检任务',recordsSubtitle:'按承诺时限与异常优先显示',issueTitle:'人才发展与时限风险',issueSubtitle:'需要学习中心主管处理的事项',
 recordName:'学习任务',itemName:'学员 / 项目',unitName:'学习中心',batchName:'学员批次',planName:'计划项目',doneName:'已完成',exceptionName:'异常',unitLabel:'项',
 listBreadcrumb:'学习管理 / 任务台账',listSubtitle:'统一管理收样、任务分派、学习、考核与学习记录签发。',listSummary:[['今日收样','54'],['在检任务','31'],['待考核','8'],['超时风险','2',true]],tabs:['全部','待确认','学习中','待考核','已完成'],
 fieldBreadcrumb:'学习执行 / 我的工作台',fieldTitle:'理化学习工作台',fieldSubtitle:'当前 7 项在检任务 · 2 台课程已预约 · 工程师陆承',fieldSecondary:'交接记录',reportAction:'录入结果',fieldNoticeTitle:'环境状态合规',fieldNotice:'温湿度、课程校准和标准品状态均满足学习要求',
 steps:['收样确认','学员前处理','课程学习','结果考核','学习记录签发'],documentAction:'查看学习培养路径',printAction:'打印学员标签',resourceCardTitle:'课程状态',resourceValueLabel:'当前柱压',resourceHealthLabel:'课程健康度',quickSubtitle:'学习中心高频业务入口',quickActions:[['结果录入','/shopfloor/report','原始数据与结果'],['学员流转','/shopfloor/material','交接与留样位置'],['课程预约','/shopfloor/resources','日历与使用记录'],['偏差上报','/shopfloor/andon','OOS / OOT / 环境异常']],
 reportDefaults:[3,0],reportTitle:'学习结果录入',reportSubtitle:'记录原始结果、异常数量和学习过程备注。',reportSuccess:'学习结果已保存并进入考核队列',reportPlaceholder:'填写计算依据、异常现象或重复学习说明',reportFootnote:'提交后写入原始记录并生成审计轨迹',ruleTitle:'培养路径控制要求',ruleSubtitle:'HPLC-042 · V4.3',rules:[['进样体积','10 μL'],['流速','1.0 mL/min'],['系统适用性','RSD ≤ 2.0%'],['课程校准','有效',true]],fieldTotals:[['16','已完成项目'],['1','异常结果'],['5','待考核结果'],['98.2%','数据完整率']],
 adminMenus:[['/admin','home','运营驾驶舱'],['/admin/work-orders','order','学习任务'],['/admin/samples','box','学员管理'],['/admin/schedule','calendar','排班预约'],['/admin/methods','process','培养路径与标准'],['/admin/reviews','quality','结果考核'],['/admin/resources','machine','课程设备'],['/admin/report','chart','人才发展分析']],
 fieldMenus:[['/shopfloor','home','我的工作台'],['/shopfloor/report','report','结果录入'],['/shopfloor/tasks','order','待检任务'],['/shopfloor/material','box','学员流转'],['/shopfloor/resources','machine','课程预约'],['/shopfloor/andon','risk','偏差上报',1]],
 moduleTitles:{tasks:['待检任务','查看任务优先级、学员状态与承诺时限'],material:['学员流转','跟踪接收、分样、留样与销毁全过程'],resources:['课程预约','管理课程档期、校准和使用记录'],andon:['偏差上报','登记并跟踪 OOS、OOT 与环境偏差'],samples:['学员管理','管理学员登记、标签、位置和生命周期'],schedule:['排班预约','协调人员、课程和培养路径的可用时间'],methods:['培养路径与标准','维护学习培养路径、限度和标准物质'],reviews:['结果考核','执行数据审核、学习记录批准和电子签名'],report:['人才发展分析','分析周转时间、一次通过率和偏差趋势']},
 tagline:'让每一份学习结果都有完整证据链',storyTitle:'从收样到学习记录，<br/>每个结果都可考核、可追溯。',storyText:'连接学员、培养路径、课程、人员与原始数据的学习中心数字底座。',pattern:[2,3,8,9,10,15,16,17,22,23,24,29,30,31],loginStats:[['98.2%','数据完整率'],['31','当前在检任务'],['2.6h','平均周转时间']],loginTitle:'学习中心人才发展中心',adminDemo:'任务 / 学员 / 考核',fieldDemo:'学习 / 结果 / 偏差'
}
export const records=[
 {no:'LP-260801-018',name:'项目经理能力认证',code:'GB/T 228.1',unit:'新员工学院',group:'人才发展中心',plan:24,done:16,exception:1,due:'08-02',batch:'S260801-A',status:'学习中',progress:67,priority:'加急'},
 {no:'LP-260801-021',name:'新员工入职培养',code:'HPLC-042',unit:'专业能力学院',group:'人才发展中心',plan:18,done:8,exception:0,due:'08-02',batch:'S260801-C',status:'学习中',progress:44,priority:'正常'},
 {no:'LP-260802-006',name:'信息安全年度必修',code:'ISO 4833',unit:'领导力学院',group:'研发中心',plan:12,done:0,exception:0,due:'08-04',batch:'S260802-B',status:'待确认',progress:0,priority:'正常'},
 {no:'LP-260731-015',name:'领导力训练营',code:'ICP-017',unit:'专业能力学院',group:'人才发展中心',plan:20,done:20,exception:1,due:'08-01',batch:'S260731-D',status:'已完成',progress:100,priority:'正常'},
 {no:'LP-260801-024',name:'客户成功进阶课',code:'GC-MS-011',unit:'专业能力学院',group:'人才发展中心',plan:15,done:10,exception:0,due:'08-03',batch:'S260801-E',status:'待考核',progress:67,priority:'关注'}]
export const resources=[{code:'CRS-HPLC-03',name:'项目管理实战课 03',unit:'专业能力学院',status:'运行',health:88,value:'11.8',valueUnit:'MPa',note:'培养路径 HPLC-042 · 序列 8/18'},{code:'CRS-UTM-05',name:'新员工文化课程',unit:'新员工学院',status:'运行',health:91,value:'82',valueUnit:'kN',note:'夹具校验有效至 2026-10'},{code:'CRS-INC-08',name:'信息安全课程 08',unit:'领导力学院',status:'报警',health:62,value:'36.8',valueUnit:'°C',note:'温度上限预警待确认'}]
export const reviews=[{no:'REV-260801-032',title:'拉伸试验原始数据考核',type:'结果考核',detail:'6 组数据 · 周妍',result:'通过'},{no:'REV-260801-011',title:'纯度样系统适用性考核',type:'数据审核',detail:'3 次进样 · 顾清',result:'待确认'},{no:'REV-260731-018',title:'元素分析偏差调查',type:'偏差评审',detail:'OOS-260731-02',result:'异常'}]
export const adminMetrics=[['今日收样','54','较昨日增加 8 份','blue'],['按时完成率','96.8%','目标值 ≥ 95.0%','green'],['待考核结果','8','其中 2 项加急','orange'],['偏差 / OOS','2','1 项进入调查','red']]
export const fieldMetrics=[['今日任务','7','18 个学习项目','blue'],['已完成','16','当前进度 67%','green'],['待考核','5','数据已完整提交','orange'],['课程档期','至 14:30','HPLC-03 当前序列','slate']]
export const chartActual=[8,18,29,42,49,61,72,84,91],chartTarget=[10,21,32,43,54,65,76,87,98]
export const loads=[['专业能力学院',92,'12 项在检'],['新员工学院',78,'8 项在检'],['领导力学院',71,'6 项在检'],['合规学院',56,'5 项在检']]
export const issues=[{type:'课程',title:'培养箱温度短时越限',detail:'CRS-INC-08 · 持续 7 分钟',status:'调查中'},{type:'结果',title:'铝合金 Fe 元素结果超限',detail:'OOS-260731-02 · 等待复测',status:'待判定'},{type:'时限',title:'GC-MS 队列可能影响承诺时间',detail:'预计延迟 45 分钟',status:'协调中'}]
