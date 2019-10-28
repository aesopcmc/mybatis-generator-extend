package cn.aesop.example.generator.model;

import cn.aesop.example.enums.ModelNameEnum;
import java.util.Date;
import lombok.*;

/**
 * 测试实例
 * `demo_test`
 * 
 * @author Mybatis Generator
 * @date 2019-10-26
 */
@Getter
@Setter
public class DemoTest {
    /**
     * 自增Id
     * id
     */
    private Long id;

    /**
     * 
     * name
     */
    private String name;

    /**
     * 默认流程模板ID
     * workflow_scheme_id
     */
    private Long workflowSchemeId;

    /**
     * 状态
     * able_status
     */
    private Byte ableStatus;

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
     * 模型类型枚举
     * model_name
     */
    private ModelNameEnum modelName;

    /**
     * 备注
     * remark
     */
    private String remark;

    /**
     * ffff
     * summary
     */
    private String summary;
}