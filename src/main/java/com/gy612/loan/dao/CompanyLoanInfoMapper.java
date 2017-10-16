package com.gy612.loan.dao;

import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.CompanyLoanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyLoanInfoMapper {
    int countByExample(CompanyLoanInfoExample example);

    int deleteByExample(CompanyLoanInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyLoanInfo record);

    int insertSelective(CompanyLoanInfo record);

    List<CompanyLoanInfo> selectByExample(CompanyLoanInfoExample example);

    CompanyLoanInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyLoanInfo record, @Param("example") CompanyLoanInfoExample example);

    int updateByExample(@Param("record") CompanyLoanInfo record, @Param("example") CompanyLoanInfoExample example);

    int updateByPrimaryKeySelective(CompanyLoanInfo record);

    int updateByPrimaryKey(CompanyLoanInfo record);
    
    int deleteByLeftJoin(@Param("id")String id);
    
}