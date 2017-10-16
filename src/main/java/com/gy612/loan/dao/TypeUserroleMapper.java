package com.gy612.loan.dao;

import com.gy612.loan.entity.TypeUserrole;
import com.gy612.loan.entity.TypeUserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeUserroleMapper {
    int countByExample(TypeUserroleExample example);

    int deleteByExample(TypeUserroleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TypeUserrole record);

    int insertSelective(TypeUserrole record);

    List<TypeUserrole> selectByExample(TypeUserroleExample example);

    TypeUserrole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TypeUserrole record, @Param("example") TypeUserroleExample example);

    int updateByExample(@Param("record") TypeUserrole record, @Param("example") TypeUserroleExample example);

    int updateByPrimaryKeySelective(TypeUserrole record);

    int updateByPrimaryKey(TypeUserrole record);
}