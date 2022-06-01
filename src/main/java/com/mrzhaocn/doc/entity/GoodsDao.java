package com.mrzhaocn.doc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // 标注数据访问类
public interface GoodsDao {

    public void insert(GoodsDo goods);

    public void delete(Long id) ;

    public void update(GoodsDo goods);

    public GoodsDo selectOne(Long id) ;
}
