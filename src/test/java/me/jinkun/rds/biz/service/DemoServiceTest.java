package me.jinkun.rds.biz.service;

import base.BaseDaoTest;
import base.BaseServiceTest;
import com.google.gson.Gson;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.dto.Page;
import me.jinkun.rds.sys.dao.SysOrgMapper;
import me.jinkun.rds.sys.service.SysOrgService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zongguang on 2017/8/11 0011.
 */
public class DemoServiceTest extends BaseServiceTest {

    @Autowired
    private DemoService demoService;

    private final Gson gson = new Gson();

    @Test
    public void page() throws Exception {
        Page page = new Page();
        page.setPage(2);
        page.setRows(2);
        EUDataGridResult result = this.demoService.page(page);
        System.out.println(gson.toJson(result));
    }

}