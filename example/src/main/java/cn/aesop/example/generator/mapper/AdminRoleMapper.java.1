package cn.aesop.example.generator.mapper;

import static cn.aesop.example.generator.mapper.AdminRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.aesop.example.generator.model.AdminRole;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
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
public interface AdminRoleMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, roleName, createUser, createTime, updateUser, updateTime, deleteFlag);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AdminRole> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AdminRole> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AdminRoleResult")
    Optional<AdminRole> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AdminRoleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_flag", property="deleteFlag", jdbcType=JdbcType.TINYINT)
    })
    List<AdminRole> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, adminRole, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, adminRole, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(AdminRole record) {
        return MyBatis3Utils.insert(this::insert, record, adminRole, c ->
            c.map(id).toProperty("id")
            .map(roleName).toProperty("roleName")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(deleteFlag).toProperty("deleteFlag")
        );
    }

    default int insertMultiple(Collection<AdminRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, adminRole, c ->
            c.map(id).toProperty("id")
            .map(roleName).toProperty("roleName")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(deleteFlag).toProperty("deleteFlag")
        );
    }

    default int insertSelective(AdminRole record) {
        return MyBatis3Utils.insert(this::insert, record, adminRole, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", record::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(deleteFlag).toPropertyWhenPresent("deleteFlag", record::getDeleteFlag)
        );
    }

    default Optional<AdminRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, adminRole, completer);
    }

    default List<AdminRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, adminRole, completer);
    }

    default List<AdminRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, adminRole, completer);
    }

    default Optional<AdminRole> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, adminRole, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(AdminRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(roleName).equalTo(record::getRoleName)
                .set(createUser).equalTo(record::getCreateUser)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUser).equalTo(record::getUpdateUser)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(deleteFlag).equalTo(record::getDeleteFlag);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(AdminRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(roleName).equalToWhenPresent(record::getRoleName)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUser).equalToWhenPresent(record::getUpdateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(deleteFlag).equalToWhenPresent(record::getDeleteFlag);
    }

    default int updateByPrimaryKey(AdminRole record) {
        return update(c ->
            c.set(roleName).equalTo(record::getRoleName)
            .set(createUser).equalTo(record::getCreateUser)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateUser).equalTo(record::getUpdateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(deleteFlag).equalTo(record::getDeleteFlag)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(AdminRole record) {
        return update(c ->
            c.set(roleName).equalToWhenPresent(record::getRoleName)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateUser).equalToWhenPresent(record::getUpdateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(deleteFlag).equalToWhenPresent(record::getDeleteFlag)
            .where(id, isEqualTo(record::getId))
        );
    }
}