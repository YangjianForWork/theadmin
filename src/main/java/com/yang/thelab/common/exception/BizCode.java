package com.yang.thelab.common.exception;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: BizCode.java, v 0.1 2015年12月27日 下午6:27:56 dev Exp $
 */
public enum BizCode implements EnumInterface {

	/** 系统异常 */
	SYS_EXCE("SYS_EXCE", "系统异常", "系统异常"),

	/** 参数校验异常 */
	PARAM_CHECK("PARAM_CHECK", "参数校验异常", "参数校验异常"),

	/** 存在正在处理的业务 */
	ALREADY_PROCESSING("ALREADY_PROCESSING", "存在正在处理的业务", "存在正在处理的业务"),

	// =======设备报修=======

	/** 该设备不存在 */
	EQUIPMENT_NOT_EXISIT("EQUIPMENT_NOT_EXISIT", "该设备不存在"),

	/** 设备报修编号不能为空 */
	EXT_NO_NOT_BLANK("EXT_NO_NOT_BLANK", "设备报修编号不能为空"),
	/** 设备已经报修 */
	ALREADY_FAULT_REPORT("ALREADY_FAULT_REPORT", "设备已报修"),

	/** 不存在报修信息 */
	NOT_EXISIT_FAULT_REPORT("NOT_EXISIT_FAULT_REPORT", "不存在报修信息"),

	/** 状态校验失败 */
	FAULT_REPORT_STATUS_VALI_FAIL("FAULT_REPORT_STATUS_VALI_FAIL", "状态校验失败"),
	/** 方案已经存在 */
	ALREADY_MAINT_SCHEME("ALREADY_MAINT_SCHEME", "方案已经存在"),

	/** 方案未准备好 */
	NOT_EXISIT_MAINT_SCHEME("NOT_EXISIT_MAINT_SCHEME", "方案未准备好"),

	/** 找到不到匹配的工程师 */
	NOT_MATCHED_ENGINEER("NOT_MATCHED_ENGINEER", "找到不到匹配的工程师"),

	// =======注册登录=======
	/** 未登录 */
	NOT_LOGIN("NOT_LOGIN", "未登录", "未登录"),
	/** 找不到用户 */
	CUST_NOT_FOUND("CUST_NOT_FOUND", "找不到用户", "找不到用户"),
	/** 请登陆 */
	LOGIN_TOKEN_IS_EMPTY("LOGIN_TOKEN_IS_EMPTY", "请登陆", "请登陆"),
	/** 请登陆 */
	LOGIN_DATA_EXCE("LOGIN_DATA_EXCE", "token失效", "token失效"),
	/** 找不到用户 */
	MOBILE_NOT_REF_DEPA("MOBILE_NOT_REF_DEPA", "用户不存在", "用户不存在"),
	/** 密码错误 */
	PASSWORD_FAIL("PASSWORD_FAIL", "密码错误", "密码错误"),
	/** 密码格式有误 */
	PASSWORD_WRONG_FROMAT("PASSWORD_WRONG_FROMAT", "密码格式有误", "密码格式有误"),
	/** 无权限 */
	MISS_PERMISSION("MISS_PERMISSION", "无权限访问", "无权限访问"),
	/** 验证码错误 */
	CODE_FAIL("CODE_FAIL", "验证码错误", "验证码错误"),
	/** 未获取验证码 */
	CODE_NOT_FOUND("CODE_NOT_FOUND", "请先获取验证码", "请先获取验证码"),
	/** 验证码失效 */
	CODE_LOSE_EFFICACY("CODE_LOSE_EFFICACY", "验证码失效", "验证码失效"),
	/** 邀请码失效 */
	INVITE_CODE_USED("INVITE_CODE_USED", "邀请码失效", "邀请码失效"),
	/** 邀请码不存在 */
	INVITE_CODE_NOT_FOUND("INVITE_CODE_NOT_FOUND", "邀请码不存在", "邀请码不存在"),
	/** 无邀请码 */
	NO_INVITE_CODE("NO_INVITE_CODE", "无邀请码", "无邀请码"),
	/** 用户已经存在无法注册 */
	CANT_GET_CODE("CANT_GET_CODE", "用户已经存在无法注册", "用户已经存在无法注册"),
	/** 该用户不是工程师 */
	NOT_AS_ENGINEER("NOT_A_ENGINEER", "该用户还未认证为工程师", "该用户还未认证为工程师"),
	// =======链接映射=======
	/** 长链接无法映射到短链接 */
	URL_MAP_REPEAT("URL_MAP_REPEAT", "长链接无法映射到短链接", "长链接无法映射到短链接"),
	// ======生厂商&品牌=====
	/** 厂商名称已经存在 */
	EQUI_MANU_NAME_EXISIT("EQUI_MANU_NAME_EXISIT", "该厂商名称已经存在", "该厂商名称已经存在"),
	/** 该品牌已经存在 */
	BRAND_NAME_EXISIT("BRAND_NAME_EXISIT", "该品牌已经存在"),

	/** 产品定义不能修改 */
	PROD_DEF_CANT_MODIFY("PROD_DEF_CANT_MODIFY", "产品定义不能修改", "产品定义不能修改"),

	/** 该品牌下没有产品 */
	NO_PRODUCT_IN_BRAND("NO_PRODUCT_IN_BRAND", "该品牌下没有产品"),

	// ======属性维护========
	/** 产品线名称已经存在 */
	PROD_LINE_CONTENT_EXISIT("PROD_LINE_CONTENT_EXISIT", "该产品线名称已经存在"),
	/** 机构类别名称已经存在 */
	ORG_TYPE_CONTENT_EXISIT("ORG_TYPE_CONTENT_EXISIT", "该机构类别已经存在"),
	/** 该产品定义的属性已经存在 */
	ATTR_CONTENT_EXISIT("ATTR_CONTENT_EXISIT", "该产品定义的属性已经存在"),
	/** 你的属性值忘记输入了 */
	ATTR_CONTENT_BLANK("ATTR_CONTENT_BLANK", "你的枚举属性值忘记输入了"),

	// =======产品=========
	/** 该产品已经存在 */
	PRODUCT_EXISIT("PRODUCT_EXISIT", "该产品已经存在"),
	/** 该产品定义已经存在 */
	PROD_DEF_NAME_EXISIT("PROD_DEF_NAME_EXISIT", "该产品定义已经存在"),
	/** 未找到产品 */
	PRODUCT_NO_FIND("PRODUCT_NO_FIND", "未找到产品"),
	/** 产品版本信息未找到 */
	PROD_VERS_NO_FIND("PROD_VERS_NO_FIND", "产品版本信息未找到"),
	/** 获取产品关联的属性值失败 */
	ATTR_USE_OBTAIN_FAIL("ATTR_USE_OBTAIN_FAIL", "获取产品关联的属性值失败"),
	/** 该产品已经存在该版本 */
	PROD_VERS_VERSION_EXISIT("PROD_VERS_VERSION_EXISIT", "该产品已经存在该版本"),

	// =======设备=========
	/** 设备序列号已经被使用 */
	EQUIPMENT_SERIAL_NO_USED("EQUIPMENT_SERIAL_NO_USED", "该设备序列号已经被使用"),
	/** 该设备维修ID已经被使用 */
	EQUIPMENT_EXT_NO_USED("EQUIPMENT_EXT_NO_USED", "该设备维修ID已经被使用"),

	// =======顾客=========
	/** 该手机号码已经被使用 */
	CUSTOMER_MOBILE_EXISIT("CUSTOMER_MOBILE_EXISIT", "该手机号码已经被使用"),
	/** 请输入正确的手机号 */
	CUSTOMER_MOBILE_NO_ILLEGAL("CUSTOMER_ILLEGAL_MOBILE_NO", "请输入正确的手机号"),

	// ======机构&部门======
	/** 该机构已经存在 */
	MEDI_INST_NAME_EXISIT("MEDI_INST_NAME_EXISIT", "该机构已经存在"),
	/** 该机构下已经存在该部门 */
	MEDI_INST_DEPA_NAME_EXISIT("MEDI_INST_DEPA_NAME_EXISIT", "该机构下已经存在该部门"),

	// ======机构&部门======
	/** 短信发送失败 */
	SMS_SEND_FAIL("SMS_SEND_FAIL", "短信发送失败"),

	// ======联系人=======
	/** 该联系人已存在某个机构 */
	PERS_OF_MI_EXIST("PERS_OF_MI_EXIST", "该联系人已存在某个机构"),
	/** 该部门联系人已经存在某个机构 */
	PERS_OF_MIDEPA_EXIST("PERS_OF_MIDEPA_EXIST", "该部门联系人已经存在某个机构"),
	/** 该联系人不属于任何机构 */
	PERS_NOT_OF_MI("PERS_NOT_OF_MI", "您没有权限登录", "您没有权限登录"),

	/** 时间格式错误 */
	DATE_FORMAT_FAIL("DATE_FORMAT_FAIL", "时间格式错误", "时间格式错误"),
	/** 文件不存在 */
	FILE_NOT_FOUND("FILE_NOT_FOUND", "文件不存在"), 
	;
	private String code;

	private String desc;

	private String defaultMsg;

	private String[] defMsg;

	private BizCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private BizCode(String code, String desc, String defaultMsg,
			String... defMsg) {
		this.code = code;
		this.desc = desc;
		this.defaultMsg = defaultMsg;
		this.defMsg = defMsg;
	}

	public String code() {
		return code;
	}

	public String desc() {
		return desc;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	public String[] getDefMsg() {
		return defMsg;
	}
}
