package cn.aesop.example.generator.mapper;

import static cn.aesop.example.generator.mapper.AdminUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.aesop.example.generator.model.AdminUser;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface AdminUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, nickname, username, password, avatar, roleId, lastTime, mobile, loginTimes, createUser, createTime, updateUser, updateTime, deleteFlag);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<AdminUser> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AdminUserResult")
    Optional<AdminUser> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AdminUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_times", property="loginTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_flag", property="deleteFlag", jdbcType=JdbcType.TINYINT)
    })
    List<AdminUser> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, adminUser, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, adminUser, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(AdminUser record) {
        return MyBatis3Utils.insert(this::insert, record, adminUser, c ->
            c.map(nickname).toProperty("nickname")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(avatar).toProperty("avatar")
            .map(roleId).toProperty("roleId")
            .map(lastTime).toProperty("lastTime")
            .map(mobile).toProperty("mobile")
            .map(loginTimes).toProperty("loginTimes")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(deleteFlag).toProperty("deleteFlag")
        );
    }

    default int insertSelective(AdminUser record) {
        return MyBatis3Utils.insert(this::insert, record, adminUser, c ->
            c.map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(lastTime).toPropertyWhenPresent("lastTime", record::getLastTime)
            .map(mobile).toPropertyWhenPresent("mobile", record::getMobile)
            .map(loginTimes).toPropertyWhenPresent("loginTimes", record::getLoginTimes)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", record::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(deleteFlag).toPropertyWhenPresent("deleteFlag", record::getDeleteFlag)
        );
    }

    default Optional<AdminUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, adminUser, completer);
    }

    default List<AdminUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, adminUser, completer);
    }

    default List<AdminUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, adminUser, completer);
    }

    default Optional<AdminUser> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, adminUser, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(AdminUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalTo(record::getNickname)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(avatar).equalTo(record::getAvatar)
                .set(roleId).equalTo(record::getRoleId)
                .set(lastTime).equalTo(record::getLastTime)
                .set(mobile).equalTo(record::getMobile)
                .set(loginTimes).equalTo(record::getLoginTimes)
                .set(createUser).equalTo(record::getCreateUser)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUser).equalTo(record::getUpdateUser)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(deleteFlag).equalTo(record::getDeleteFlag);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(AdminUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalToWhenPresent(record::getNickname)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(lastTime).equalToWhenPresent(record::getLastTime)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(loginTimes).equalToWhenPresent(record::getLoginTimes)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUser).equalToWhenPresent(record::getUpdateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(deleteFlag).equalToWhenPresent(record::getDeleteFlag);
    }

    default int updateByPrimaryKey(AdminUser record) {
        return update(c ->
            c.set(nickname).equalTo(record::getNickname)
            .set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(avatar).equalTo(record::getAvatar)
            .set(roleId).equalTo(record::getRoleId)
            .set(lastTime).equalTo(record::getLastTime)
            .set(mobile).equalTo(record::getMobile)
            .set(loginTimes).equalTo(record::getLoginTimes)
            .set(createUser).equalTo(record::getCreateUser)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateUser).equalTo(record::getUpdateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(deleteFlag).equalTo(record::getDeleteFlag)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(AdminUser record) {
        return update(c ->
            c.set(nickname).equalToWhenPresent(record::getNickname)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(roleId).equalToWhenPresent(record::getRoleId)
            .set(lastTime).equalToWhenPresent(record::getLastTime)
            .set(mobile).equalToWhenPresent(record::getMobile)
            .set(loginTimes).equalToWhenPresent(record::getLoginTimes)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateUser).equalToWhenPresent(record::getUpdateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(deleteFlag).equalToWhenPresent(record::getDeleteFlag)
            .where(id, isEqualTo(record::getId))
        );
    }
}