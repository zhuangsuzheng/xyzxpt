package io.renren.modules.info.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.info.entity.InfoEntity;

import java.util.Map;

/**
 * 信息表
 *
 * @author ZhuangSuZheng
 * @email strivezhuang@163.com
 * @date 2020-05-19 08:38:45
 */
public interface InfoService extends IService<InfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

