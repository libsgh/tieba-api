# tieba-api
[![language](https://img.shields.io/badge/language-java-blue.svg)](https://www.java.com)
[![version](https://img.shields.io/badge/version-v1.0.9-orange.svg)](https://mvnrepository.com/artifact/com.github.libsgh/tieba-api/1.0.9)
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
implementation 'com.github.libsgh:tieba-api:${lastVersion}'
```
SBT
```
libraryDependencies += "com.github.libsgh" % "tieba-api" % "${lastVersion}"
```
直接引用jar,在[tieba-api](http://mvnrepository.com/artifact/com.github.libsgh/tieba-api/)或[releases](https://github.com/libsgh/tieba-api/releases)下载最新版
```
 TieBaApi api = TieBaApi.getInstance();
 api.uploadPicture(new File(""), bduss, api.getImgTbs(), "fid", false, WatermarkType.NO_WATERMARK);//上传图片，返回图片id（用于回帖）
 api.reply(bduss, "5635882244", "bug", "#bug吧#回帖接口测试", 0);//回帖
 api.getIndexTList("bug",1);//获取首页帖子数组
 api.oneBtnToSign(bduss, stoken);//一键签到
 api.oneBtnToSign(bduss);//一键签到
 api.signOneTieBa("姜敏京", 282280, bduss);//签到一个贴吧
 api.getHideTbs(username);//获取用户所有贴吧(隐藏贴吧)
 api.getMyLikedTB(bduss, stoken);//获取我喜欢的贴吧
 api.getUserInfo(bduss, stoken);//获取用户信息
 api.getHeadImg(username);//获取用户头像
 api.zhiDaoSign(bduss);//知道签到
 api.wenKuSign(bduss);//文库签到
 api.getMsg(bduss, "reply", 1);//查看回复我或艾特我的信息
 api.replyFloor(bduss, "tid", "pid", "fname", "···", 0);//楼中楼回复
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
 api.isFocus("bug", bduss, stoken);//是否关注某个贴吧
 api.isFocus("bug", bduss);//是否关注某个贴吧
 //api.getFullNameByPanUrl("panUrl");//接口失效
 api.support(bduss, "柯南");//助攻名人堂
 api.prisionReasonList(bduss, "home", "uid");//获取封禁原因列表
 api.commitprison(bduss, "home", "张三", 1 ,"reason");//封禁用户
 api.focus2(bduss, stoken, api.getFid("bug"));//关注贴吧（网页接口，可以关注异常吧）
 api.unfocus2(bduss, stoken, api.getFid("bug"));//取关贴吧（网页接口，可以取关异常吧）
 api.getFid("bug");//获取贴吧fid
 api.qrCodeLoginStatus("sign", "gid");//检查扫码登录状态查询
 api.addThread(bduss, "tbName", "", "c");//上传图片
```

温馨提示：

1. **回帖接口可能导致全吧封禁，请谨慎使用**
2. **登录接口许久未更新，目前只做参考，主流方式是扫码登录获取cookie**

使用推荐：基于api实现的微信公众号：ponbous，[web站点](https://noki.top/tieba)

有问题提issue或q：359916450
