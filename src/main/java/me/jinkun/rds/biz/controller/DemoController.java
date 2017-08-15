package me.jinkun.rds.biz.controller;

import me.jinkun.rds.biz.entity.DemoUser;
import me.jinkun.rds.biz.service.DemoService;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.dto.Page;
import me.jinkun.rds.common.dto.Result;
import me.jinkun.rds.sys.web.form.SysUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zongguang on 2017/8/9 0009.
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/demo/ui/{ui}", method = RequestMethod.GET)
    public Object ui(@PathVariable("ui") String ui) {
        return "biz/demo/demo-" + ui;
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    @ResponseBody
    public Object save(DemoUser item) {
        Result result = this.demoService.save(item);
        return result;
    }

    @RequestMapping(value = "/demo/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        Result result = this.demoService.delete(ids);
        return result;
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseBody
    public Object list(Page page) {
        EUDataGridResult result = this.demoService.page(page);
        return result;
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        Result<DemoUser> result = this.demoService.get(id);
        return result;
    }


}
