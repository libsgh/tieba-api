# tieba-api
[![language](https://img.shields.io/badge/language-java-blue.svg)](https://www.java.com)
[![version](https://img.shields.io/badge/version-v0.0.8-orange.svg)](https://mvnrepository.com/artifact/com.github.libsgh/tieba-api/0.0.8)
[![GitHub license](https://img.shields.io/github/license/libsgh/tieba-api.svg)](https://github.com/libsgh/tieba-api/blob/master/LICENSE)


封装了百度贴吧的基本操作，登录，签到，回帖等
## 使用说明
maven
```
<dependency>
    <groupId>com.github.libsgh</groupId>
    <artifactId>tieba-api</artifactId>
    <version>${lastVersion}</version>
</dependency>
```
Gradle
```
implementation 'com.github.libsgh:tieba-api:0.0.8'
```
SBT
```
libraryDependencies += "com.github.libsgh" % "tieba-api" % "0.0.8"
```
直接引用jar,在[tieba-api](http://mvnrepository.com/artifact/com.github.libsgh/tieba-api/)或[releases](https://github.com/libsgh/tieba-api/releases)下载最新版
```
 TieBaApi api = TieBaApi.getInstance();
 api.reply(bduss, "5635882244", "bug", "#bug吧#回帖接口测试", 0);//回帖
 api.getIndexTList("bug",1);//获取首页帖子数组
 api.oneBtnToSign(bduss, stoken);//一键签到
 api.signOneTieBa("姜敏京", 282280, bduss);//签到一个贴吧
 api.getHideTbs(username);//获取用户所有贴吧(隐藏贴吧)
 api.getMyLikedTB(bduss, stoken);//获取我喜欢的贴吧
 api.getUserInfo(bduss, stoken);//获取用户信息
 api.getHeadImg(username);//获取用户头像
 api.zhiDaoSign(bduss);//知道签到
 api.wenKuSign(bduss);//文库签到
 api.getMsg(bduss, "reply", 1);//查看回复我或艾特我的信息
 api.replyFloor(bduss, "tid", "fname", "···", 0 , "pid");//楼中楼回复
 List<ReplyInfo> list = api.getMsg(bduss, "reply", 1);
 for (ReplyInfo replyInfo : list) {
	api.floorpid(bduss, replyInfo.getThread_id(), replyInfo.getPost_id());//获取楼层pid
 }
 //用户名密码登录获取cookie
 api.getBaiDuLoginCookie(account, password, verifyCode, codeString, cookies, token);
 api.focus(bduss, "bug");//关注一个贴吧
 api.unfocus(bduss, "bug");//取消关注一个贴吧
 api.getQRCodeUrl();//获取登录二维码
 api.getFollowList(bduss);//获取关注的用户列表
 api.getFansList(bduss);//获取粉丝列表
 api.removeFans(bduss,fans_uid);//移除粉丝
 api.islogin(bduss);//检测bduss有效性
 api.getCookieFromQRCode(v);//二维码登录获取cookie(bduss,stoken)
 api.jubao(bduss, "123649521597","10004");//举报帖子
```
基于api实现的贴吧签到系统 [贴吧签到云](https://sign.iicm.tk)
