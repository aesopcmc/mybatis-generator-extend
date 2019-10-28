package cn.aesop.example.generator.mapper;

import cn.aesop.example.generator.model.DemoTest;
import cn.aesop.example.generator.model.DemoTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoTestMapper {
    long countByExample(DemoTestExample example);

    int deleteByExample(DemoTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DemoTest record);

    int insertSelective(DemoTest record);

    List<DemoTest> selectByExampleWithBLOBs(DemoTestExample example);

    List<DemoTest> selectByExample(DemoTestExample example);

    DemoTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DemoTest record, @Param("example") DemoTestExample example);

    int updateByExampleWithBLOBs(@Param("record") DemoTest record, @Param("example") DemoTestExample example);

    int updateByExample(@Param("record") DemoTest record, @Param("example") DemoTestExample example);

    int updateByPrimaryKeySelective(DemoTest record);

    int updateByPrimaryKeyWithBLOBs(DemoTest record);

    int updateByPrimaryKey(DemoTest record);
}