drop table if exists sct_schedule_task;
drop table if exists stm_schedule_task_monitor;

create table sct_schedule_task
(
  id int not null auto_increment comment '主键',
  operation varchar(1) not null comment '操作类型 1-新增 2-暂停 3-恢复',
  job_name varchar(50) not null comment '作业名称',
  cron_expression varchar(100) not null comment 'cron表达式',
  argument varchar(500) comment '参数',
  anticipate_cost_time int not null comment '预期花费时间（分钟）',
  max_anticipate_cost_time int not null comment '最大预期花费时间（分钟）',
  status varchar(1) not null comment '状态 0-未生效 1-已生效',
  remark varchar(100) comment '备注',
  create_by varchar(20) not null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time datetime comment '最后修改时间',
  primary key (id)
) engine=innodb comment '调度任务';

create table stm_schedule_task_monitor
(
  id int not null auto_increment comment '主键',
  schedule_task_id int not null comment '调度任务主键',
  job_start_time datetime not null comment '开始时间',
  job_end_time datetime comment '完成时间',
  job_anticipate_end_time datetime comment '预计完成时间',
  job_max_anticipate_end_time datetime comment '最大预计完成时间',
  status varchar(1) not null comment '状态',
  remark text comment '备注',
  create_by varchar(20) not null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_update_by varchar(20) comment '最后修改人',
  last_update_time datetime comment '最后修改时间',
  primary key (id)
) engine=innodb comment '调度任务监控';

delete from sct_schedule_task;
insert into sct_schedule_task
(operation, job_name, cron_expression, argument, anticipate_cost_time, max_anticipate_cost_time, status, remark, create_by, create_time)
values('1', 'sampleTask', '0 * * * *  ?', null, 1, 5, '0', null, 'admin', current_date);