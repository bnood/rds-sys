package me.jinkun.rds.biz.service.impl;

import com.sun.tracing.dtrace.Attributes;
import me.jinkun.rds.biz.dao.DemoUserMapper;
import me.jinkun.rds.biz.entity.DemoUser;
import me.jinkun.rds.biz.service.DemoService;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.dto.Page;
import me.jinkun.rds.common.dto.Result;
import me.jinkun.rds.common.utils.CheckUtil;
import me.jinkun.rds.sys.web.form.SysUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zongguang on 2017/8/9 0009.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoUserMapper demoUserMapper;

    @Override
    public Result save(DemoUser item) {
        int i;
        if (CheckUtil.isEmpty(item.getId())) {
            i = this.demoUserMapper.insertSelective(item);
        } else {
            i = this.demoUserMapper.updateByPrimaryKeySelective(item);
        }
        if (1 != i) {
            return Result.fail();
        }
        return Result.ok();
    }

    @Override
    public EUDataGridResult page(Page page) {
        List<DemoUser> demoUsers = this.demoUserMapper.selectPage(page);
        int count = this.demoUserMapper.count(page);
        return new EUDataGridResult(count, demoUsers);
    }

    @Override
    public Result<DemoUser> get(Long id) {
        DemoUser demoUser = this.demoUserMapper.selectByPrimaryKey(id);
        if (CheckUtil.isEmpty(demoUser)) {
            return Result.empty();
        }
        return Result.ok().setT(demoUser);
    }

    @Override
    public Result delete(String ids) {
        List<Long> list = this.idsToList(ids);
        int i = this.demoUserMapper.delete(list);
        if (i < 1) {
            return Result.fail();
        }
        return Result.ok();
    }

    private List<Long> idsToList(String ids) {
        String[] id = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            idList.add(Long.parseLong(id[i]));
        }
        return idList;
    }
}
