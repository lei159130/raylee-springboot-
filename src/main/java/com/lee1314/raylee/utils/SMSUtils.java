package com.lee1314.raylee.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信工具类
 * 
 * @Title: SMSUtils
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-10-30 14:19:47
 *
 */
@Component
public class SMSUtils {

	// 百悟(主)
	// 访问接口
	private static String baiwuSendurl;
	// 帐号
	private static String baiwuCorpId;
	// 密码
	private static String baiwuCorpPwd;
	// 业务代码
	private static String baiwuCorpService;
	// 扩展号 --短信末尾号码
	private static String baiwuExt; // 1001

	// 百悟(副)
	// 帐号
	private static String vbaiwuCorpId;
	// 密码
	private static String vbaiwuCorpPwd;
	// 业务代码
	private static String vbaiwuCorpService;
	// 扩展号 --短信末尾号码
	private static String vbaiwuExt; // 1001

	// 金轮批量发送
	// 访问接口
	private static String jinlunBatchSendurl;
	// 项目名
	private static String jinlunAppName;
	// 密码
	private static String jinlunAppPwd;
	// 未知
	private static String jinlunSrcid;
	// 未知
	private static String jinlunServiceid;
	// 未知
	private static String jinlunSendtime;

	// 漫道(已欠费)
	// 访问接口
	private static String MANDAO_SEND_URL = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";
	// sn
	private static String MANDAO_SN = "SDK-WSS-010-09391";
	// 密码
	private static String MANDAO_PWD = "DFD5A3C3573B850BE0991C6C1EA5B4EC";
	// 扩展号 --短信末尾号码
	private static String MANDAO_EXT = null;
	// 定时时间
	private static String MANDAO_STIME = null;
	// 唯一标识 最长18位，只能是数字或者 字母 或者数字+字母的组合 将返回该参数
	private static String MANDAO_RRID = null;
	// 短信模版
	private static String MANDAO_MSGFMT = null;

	/**
	 * 百悟短信(主)
	 * 
	 * @param mobile     手机号
	 * @param msgContent 短信内容
	 * @return
	 */
	public static String sendBaiWuMessage(String mobile, String msgContent) {
		Map<String, String> param = new HashMap<>();
		param.put("corp_id", baiwuCorpId);
		param.put("corp_pwd", baiwuCorpPwd);
		param.put("corp_service", baiwuCorpService);
		param.put("mobile", mobile);
		param.put("msg_content", msgContent);
		param.put("corp_msg_id", null);
		param.put("ext", baiwuExt);
		return HttpRequestUtils.doPost(baiwuSendurl, param, null);
	}

	/**
	 * 百悟短信(副)
	 * 
	 * @param mobile     手机号
	 * @param msgContent 短信内容
	 * @return
	 */
	public static String sendVBaiWuMessage(String mobile, String msgContent) {
		Map<String, String> param = new HashMap<>();
		param.put("corp_id", vbaiwuCorpId);
		param.put("corp_pwd", vbaiwuCorpPwd);
		param.put("corp_service", vbaiwuCorpService);
		param.put("mobile", mobile);
		param.put("msg_content", msgContent);
		param.put("corp_msg_id", null);
		param.put("ext", vbaiwuExt);
		return HttpRequestUtils.doPost(baiwuSendurl, param, null);
	}

	/**
	 * 金轮批量短信(mobile以','逗号隔开)
	 * 
	 * @param mobile     手机号
	 * @param msgContent 短信内容
	 * @return
	 */
	public static String sendBatchJinLunMessage(String mobile, String content) {
		Map<String, String> param = new HashMap<>();
		param.put("apName", jinlunAppName);
		param.put("apPassword", jinlunAppPwd);
		param.put("calledNumber", mobile);
		param.put("content", content);
		param.put("srcId", jinlunSrcid);
		param.put("ServiceId", jinlunServiceid);
		param.put("sendTime", jinlunSendtime);
		return HttpRequestUtils.doPost(jinlunBatchSendurl, param, null);
	}

	/**
	 * 漫道 (mobile可群发,以','分隔)(已欠费)
	 * 
	 * @param mobile  手机号
	 * @param content 短信内容
	 * @return
	 */
	public static String sendMandaoMessage(String mobile, String content) {
		Map<String, String> param = new HashMap<>();
		param.put("sn", MANDAO_SN);
		param.put("pwd", MANDAO_PWD);
		param.put("mobile", mobile);
		param.put("content", content);
		param.put("ext", MANDAO_EXT);
		param.put("stime", MANDAO_STIME);
		param.put("rrid", MANDAO_RRID);
		param.put("msgfmt", MANDAO_MSGFMT);
		return HttpRequestUtils.doPost(MANDAO_SEND_URL, param, null);
	}

	public static void main(String[] args) {
		String result = sendBaiWuMessage("14786154890", "老婆辛苦了!");
		String vresult = sendVBaiWuMessage("14786154890", "老婆我爱你,整几条短信发着玩!");
		// String bresult = sendBatchJinLunMessage("15761663397,14786154890",
		// "老婆上班辛苦了!");
		System.out.println(result);
		System.out.println(vresult);
		// System.out.println(bresult);
	}

	@Value("${baiwu.sendurl}")
	public void setBaiwuSendurl(String baiwuSendurl) {
		SMSUtils.baiwuSendurl = baiwuSendurl;
	}

	@Value("${baiwu.corp.id}")
	public void setBaiwuCorpId(String baiwuCorpId) {
		SMSUtils.baiwuCorpId = baiwuCorpId;
	}

	@Value("${baiwu.corp.pwd}")
	public void setBaiwuCorpPwd(String baiwuCorpPwd) {
		SMSUtils.baiwuCorpPwd = baiwuCorpPwd;
	}

	@Value("${baiwu.corp.service}")
	public void setBaiwuCorpService(String baiwuCorpService) {
		SMSUtils.baiwuCorpService = baiwuCorpService;
	}

	@Value("${baiwu.ext}")
	public void setBaiwuExt(String baiwuExt) {
		SMSUtils.baiwuExt = baiwuExt;
	}

	@Value("${vbaiwu.corp.id}")
	public void setVbaiwuCorpId(String vbaiwuCorpId) {
		SMSUtils.vbaiwuCorpId = vbaiwuCorpId;
	}

	@Value("${vbaiwu.corp.pwd}")
	public void setVbaiwuCorpPwd(String vbaiwuCorpPwd) {
		SMSUtils.vbaiwuCorpPwd = vbaiwuCorpPwd;
	}

	@Value("${vbaiwu.corp.service}")
	public void setVbaiwuCorpService(String vbaiwuCorpService) {
		SMSUtils.vbaiwuCorpService = vbaiwuCorpService;
	}

	@Value("${vbaiwu.ext}")
	public void setVbaiwuExt(String vbaiwuExt) {
		SMSUtils.vbaiwuExt = vbaiwuExt;
	}

	@Value("${jinlun.batch.sendurl}")
	public void setJinlunBatchSendurl(String jinlunBatchSendurl) {
		SMSUtils.jinlunBatchSendurl = jinlunBatchSendurl;
	}

	@Value("${jinlun.app.name}")
	public void setJinlunAppName(String jinlunAppName) {
		SMSUtils.jinlunAppName = jinlunAppName;
	}

	@Value("${jinlun.app.pwd}")
	public void setJinlunAppPwd(String jinlunAppPwd) {
		SMSUtils.jinlunAppPwd = jinlunAppPwd;
	}

	@Value("${jinlun.srcid}")
	public void setJinlunSrcid(String jinlunSrcid) {
		SMSUtils.jinlunSrcid = jinlunSrcid;
	}

	@Value("${jinlun.serviceid}")
	public void setJinlunServiceid(String jinlunServiceid) {
		SMSUtils.jinlunServiceid = jinlunServiceid;
	}

	@Value("${jinlun.sendtime}")
	public void setJinlunSendtime(String jinlunSendtime) {
		SMSUtils.jinlunSendtime = jinlunSendtime;
	}

}
