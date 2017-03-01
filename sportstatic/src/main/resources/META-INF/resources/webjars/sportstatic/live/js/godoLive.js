var SERVER = '';//这里需要改成您实际搭建的 PHP 后台服务地址
var accountMode = 0;//请根据您的情况自行配置
var sdkAppID    = 1400018957; //请根据您的情况自行配置，这里可以不填，分享链接会带上这个参数，页面可以从链接中获取。
var accountType = 8747; //请根据您的情况自行配置，这里可以不填，分享链接会带上这个参数，页面可以从链接中获取。
var avChatRoomId = '@#aJIPTVAEE'; //这里可以不填，分享链接会带上这个参数，页面可以从链接中获取。
if(webim.Tool.getQueryString("groupid")){
    avChatRoomId=webim.Tool.getQueryString("groupid");//用户自定义房间群id
}
var selType = webim.SESSION_TYPE.GROUP;
var selToID = avChatRoomId;//当前选中聊天id（当聊天类型为私聊时，该值为好友帐号，否则为群号）
var selSess = null;//当前聊天会话
var selSessHeadUrl = '../img/2017.jpg';//默认群组头像(选填)
var loginInfo = {
    'sdkAppID': '', //用户所属应用id
    'appIDAt3rd': '', //用户所属应用id
    'accountType': '', //用户所属应用帐号类型
    'identifier': '', //当前用户ID,必须是否字符串类
    'identifierNick': '', //当前用户昵称
    'userSig': '', //当前用户身份凭证，必须是字符串类型
    'headurl': ''//当前用户默认头像
};
var like;
var onGroupSystemNotifys = {
    //"1": onApplyJoinGroupRequestNotify, //申请加群请求（只有管理员会收到,暂不支持）
    //"2": onApplyJoinGroupAcceptNotify, //申请加群被同意（只有申请人能够收到,暂不支持）
    //"3": onApplyJoinGroupRefuseNotify, //申请加群被拒绝（只有申请人能够收到,暂不支持）
    //"4": onKickedGroupNotify, //被管理员踢出群(只有被踢者接收到,暂不支持)
    "5": onDestoryGroupNotify, //群被解散(全员接收)
    //"6": onCreateGroupNotify, //创建群(创建者接收,暂不支持)
    //"7": onInvitedJoinGroupNotify, //邀请加群(被邀请者接收,暂不支持)
    //"8": onQuitGroupNotify, //主动退群(主动退出者接收,暂不支持)
    //"9": onSetedGroupAdminNotify, //设置管理员(被设置者接收,暂不支持)
    //"10": onCanceledGroupAdminNotify, //取消管理员(被取消者接收,暂不支持)
    "11": onRevokeGroupNotify, //群已被回收(全员接收)
    "255": onCustomGroupNotify//用户自定义通知(默认全员接收)
};
var onConnNotify=function(resp){
    switch(resp.ErrorCode){
        case webim.CONNECTION_STATUS.ON:
            //webim.Log.warn('连接状态正常...');
            break;
        case webim.CONNECTION_STATUS.OFF:
            webim.Log.warn('连接已断开，无法收到新消息，请检查下你的网络是否正常');
            break;
        default:
            webim.Log.error('未知连接状态,status='+resp.ErrorCode);
            break;
    }
};

//监听事件
var listeners = {
    "onConnNotify": onConnNotify, //选填
    "jsonpCallback": jsonpCallback, //IE9(含)以下浏览器用到的jsonp回调函数,移动端可不填，pc端必填
    "onBigGroupMsgNotify": onBigGroupMsgNotify, //监听新消息(大群)事件，必填
    "onMsgNotify": onMsgNotify,//监听新消息(私聊(包括普通消息和全员推送消息)，普通群(非直播聊天室)消息)事件，必填
    "onGroupSystemNotifys": onGroupSystemNotifys, //监听（多终端同步）群系统消息事件，必填
    "onGroupInfoChangeNotify": onGroupInfoChangeNotify//监听群资料变化事件，选填
};

var isAccessFormalEnv=true;//是否访问正式环境

if(webim.Tool.getQueryString("isAccessFormalEnv")=="false"){
    isAccessFormalEnv=false;//访问测试环境
}

var isLogOn = false;//是否在浏览器控制台打印 im sdk日志
var options = {
    'isAccessFormalEnv': isAccessFormalEnv, //是否访问正式环境，默认访问正式，选填
    'isLogOn': isLogOn//是否开启控制台打印日志,默认开启，选填
};
var openEmotionFlag = false;//是否打开表情，目前小直播IM SDK暂不支持发送表情
(function () {

    var sUserAgent = navigator.userAgent.toLowerCase()
        , bIsIpad = "ipad" == sUserAgent.match(/ipad/i)
        , bIsIphoneOs = "iphone os" == sUserAgent.match(/iphone os/i)
        , bIsAndroid = "android" == sUserAgent.match(/android/i)
        , bIsPc = !bIsIpad && !bIsIphoneOs && !bIsAndroid
        , weixin = "micromessenger" == sUserAgent.match(/MicroMessenger/i)
        , qq = "QQ/" == navigator.userAgent.match(/QQ\//i)
        , weibo = "weibo" == sUserAgent.match(/WeiBo/i)
        , onClick = "ontouchend"in window ? "touchend" : "click";

    //分享的视频地址
    var renderData={}, //页面渲染所需的数据，JOSN格式
        hlsUrl = '',
        flvUrl = '';
    function initParams(){
        sdkAppID = getParams("sdkappid") || sdkAppID;
        accountType = getParams("acctype") || accountType;
        avChatRoomId = selToID = getParams("groupid") || avChatRoomId;
        hlsUrl = getParams("hls");

        var nickName = getParams("identifier"),
            type = getParams("type");
        if( /@v_tls/.test(nickName)){ //匿名ID需要自定义昵称
            nickName = prompt("输入您的昵称", "游客");
        }
        loginInfo = {
            'sdkAppID': sdkAppID, //用户所属应用id,必填
            'appIDAt3rd': sdkAppID, //用户所属应用id，必填
            'accountType': accountType, //用户所属应用帐号类型，必填
            'identifier': null, //当前用户ID,必须是否字符串类型，选填
            'identifierNick': nickName || '游客', //当前用户昵称，选填
            'userSig': null, //当前用户身份凭证，必须是字符串类型，选填
            'headurl': 'img/2016.gif'//当前用户默认头像，选填
        };
        //将account_type保存到cookie中,有效期是1天 , 在登录后tlsGetUserSig回调里会用到
        webim.Tool.setCookie('accountType', loginInfo.accountType, 3600 * 24);

        var _data = {
            Action: 'GetUserInfo',
            userid: getParams('userid'),
            type: getParams('type'),
            fileid: getParams('fileid')||''
        };

        return $.ajax({
            type: "POST",
            url: '/api/liveVideoController/liveInfo',
            data: '{"contentCode": "' + getParams('code') + '","zoo": {"key": "tesetkey","token": " "}}',
            contentType:'application/json',
            dataType: 'json'
        }).done(function (resp, textStatus, jqXHR) {
            if(resp.status == 1){
                var defPic = '../img/user-img.png'; //用户默认头像
                var data = {
                    "returnValue": resp.status,
                    "returnMsg": resp.error,
                    "returnData": {
                        "userid": resp.detail.userCode,
                        "groupid": resp.detail.chatCode,
                        "timestamp": 0,
                        "type": resp.liveType,
                        "viewercount": resp.detail.watch,
                        "likecount": resp.detail.praise,
                        "title": resp.detail.title,
                        "playurl": '',
                        "hls_play_url": resp.detail.webStreamUrl,
                        "status": resp.detail.status,
                        "fileid": "",
                        "userinfo": {
                            "nickname": resp.userBasicInfo.nickName,
                            "headpic": resp.userBasicInfo.aboutHead,
                            "frontcover": resp.detail.cover,
                            "location": "",
                            "desc": null
                        }
                    }
                }
                if(data.returnData.type == 0){
                    $('.video-pane-body').show();
                }
                $('.j-user-avatar').html('<img src="'+ (data.returnData.userinfo.headpic || defPic) +'">');
                $('.j-user-name').text(data.returnData.userinfo.nickname);
                avChatRoomId = selToID = data.returnData.groupid || avChatRoomId;
                renderData = data;
                hlsUrl = data.returnData.hls_play_url;
                flvUrl = data.returnData.hls_play_url;
                //房间成员数加1
                //$('#user-icon-fans').html( data.returnData.viewercount);
                //$('#user-icon-like').html( data.returnData.likecount);
                document.querySelector("#PlayerContainer").appendChild(initVideoCover(data));
            }else{
                alert("接口返回数据错误: " + data.returnMsg +'['+ data.returnValue +']');
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            alert("接口返回数据错误");
        });
    }
    function initSwf(url){
        var template = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="" id="FlashPlayer" width="100%" height="100%">' +
            '<param name="movie"  value="http://imgcache.qq.com/open/qcloud/video/player/release/QCPlayer.swf" />' +
            '<param name="quality" value="autohigh" />' +
            '<param name="swliveconnect" value="true" />' +
            '<param name="allowScriptAccess" value="always" />' +
            '<param name="bgcolor" value="#0" />' +
            '<param name="allowFullScreen" value="true" />' +
            '<param name="wmode" value="opaque" />' +
            '<param name="FlashVars" value="url='+url+'" />' +
            '<embed src="http://imgcache.qq.com/open/qcloud/video/player/release/QCPlayer.swf" width="100%" height="100%" name="FlashPlayer"' +
            'quality="autohigh"' +
            'bgcolor="#000000"' +
            'align="middle"' +
            'allowFullScreen="true"' +
            'allowScriptAccess="always"' +
            'type="application/x-shockwave-flash"' +
            'swliveconnect="true"' +
            'wmode="opaque"' +
            'FlashVars="url='+url+'"' +
            'pluginspage="http://www.macromedia.com/go/getflashplayer" >' +
            '</embed></object>';
        return template;
    }
    function initVideoCover(data){
        var coverURL = data.returnData.userinfo.frontcover || './img/back-img.png';

        var elem = document.createElement('div');
        var playBtn = document.createElement('div');
        elem.id = 'PlayerCover';
        elem.style.backgroundImage='url('+coverURL+')';
        elem.classList.add('cover');
        playBtn.classList.add('play-btn');
        elem.appendChild(playBtn);
        if(data.returnData.type == 1 || (data.returnData.type == 0 && data.returnData.status == 1) ){
            elem.classList.add('cover-play-btn');
        }
        return elem;
    }
    function showVideoCover(){
        document.querySelector("#PlayerCover").style.display = '';
    }
    function hideVideoCover(){
        document.querySelector("#PlayerCover").style.display = 'none';
    }
    function addSource(element, src, type){
        var source = document.createElement('source');
        source.src = src;
        source.type = type;
        element.appendChild(source);
    }

    function initPlayer(){
        var container = document.querySelector("#PlayerContainer");
        container.style.height =  (window.innerHeight || document.documentElement.clientHeight)+'px';

        if(renderData.returnData.type == 0 && renderData.returnData.status == 0){
            //直播分享且直播已结束，不需要进行视频播放
            return;
        }
        //PC平台需要Flash播放器
        if(bIsPc){
            container.innerHTML = initSwf(flvUrl);
        }else{
            //移动端播放逻辑
            var _player = document.createElement('video'),
                EventAry = 'loadstart,suspend,abort,error,emptied,stalled,loadedmetadata,loadeddata,canplay,canplaythrough,playing,waiting,seeking,seeked,ended,durationchange,timeupdate,progress,play,pause,ratechange,volumechange'.split(',');

            $.each(EventAry, function (_, event) {
                $(_player).on(event, videoEventHandler);
                //_player.addEventListener(event,videoEventHandler);
            });
            _player.id = 'player';

            if(hlsUrl && /myqcloud.com\//.test(hlsUrl)){
                addSource(_player, hlsUrl, 'application/x-mpegURL');
            }

            _player.setAttribute('preload', 'auto');
            _player.setAttribute('webkit-playsinline', 'true');
            _player.setAttribute('playsinline', 'true');
            _player.setAttribute('x-webkit-airplay', 'true');
            _player.setAttribute('x5-video-player-type', 'h5'); //在Android x5内核浏览器下开启同级模式
            _player.setAttribute('x5-video-player-fullscreen', 'true');//在Android x5内核浏览器下开启播放全屏模式

            if(getParams('type') == 1){
            }else{

            }
            container.appendChild(_player);
            if(bIsIpad || bIsIphoneOs){
                //_player.style.display = 'none';
                _player.play();
            }
        }
    }

    var isFirstTimePlay = false,
        playOnError = false;
    function videoEventHandler(event){
        var _player = document.querySelector("#player");
        if(_player && ( event.type == 'timeupdate') && !isFirstTimePlay){
            isFirstTimePlay = true;
            hideVideoCover();
            //hideLoading();
            if(bIsIpad || bIsIphoneOs){
                _player.style.height = 'auto';
                //_player.style.display = '';
            }
            if(bIsAndroid){//在android环境下需要延迟，避免页面抖动
                window.setTimeout(function () {
                    _player.style.height = 'auto';
                },500);
            }
        }
        if(_player && event.type == 'pause'){
            isFirstTimePlay = false;
            showVideoCover();
        }
        if(_player && event.type == 'error'){//在Android 微信 x5 模式下 首次播放失败没有error事件
            alert('视频加载失败，请稍后重试或刷新页面');// hls 的直播地址会有30s的延迟, 首次播放需要重试，在Android 微信 x5 模式下系统默认会重试。正式上线可以去掉这里的提示以实现静默重试
            playOnError = true;

            if(bIsIpad || bIsIphoneOs){ //ios系统手动重试
                reloadVideo();
            }
        }else{
            playOnError = false;
            if(_reloadTimer){
                window.clearTimeout(_reloadTimer);
            }
        }
        if(event.type != 'timeupdate'){

        }
    }
    var _reloadTimer;
    function reloadVideo(){
        if(_reloadTimer){
            window.clearTimeout(_reloadTimer);
        }
        _reloadTimer = window.setTimeout(function(){
            if(playOnError){//未开始播放
                loadVideo(hlsUrl);
                getVideoElem().play();
            }
        }, 3000);//3s后进行重连
    }
    function getVideoElem(){
        return document.querySelector("#player");
    }
    function loadVideo(url){
        getVideoElem().src = url;
    }

    function initLogin(){
        if(accountMode==1){//托管模式
            //判断是否已经拿到临时身份凭证
            if (webim.Tool.getQueryString('tmpsig')) {
                if (loginInfo.identifier == null) {
                    webim.Log.info('start fetchUserSig');
                    //获取正式身份凭证，成功后会回调 tlsGetUserSig(res)函数
                    TLSHelper.fetchUserSig();
                    showDiscussTool();
                }
            } else if(webim.Tool.getCookie('sdkappid') && webim.Tool.getCookie('userSig') && webim.Tool.getCookie('identifier') && webim.Tool.getCookie('accountType')) {
                //已登录模式 check cookie
                loginInfo.sdkappid = loginInfo.appIDAt3rd= webim.Tool.getCookie('sdkappid');
                loginInfo.userSig = webim.Tool.getCookie('userSig');
                loginInfo.identifier = webim.Tool.getCookie('identifier');
                loginInfo.accountType = webim.Tool.getCookie('accountType');
                sdkLogin();
                showDiscussTool();
            } else {
                //未登录, 无登录态模式, 可收消息
                //showLoginForm();
                //sdk登录
                sdkLogin();
            }
        }else{//独立模式
            //sdk登录
            sdkLogin();
            //showLoginForm();
        }
    }

    function bindEvent(info){

        $(document).on(onClick,'.j-btn-login',function(){
            tlsLogin();
        });
        $(document).on(onClick,'.j-btn-anologin',function(){
            anoLogin(loginInfo.sdkAppID);
        });
        $(document).on(onClick,'.j-btn-sms',function(event){
            smsPicClick();
            event.stopPropagation();//for switchForm()
        });
        $(document).on(onClick,'.j-btn-like',function(event){
            open();
            event.stopPropagation();
            event.preventDefault();
            //sendGroupLoveMsg();
        });
        $(document).on(onClick,'.j-btn-show-emotion',function(){
            showEmotionDialog();
        });
        $(document).on(onClick,'.j-btn-send-msg',function(){
            //onSendMsg();
        });
        $(document).on(onClick,'.video-sms-list',function(event){
            open();
            event.stopPropagation();//for switchForm()
        });
        $(document).on(onClick,'.j-btn-logout',function(){
            logout();
        });
        $(document).on(onClick,'#video-discuss-form',function(event){
            open();
            event.stopPropagation();//for switchForm()
        });
        $(document).on(onClick,'.end-info span',function(event){
            open();
             event.stopPropagation();
        });
        window.addEventListener("orientationchange", function(e) {

        });
        document.addEventListener("DOMContentLoaded", function(event) {
            var videoPage = document.querySelector('#j-video-page');
                //panel = videoPage.querySelector('.video-pane');

            videoPage.style.width =  window.innerWidth +'px';
            videoPage.style.height =  window.innerHeight +'px';
        });
        window.addEventListener("resize", function(e) {
            //alert(window.innerHeight);
            var videoPage = document.querySelector('#j-video-page'),
                //panel = videoPage.querySelector('.video-pane'),
                container = document.querySelector("#PlayerContainer");
            container.style.width = videoPage.style.width =  window.innerWidth +'px';
            container.style.height = videoPage.style.height =  window.innerHeight +'px';
        });

    }

    function bindEventAfterInitParams(data){
        if(data.returnData.type == 1 || (data.returnData.type == 0 && data.returnData.status == 1) ){
            // 点播 或者 直播中，绑定点击播放事件,避免一些浏览器不允许自动播放导致播放视频失败
            $(document).on(onClick,'.video-pane-body', function(){
                var _player = document.querySelector("#player");
                if(_player){
                    //hideVideoCover();
                    if(playOnError) {// 加载视频出现错误
                        loadVideo(hlsUrl);
                    }
                    _player.play();
                }
                //switchForm();
            });
        }
    }

    function userLike(){
        $.ajax({
            type: "POST",
            url: '/api/liveVideoController/liveMsg',
            data: '{"code": "' + renderData.returnData.groupid + '","zoo": {"key": "tesetkey","token": ""}}',
            contentType:'application/json',
            dataType: 'json',
        }).done(function(data){
            if(data.status == 1){
                var currTime = data.seconds;
                var iCurr = 600;
                var praiseConstant = data.praiseConstant
                var watchConstant = data.watchConstant
                setInterval(function(){
                    currTime = currTime+6;
                    praiseConstant = parseInt(Math.atan((currTime-120)/iCurr)*data.watchConstant);
                    watchConstant = parseInt(Math.atan((currTime-120)/iCurr)*data.praiseConstant);
                    $('#user-icon-fans').html( praiseConstant );
                    $('#user-icon-like').html( watchConstant );
                },6000);
            }
        });

    }

    /**
     * 全局初始化函数入口
     */
    function init(){
        //1.调用初始化参数，获取页面渲染所需的所有数据，并返回一个promise对象，在done 的回调中，获取到所需的数据，进行初始化页面逻辑。
        initParams().done(function (resp ) {
            var data = {
                    "returnValue": resp.status,
                    "returnMsg": resp.error,
                    "returnData": {
                        "userid": resp.detail.userCode,
                        "groupid": resp.detail.chatCode,
                        "timestamp": 0,
                        "type": resp.liveType,
                        "viewercount": resp.detail.watch,
                        "likecount": resp.detail.praise,
                        "title": resp.detail.title,
                        "playurl": '',
                        "hls_play_url": resp.detail.webStreamUrl,
                        "status": resp.detail.status,
                        "fileid": "",
                        "userinfo": {
                            "nickname": resp.userBasicInfo.nickName,
                            "headpic": resp.userBasicInfo.aboutHead,
                            "frontcover": resp.detail.cover,
                            "location": "",
                            "desc": null
                        }
                    }
                }
            if(data.returnData.type == 0 ){
                $('.video-discuss-form,.video-discuss-tool').show();
                initLogin();
                initPlayer();
                userLike();
            }else{
                $('.end-info').show();
                $('.play-btn').hide();
            }
            bindEventAfterInitParams(data);

        });
        bindEvent();
    }
    init();
})();