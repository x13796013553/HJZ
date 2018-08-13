package com.xxx.webservice.dao;

import java.util.List;
import java.util.Map;

import com.xxx.webservice.pojo.XMessage;
import com.xxx.webservice.pojo.XMessageExample;
import org.apache.ibatis.annotations.Param;

public interface XMessageMapper {
    int countByExample(XMessageExample example);

    int deleteByExample(XMessageExample example);

    int deleteByPrimaryKey(Integer msgId);

    int insert(XMessage record);

    int insertSelective(XMessage record);

    List<XMessage> selectByExample(XMessageExample example);

    XMessage selectByPrimaryKey(Integer msgId);

    int updateByExampleSelective(@Param("record") XMessage record, @Param("example") XMessageExample example);

    int updateByExample(@Param("record") XMessage record, @Param("example") XMessageExample example);

    int updateByPrimaryKeySelective(XMessage record);

    int updateByPrimaryKey(XMessage record);

    // 分页获取消息
    List<XMessage> selectMsgPageList(Map map);
}