package cn.aesop.example.generator.model;

import java.util.Date;
import lombok.*;

/**
 * 群组表
 * `group`
 * 
 * @author Mybatis Generator
 * @date 2019-10-26
 */
@Getter
@Setter
public class Group {
    /**
     * 自增Id
     * id
     */
    private Integer id;

    /**
     * 群组名称，对公司而言就是公司名
     * name
     */
    private String name;

    /**
     * 群组描述
     * desc
     */
    private String desc;

    /**
     * 唯一群组id
     * uuid
     */
    private String uuid;

    /**
     * personal=个人群组，company=公司，department=公司部门
     * type
     */
    private String type;

    /**
     * 公司统一信用代码或执照号码，只有公司才有，格式为：91 8888 8888 8888 ABCD，什么字母都有可能，数字和字母混编
     * company_license
     */
    private String companyLicense;

    /**
     * 该群组所属最高的群组id，比如公司都属于id为3的company下
     * root_id
     */
    private Integer rootId;

    /**
     * 该群组所属父级群组id
     * parent_id
     */
    private Integer parentId;

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
     * 修改时间
     * update_time
     */
    private Date updateTime;

    /**
     * 是否是默认的 0否 1默认
     * default_flag
     */
    private Byte defaultFlag;
}