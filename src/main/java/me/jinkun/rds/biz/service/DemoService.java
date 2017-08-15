package me.jinkun.rds.biz.service;

import me.jinkun.rds.biz.entity.DemoUser;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.dto.Page;
import me.jinkun.rds.common.dto.Result;
import me.jinkun.rds.sys.web.form.SysUserForm;

/**
 * Created by zongguang on 2017/8/9 0009.
 */
public interface DemoService {

    Result save(DemoUser item);

    EUDataGridResult page(Page page);

    Result<DemoUser> get(Long id);

    Result delete(String ids);
}
