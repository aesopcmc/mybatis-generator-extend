package cn.aesop.example.generator.model;

import java.util.Date;
import lombok.*;

/**
 * 任务流程变动记录表
 * `transition_change_record`
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class TransitionChangeRecord {
    /**
     * 自增Id
     * id
     */
    private Long id;

    /**
     * 项目Id
     * issue_id
     */
    private Long issueId;

    /**
     * 创建人
     * create_user
     */
    private Integer createUser;

    /**
     * 创建时间
     * create_time
     */
    private Date createTime;

    /**
     * 修改人
     * update_user
     */
    private Integer updateUser;

    /**
     * 更新时间
     * update_time
     */
    private Date updateTime;

    /**
     * 群组id
     * group_id
     */
    private Integer groupId;

    /**
     * 流程流转记录，操作类型: 通过0，通过并提交表单1，驳回2，终止3
     * operate_type
     */
    private Byte operateType;

    /**
     * 从状态名称
     * from_status_name
     */
    private String fromStatusName;

    /**
     * 到状态名称
     * to_status_name
     */
    private String toStatusName;

    /**
     * 数据
     * data
     */
    private String data;

    /**
     * 表单页面元素（表单html字符串）
     * form_elements
     */
    private String formElements;
}