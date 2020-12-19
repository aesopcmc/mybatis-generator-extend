package cn.aesop.example.generator.model;

import java.time.LocalDateTime;
import lombok.*;

/**
 * 后台角色表
 * admin_role
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class AdminRole {
    /**
     * 
     * id
     */
    private Integer id;

    /**
     * 角色名
     * role_name
     */
    private String roleName;

    /**
     * 创建人
     * create_user
     */
    private Integer createUser;

    /**
     * 创建时间
     * create_time
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     * update_user
     */
    private Integer updateUser;

    /**
     * 修改时间
     * update_time
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 1是 0否
     * delete_flag
     */
    private Byte deleteFlag;
}