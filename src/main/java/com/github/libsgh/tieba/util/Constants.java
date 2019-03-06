package com.github.libsgh.tieba.util;

/**
 * 百度贴吧一些常用url常量
 * @author libs
 * 2018-4-8
 */
public class Constants {
	
	public static final String BAIDU_URL = "https://www.baidu.com";//百度首页
	public static final String TOKEN_GET_URL = "https://passport.baidu.com/v2/api/?getapi&tpl=mn&apiver=v3&class=login&logintype=dialogLogin";//登陆token
	public static final String LOGIN_POST_URL = "https://passport.baidu.com/v2/api/?login";//登陆 post url
	public static final String PUB_KEY_URL = "https://passport.baidu.com/v2/getpublickey?token=%s&tpl=tb&apiver=v3&tt=%s&gid=&loginversion=v4&traceid=";//获取RSA公钥
	public static final String TIEBA_GET_URL = "https://tieba.baidu.com";//贴吧地址
	public static final String TBS_URL = "http://tieba.baidu.com/dc/common/tbs";//tbs 获取随机参数（好多请求用到）
	public static final String USER_INFO_GET_URL = "http://tieba.baidu.com/f/user/json_userinfo";//获取用户json信息
	public static final String WENKU_SIGN_URL = "https://wenku.baidu.com/task/submit/signin";
	
	public static final String MY_LIKE_URL = "http://tieba.baidu.com/f/like/mylike";//我喜欢的贴吧 url
	public static final String SIGN_POST_URL = "http://c.tieba.baidu.com/c/c/forum/sign";//签到 post url
	public static final String CAPTCHA_IMG = "https://passport.baidu.com/cgi-bin/genimage";//验证码图片地址
	public static final String REPLY_POST_URL  = "http://c.tieba.baidu.com/c/c/post/add";//贴吧回帖post url
	public static final String DEL_POST_URL  = "http://c.tieba.baidu.com/c/c/bawu/delthread";//删帖post url
	public static final String BAWU_POST_URL  = "http://c.tieba.baidu.com/c/u/bawu/listreason";//获取封禁列表
	public static final String PRISION_POST_URL  = "http://c.tieba.baidu.com/c/c/bawu/commitprison";//封禁用户
	public static final String INFO_GET_URL  = "https://www.baidu.com/p";//百度个人资料（获取贴吧头像）
	public static final String HEAD_GET_URL  = "http://himg.bdimg.com/sys/portrait/item";//（获取贴吧头像地址）
	public static final String BAIDUTIME_GET_URL  = "http://open.baidu.com/special/time/";//获取百度服务器时间
	public static final String TULING_POST_URL  = "http://www.tuling123.com/openapi/api";//图灵api
	public static final String TBAT_POST_URL  = "http://c.tieba.baidu.com/c/u/feed/";//贴吧@、回复
	public static final String FLOOR_POST_URL  = "http://c.tieba.baidu.com/c/f/pb/floor";//楼层
	public static final String ZHHIDAO_POST_URL  = "https://zhidao.baidu.com/submit/user";//百度知道签到
	public static final String ZHHIDAO_HOME_URL  = "https://zhidao.baidu.com/";//百度知道首页
	public static final String ZHHIDAO_API_POST_URL  = "http://zhidao.baidu.com/submit/user";//百度知道签到
	public static final String PASSPORT_AUTH_URL  = "https://passport.baidu.com/v3/login/api/auth/?tpl=tb&jump=&return_type=3&u=https%3A%2F%2Ftieba.baidu.com%2Findex.html";//授权url
	public static final String NEW_HEAD_URL  = "http://tieba.baidu.com/home/main?un=";//用户首页
	public static final String USER_PROFILE = "http://c.tieba.baidu.com/c/u/user/profile";//贴吧用户信息查询
	public static final String FOLLOW = "http://c.tieba.baidu.com/c/c/user/follow";//关注某人
	public static final String UNFOLLOW = "http://c.tieba.baidu.com/c/c/user/unfollow";//取消关注某人
	public static final String F_PAGE = "http://c.tieba.baidu.com/c/f/pb/page";//帖子信息
	public static final String TIEBA_URL = "https://tieba.baidu.com/f?kw=%s&ie=utf-8";//某个贴吧url
	public static final String SEARCH_FRIEND = "http://c.tieba.baidu.com/c/r/friend/searchFriend";//获取用户信息
	public static final String GET_USER_TIEBA = "http://c.tieba.baidu.com/c/f/forum/like";//获取用户关注的贴吧
	public static final String LIKE_TIEBA_URL = "http://c.tieba.baidu.com/c/c/forum/like";//关注一个贴吧
	public static final String UNFAVO_TIEBA_URL = "http://c.tieba.baidu.com/c/c/forum/unfavo";//取消关注一个贴吧
	public static final String TIEBA_FID = "http://tieba.baidu.com/f/commit/share/fnameShareApi?ie=utf-8&fname=";//获取贴吧fid
	public static final String FLOR_PID = "http://c.tieba.baidu.com/c/f/pb/floor";//获取楼层pid
	public static final String GET_QRCODE_SIGN = "https://passport.baidu.com/v2/api/getqrcode";//获取登录二维码sign
	public static final String GET_QRCODE_IMG = "https://passport.baidu.com/v2/api/qrcode?sign=%s&uaonly=&client_id=&lp=pc&client=&traceid=";//获取登录二维码图片
	public static final String GET_FOLLOW_LIST = "http://c.tieba.baidu.com/c/u/follow/followList";//获取关注列表
	public static final String GET_FANS_LIST = "http://c.tieba.baidu.com/c/u/fans/page";//获取粉丝列表
	public static final String REMOVE_FANS = "http://c.tieba.baidu.com/c/c/user/removeFans";//移除粉丝
	public static final String TOOUSU_CHECK = "http://tieba.baidu.com/complaint/checkjubao?&category=1&pid=%s";//1. 举报提交
	public static final String TOOUSU_SUBMIT = "http://help.baidu.com/tousu/submit";//2. 举报提交
	public static final String ZHIDAO_USER_CENTER = "https://zhidao.baidu.com/usercenter?uid=%s";//知道用户中心，用于查询完整用户名
	public static final String LEBO_API = "http://leboapi.baidu.com/leboapi/user?type=getUserDetail&uid=8889&apiver=2&from=leboios&terminal=ios&app=121&did=fce78749b15e3c2e5ec415a6e79f4000ba141da9&channel=AppStore&clientver=21609&sysver=9.0.2";//BDUSS查询用户信息
	public static final String GET_USER_PROFILE = "http://ce.baidu.com/site/getUserProfile";//BDUSS查询用户名和头像
}
