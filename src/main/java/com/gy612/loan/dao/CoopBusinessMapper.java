package com.gy612.loan.dao;

import com.gy612.loan.entity.CoopBusiness;
import com.gy612.loan.entity.CoopBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoopBusinessMapper {
    int countByExample(CoopBusinessExample example);

    int deleteByExample(CoopBusinessExample example);

    int deleteByPrimaryKey(String id);

    int insert(CoopBusiness record);

    int insertSelective(CoopBusiness record);

    List<CoopBusiness> selectByExample(CoopBusinessExample example);

    CoopBusiness selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CoopBusiness record, @Param("example") CoopBusinessExample example);

    int updateByExample(@Param("record") CoopBusiness record, @Param("example") CoopBusinessExample example);

    int updateByPrimaryKeySelective(CoopBusiness record);

    int updateByPrimaryKey(CoopBusiness record);
}