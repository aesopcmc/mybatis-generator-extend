package cn.aesop.example.generator.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AdminRoleDynamicSqlSupport {
    public static final AdminRole adminRole = new AdminRole();

    /**
     * 
     * id
     */
    public static final SqlColumn<Integer> id = adminRole.id;

    /**
     * 角色名
     * role_name
     */
    public static final SqlColumn<String> roleName = adminRole.roleName;

    /**
     * 创建人
     * create_user
     */
    public static final SqlColumn<Integer> createUser = adminRole.createUser;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = adminRole.createTime;

    /**
     * 修改人
     * update_user
     */
    public static final SqlColumn<Integer> updateUser = adminRole.updateUser;

    /**
     * 修改时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = adminRole.updateTime;

    /**
     * 是否删除 1是 0否
     * delete_flag
     */
    public static final SqlColumn<Byte> deleteFlag = adminRole.deleteFlag;

    public static final class AdminRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> createUser = column("create_user", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> updateUser = column("update_user", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> deleteFlag = column("delete_flag", JDBCType.TINYINT);

        public AdminRole() {
            super("admin_role");
        }
    }
}