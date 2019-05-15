package com.qiaoxun.dao;


import com.qiaoxun.pojo.QiswlCapter;
import com.qiaoxun.pojo.QiswlCapterWithBLOBs;

public interface QiswlCapterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QiswlCapterWithBLOBs record);

    int insertSelective(QiswlCapterWithBLOBs record);

    QiswlCapterWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiswlCapterWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QiswlCapterWithBLOBs record);

    int updateByPrimaryKey(QiswlCapter record);
}