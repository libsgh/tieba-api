package com.tieba.test;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.github.tieba.api.TieBaApi;
import com.github.tieba.model.ReplyInfo;

public class BaiDuApiTest {
	
	private Logger logger =LogManager.getLogger(getClass());
	
	private static String bduss = "";
	private static String stoken = "";
	private static String username = "";
	
    @BeforeClass
    public static void runOnceBeforeClass() {
        bduss = "hBazd6aWZoMVNrWk9CNG1-eHh4VFpiMjJ6WkxlWlpzLUFQUjcxOTRZOFFzNU5aSVFBQUFBJCQAAAAAAAAAAAEAAACbyIg4jKTV0sv9lUHJ7dOwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAmbFkQJmxZMF";
        stoken = "5039dcf2c61e4bdcf13a949e515c1006056d175cbe3d8394f91d20d49acbf145";
        username = "尋找她旳身影";
    }
    
	/**
	 * 获取首页帖子tid数组
	 */
	@Test
	public void reply() {
		logger.info(TieBaApi.api.reply(bduss, "5635882244", "bug", "#bug吧#回帖接口测试", 0).toString());
	}
	
	/**
	 * 获取首页帖子tid数组
	 */
	@Test
	public void getIndexTList() {
		logger.info(TieBaApi.api.getIndexTList("bug",1).toString());
		
	}
	
	/**
	 * 执行签到
	 */
	@Test
	public void oneBtnToSign() {
		Map<String, Object> msg = TieBaApi.api.oneBtnToSign(bduss, stoken);
		String result = JSONObject.toJSONString(msg);
		logger.info(result);
		
	}
	
	/**
	 * 执行签到
	 */
	@Test
	public void signDo() {
		Map<String, Object> map = TieBaApi.api.signOneTieBa("姜敏京", 282280, bduss);
		String result = JSONObject.toJSONString(map);
		logger.info(result);
		
	}
	
	/**
	 * 获取用户所有的贴吧（贴吧数多会稍慢）
	 */
	@Test
	public void getHideTbs() {
		List<Map<String, Object>> list = TieBaApi.api.getHideTbs(username);
		String result = JSONObject.toJSONString(list);
		logger.info(result);
		
	}
	
	/**
	 * 获取我喜欢的贴吧
	 */
	@Test
	public void getMyLikedTB() {
		logger.info(JSONObject.toJSONString(TieBaApi.api.getMyLikedTB(bduss, stoken)));
	}
	
	/**
	 * 获取用户信息
	 */
	@Test
	public void getUserInfo() {
		logger.info(JSONObject.toJSONString(TieBaApi.api.getUserInfo(bduss, stoken)));
	}
	
	/**
	 * 获取用户信息
	 */
	@Test
	public void getHeadImg() {
		logger.info(TieBaApi.api.getHeadImg(username));
	}
	
	/**
	 * 知道签到
	 */
	@Test
	public void zhiDaoSign() {
		logger.info(TieBaApi.api.zhiDaoSign(bduss));
	}
	
	/**
	 * 文库签到
	 */
	@Test
	public void wenKuSign() {
		logger.info(TieBaApi.api.wenKuSign(bduss));
	}
	
	/**
	 * 查看回复我或艾特我的信息
	 */
	@Test
	public void getMsg() {
		logger.info(JSONObject.toJSONString(TieBaApi.api.getMsg(bduss, "reply", 1)));
		//logger.info(JSONObject.toJSONString(TieBaApi.api.getMsg(bduss, "at", 1)));
	}
	
	/**
	 * 楼中楼回复 结合getMsg、floorpid可以实现机器人自动回复艾特
	 */
	@Test
	public void replyFloor() {
		logger.info(TieBaApi.api.replyFloor(bduss, "tid", "fname", "···", 0 , "pid").toString());
	}
	
	/**
	 * 获取楼层pid
	 */
	@Test
	public void floorpid() {
		List<ReplyInfo> list = TieBaApi.api.getMsg(bduss, "reply", 1);
		for (ReplyInfo replyInfo : list) {
			System.out.println(JSONObject.toJSONString(replyInfo));
			logger.info(TieBaApi.api.floorpid(bduss, replyInfo.getThread_id(), replyInfo.getPost_id()));
		}
	}
	
	/**
	 * 登录测试
	 */
	@Test
	public void loginTest() {
		String account = "xxx@qq.com";
		String password = "xxx.xxx";
		String verifyCode = "";//验证码
		String codeString = "";//验证码code
		String cookies = "";//登录的cookie
		String token = "";//token
		Map<String, Object> map= TieBaApi.api.getBaiDuLoginCookie(account, password, verifyCode, codeString, cookies, token);
		String result = JSONObject.toJSONString(map);
		logger.info(result);
	}
	
}
