package com.gy612.loan.dao;

import com.gy612.loan.entity.BorrowInfo;
import com.gy612.loan.entity.BorrowInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowInfoMapper {
    int countByExample(BorrowInfoExample example);

    int deleteByExample(BorrowInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BorrowInfo record);

    int insertSelective(BorrowInfo record);

    List<BorrowInfo> selectByExample(BorrowInfoExample example);

    BorrowInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);

    int updateByExample(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);

    int updateByPrimaryKeySelective(BorrowInfo record);

    int updateByPrimaryKey(BorrowInfo record);
}