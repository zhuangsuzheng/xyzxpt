package io.renren.modules.info.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 信息表
 * 
 * @author ZhuangSuZheng
 * @email strivezhuang@163.com
 * @date 2020-05-19 08:38:45
 */
@Data
@TableName("info")
public class InfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 信息类型 1 失物招领，2 学院通知，3 表白墙
	 */
	private String type;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String views;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String describe;
	/**
	 * 
	 */
	private String status;

}
