package com.gy612.loan.dao;

import com.gy612.loan.entity.UserSecure;
import com.gy612.loan.entity.UserSecureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSecureMapper {
    int countByExample(UserSecureExample example);

    int deleteByExample(UserSecureExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserSecure record);

    int insertSelective(UserSecure record);

    List<UserSecure> selectByExample(UserSecureExample example);

    UserSecure selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserSecure record, @Param("example") UserSecureExample example);

    int updateByExample(@Param("record") UserSecure record, @Param("example") UserSecureExample example);

    int updateByPrimaryKeySelective(UserSecure record);

    int updateByPrimaryKey(UserSecure record);
}