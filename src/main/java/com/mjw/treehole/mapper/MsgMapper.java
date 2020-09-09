package com.mjw.treehole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mjw.treehole.bean.Msg;

public interface MsgMapper {

    @Insert("insert into msg (date,msg) values (#{msg.date}, #{msg.msg})")
    void saveMsg(@Param("msg") Msg msg);

    @Select("select content from express where type=#{type}")
    List<String> getExpress(@Param("type") String type);

}
