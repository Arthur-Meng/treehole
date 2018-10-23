package com.mjw.treehole.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.mjw.treehole.bean.Msg;

public interface MsgMapper {

	@Insert("insert into MSG (date,msg)values(#{msg.date},#{msg.msg})")
	public void saveMsg(@Param("msg")Msg msg);

}
