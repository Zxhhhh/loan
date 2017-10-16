package com.gy612.loan.dao;

import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.PersonalLoanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalLoanInfoMapper {
    int countByExample(PersonalLoanInfoExample example);

    int deleteByExample(PersonalLoanInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonalLoanInfo record);

    int insertSelective(PersonalLoanInfo record);

    List<PersonalLoanInfo> selectByExample(PersonalLoanInfoExample example);

    PersonalLoanInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonalLoanInfo record, @Param("example") PersonalLoanInfoExample example);

    int updateByExample(@Param("record") PersonalLoanInfo record, @Param("example") PersonalLoanInfoExample example);

    int updateByPrimaryKeySelective(PersonalLoanInfo record);

    int updateByPrimaryKey(PersonalLoanInfo record);
    
    /**
     * 通过左连接删除多表(个人贷款表及资料表)
     * @param id
     * @return
     */
    int deleteByLeftJoin(String id);
    
}