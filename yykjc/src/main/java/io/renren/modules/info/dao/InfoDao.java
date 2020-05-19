package io.renren.modules.info.dao;

import io.renren.modules.info.entity.InfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 信息表
 * 
 * @author ZhuangSuZheng
 * @email strivezhuang@163.com
 * @date 2020-05-19 08:38:45
 */
@Mapper
public interface InfoDao extends BaseMapper<InfoEntity> {
	
}
