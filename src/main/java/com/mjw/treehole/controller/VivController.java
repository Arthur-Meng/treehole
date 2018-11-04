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
import java.util.List;
import java.util.Map;
import java.util.Random;

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

	public static Random random = new Random();
	@Autowired
	MsgMapper msgMapper;

	/**
	 * 记录消息
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveMsg(@RequestBody Map msg) {
		log.info(msg);
		// 保存到数据库
		Msg vivMsg = new Msg(OtherUtil.getDate(), msg.get("message").toString());
		msgMapper.saveMsg(vivMsg);
		// 发送邮件
		try {
			EmailUtils.sendHtmlMail("903019946@qq.com", "树洞", " Viv说：" + vivMsg.getMsg());
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
	 * 获取快乐
	 */
	@RequestMapping(value = "/happy", method = RequestMethod.GET)
	@ResponseBody
	public String getHappy() {
		List<String> meansList = msgMapper.getExpress("happy");
		return meansList.get(random.nextInt(meansList.size()));
	}

	/**
	 * 获取忧虑
	 */
	@RequestMapping(value = "/worry", method = RequestMethod.GET)
	@ResponseBody
	public String getWorry() {
		List<String> meansList = msgMapper.getExpress("worry");
		return meansList.get(random.nextInt(meansList.size()));
	}

	/**
	 * 获取难过
	 */
	@RequestMapping(value = "/sad", method = RequestMethod.GET)
	@ResponseBody
	public String getSad() {
		List<String> meansList = msgMapper.getExpress("sad");
		return meansList.get(random.nextInt(meansList.size()));
	}

	/**
	 * 获取生气
	 */
	@RequestMapping(value = "/angry", method = RequestMethod.GET)
	@ResponseBody
	public String getAngry() {
		List<String> meansList = msgMapper.getExpress("angry");
		return meansList.get(random.nextInt(meansList.size()));
	}

}
