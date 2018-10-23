package com.mjw.treehole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjw.treehole.bean.Msg;
import com.mjw.treehole.mapper.MsgMapper;
import com.mjw.treehole.util.EmailUtils;
import com.mjw.treehole.util.OtherUtil;

import lombok.extern.log4j.Log4j;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

/**
 * 消息控制类
 *
 * @author mengjw
 *
 */
@RequestMapping("/viv")
@Controller
@Log4j
public class VivController {
	@Autowired
	MsgMapper msgMapper;

	/**
	 * 记录消息
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveMsg(@RequestParam String msg) {
		log.info(msg);
		// 保存到数据库
		Msg vivMsg = new Msg(OtherUtil.getDate(), msg);
		msgMapper.saveMsg(vivMsg);
		// 发送邮件
		try {
			EmailUtils.sendHtmlMail("903019946@qq.com", "树洞", " Viv说：" + msg);
		} catch (UnsupportedEncodingException e) {
			log.error("发送邮件编码错误", e);
			return "fail";
		} catch (MessagingException e) {
			log.error("发送邮件异常", e);
			return "fail";
		}
		return "success";
	}

	/**
	 * 获取难过
	 */
	@RequestMapping(value = "/sad", method = RequestMethod.POST)
	@ResponseBody
	public String getSad() {
		return "success";
	}
	
}
