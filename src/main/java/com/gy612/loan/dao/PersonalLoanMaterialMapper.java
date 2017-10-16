package com.gy612.loan.dao;

import com.gy612.loan.entity.PersonalLoanMaterial;
import com.gy612.loan.entity.PersonalLoanMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalLoanMaterialMapper {
    int countByExample(PersonalLoanMaterialExample example);

    int deleteByExample(PersonalLoanMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonalLoanMaterial record);

    int insertSelective(PersonalLoanMaterial record);

    List<PersonalLoanMaterial> selectByExample(PersonalLoanMaterialExample example);

    PersonalLoanMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonalLoanMaterial record, @Param("example") PersonalLoanMaterialExample example);

    int updateByExample(@Param("record") PersonalLoanMaterial record, @Param("example") PersonalLoanMaterialExample example);

    int updateByPrimaryKeySelective(PersonalLoanMaterial record);

    int updateByPrimaryKey(PersonalLoanMaterial record);
}