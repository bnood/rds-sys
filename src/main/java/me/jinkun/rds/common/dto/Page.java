package me.jinkun.rds.common.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zongguang on 2017/8/9 0009.
 */
public class Page {

    private Integer page = 1;
    private Integer rows = 10;
    private Integer offset;
    private Map<String, Object> filter = new HashMap<>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }

    public Integer getOffset() {
        offset = (this.page - 1) * rows;
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
