package io.renren.modules.info.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.info.entity.InfoEntity;
import io.renren.modules.info.service.InfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 信息表
 *
 * @author ZhuangSuZheng
 * @email strivezhuang@163.com
 * @date 2020-05-19 08:38:45
 */
@RestController
@RequestMapping("info/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("info:info:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = infoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("info:info:info")
    public R info(@PathVariable("id") Integer id){
		InfoEntity info = infoService.getById(id);

        return R.ok().put("info", info);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("info:info:save")
    public R save(@RequestBody InfoEntity info){

        info.setCreateTime(DateUtils.format(new Date()));
        info.setStatus("1");
        info.setViews("0");
    	System.out.println(info.toString());
		infoService.save(info);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("info:info:update")
    public R update(@RequestBody InfoEntity info){
		infoService.updateById(info);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("info:info:delete")
    public R delete(@RequestBody Integer[] ids){
		infoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
