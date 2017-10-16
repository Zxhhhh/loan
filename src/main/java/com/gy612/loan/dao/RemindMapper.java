package com.gy612.loan.dao;

import com.gy612.loan.entity.Remind;
import com.gy612.loan.entity.RemindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemindMapper {
    int countByExample(RemindExample example);

    int deleteByExample(RemindExample example);

    int deleteByPrimaryKey(String id);

    int insert(Remind record);

    int insertSelective(Remind record);

    List<Remind> selectByExample(RemindExample example);

    Remind selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByExample(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByPrimaryKeySelective(Remind record);

    int updateByPrimaryKey(Remind record);
    
    int countByRemindState(@Param("remindState")Integer remindState,@Param("userId")String userId);
    
}