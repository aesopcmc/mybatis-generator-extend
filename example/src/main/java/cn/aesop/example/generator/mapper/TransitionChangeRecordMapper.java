package cn.aesop.example.generator.mapper;

import cn.aesop.example.generator.model.TransitionChangeRecord;
import cn.aesop.example.generator.model.TransitionChangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransitionChangeRecordMapper {
    long countByExample(TransitionChangeRecordExample example);

    int deleteByExample(TransitionChangeRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransitionChangeRecord record);

    int insertSelective(TransitionChangeRecord record);

    List<TransitionChangeRecord> selectByExampleWithBLOBs(TransitionChangeRecordExample example);

    List<TransitionChangeRecord> selectByExample(TransitionChangeRecordExample example);

    TransitionChangeRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransitionChangeRecord record, @Param("example") TransitionChangeRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") TransitionChangeRecord record, @Param("example") TransitionChangeRecordExample example);

    int updateByExample(@Param("record") TransitionChangeRecord record, @Param("example") TransitionChangeRecordExample example);

    int updateByPrimaryKeySelective(TransitionChangeRecord record);

    int updateByPrimaryKeyWithBLOBs(TransitionChangeRecord record);

    int updateByPrimaryKey(TransitionChangeRecord record);
}