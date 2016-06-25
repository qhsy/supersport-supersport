package com.uhutu.dcom.user.z.tecent.enumer;

public enum MsgTypeEnum {

	TIMTextElem, // 文本消息。

	TIMLocationElem, // 地理位置消息。

	TIMFaceElem, // 表情消息。

	TIMCustomElem, // 自定义消息，当接收方为IOS系统且应用处在后台时，此消息类型可携带除文本以外的字段到APNS。注意，一条组合消息中只能包含一个TIMCustomElem自定义消息元素。

	TIMSoundElem, // 语音消息。（服务端集成Rest API不支持发送该类消息）

	TIMImageElem, // 图像消息。（服务端集成Rest API不支持发送该类消息）

	TIMFileElem // 文件消息。（服务端集成Rest API不支持发送该类消息）

}
