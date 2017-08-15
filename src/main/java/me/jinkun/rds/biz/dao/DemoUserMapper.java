package me.jinkun.rds.biz.dao;

import me.jinkun.rds.biz.entity.DemoUser;
import me.jinkun.rds.common.dto.Page;

import java.util.List;

public interface DemoUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    DemoUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);

    List<DemoUser> selectPage(Page page);

    int count(Page page);

    int delete(List<Long> list);
}