package com.example.springboot20200107.mapper;

import com.example.springboot20200107.pojo.Enshrine;
import com.example.springboot20200107.pojo.EnshrineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EnshrineMapper {
    long countByExample(EnshrineExample example);

    int deleteByExample(EnshrineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Enshrine record);

    int insertSelective(Enshrine record);

    List<Enshrine> selectByExample(EnshrineExample example);

    Enshrine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Enshrine record, @Param("example") EnshrineExample example);

    int updateByExample(@Param("record") Enshrine record, @Param("example") EnshrineExample example);

    int updateByPrimaryKeySelective(Enshrine record);

    int updateByPrimaryKey(Enshrine record);
}