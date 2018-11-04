package com.mjw.treehole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mjw.treehole.bean.Msg;

public interface MsgMapper {

	@Insert("insert into MSG (date,msg)values(#{msg.date},#{msg.msg})")
	public void saveMsg(@Param("msg") Msg msg);

	@Select("select mean from express where type=#{type}")
	public List<String> getExpress(@Param("type") String type);

}
