package cn.aesop.example.generator.model;

import cn.aesop.example.AbstractEntity;
import cn.aesop.example.enums.DeleteFlagEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 管理员表
 * admin_user
 * 
 * @author Mybatis Generator
 */
@Data
public class AdminUser extends AbstractEntity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     * id
     */
    private Integer id;

    /**
     * 昵称
     * nickname
     */
    private String nickname;

    /**
     * 登录名
     * username
     */
    private String username;

    /**
     * 密码
     * password
     */
    private String password;

    /**
     * 用户头像
     * avatar
     */
    private String avatar;

    /**
     * 角色id
     * role_id
     */
    private Integer roleId;

    /**
     * 最后登录时间
     * last_time
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lastTime;

    /**
     * 手机
     * mobile
     */
    private String mobile;

    /**
     * 登录次数
     * login_times
     */
    private Integer loginTimes;

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
    private DeleteFlagEnum deleteFlag;
}