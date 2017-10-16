package com.gy612.loan.dao;

import com.gy612.loan.entity.TypeAdminrole;
import com.gy612.loan.entity.TypeAdminroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeAdminroleMapper {
    int countByExample(TypeAdminroleExample example);

    int deleteByExample(TypeAdminroleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TypeAdminrole record);

    int insertSelective(TypeAdminrole record);

    List<TypeAdminrole> selectByExample(TypeAdminroleExample example);

    TypeAdminrole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TypeAdminrole record, @Param("example") TypeAdminroleExample example);

    int updateByExample(@Param("record") TypeAdminrole record, @Param("example") TypeAdminroleExample example);

    int updateByPrimaryKeySelective(TypeAdminrole record);

    int updateByPrimaryKey(TypeAdminrole record);
}