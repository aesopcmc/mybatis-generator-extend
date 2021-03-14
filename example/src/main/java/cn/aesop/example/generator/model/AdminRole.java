package cn.aesop.example.generator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 后台角色表
 * admin_role
 * 
 * @author Mybatis Generator
 */
@Data
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    /**
     * 是否删除 1是 0否
     * delete_flag
     */
    private Byte deleteFlag;
}