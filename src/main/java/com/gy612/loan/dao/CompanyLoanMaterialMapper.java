package com.gy612.loan.dao;

import com.gy612.loan.entity.CompanyLoanMaterial;
import com.gy612.loan.entity.CompanyLoanMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyLoanMaterialMapper {
    int countByExample(CompanyLoanMaterialExample example);

    int deleteByExample(CompanyLoanMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyLoanMaterial record);

    int insertSelective(CompanyLoanMaterial record);

    List<CompanyLoanMaterial> selectByExample(CompanyLoanMaterialExample example);

    CompanyLoanMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyLoanMaterial record, @Param("example") CompanyLoanMaterialExample example);

    int updateByExample(@Param("record") CompanyLoanMaterial record, @Param("example") CompanyLoanMaterialExample example);

    int updateByPrimaryKeySelective(CompanyLoanMaterial record);

    int updateByPrimaryKey(CompanyLoanMaterial record);
}