package com.gy612.loan.dao;

import com.gy612.loan.entity.BorrowMaterial;
import com.gy612.loan.entity.BorrowMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowMaterialMapper {
    int countByExample(BorrowMaterialExample example);

    int deleteByExample(BorrowMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(BorrowMaterial record);

    int insertSelective(BorrowMaterial record);

    List<BorrowMaterial> selectByExample(BorrowMaterialExample example);

    BorrowMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BorrowMaterial record, @Param("example") BorrowMaterialExample example);

    int updateByExample(@Param("record") BorrowMaterial record, @Param("example") BorrowMaterialExample example);

    int updateByPrimaryKeySelective(BorrowMaterial record);

    int updateByPrimaryKey(BorrowMaterial record);
}