package com.xxx.webservice.service.impl;

import com.xxx.webservice.dao.XBookMapper;
import com.xxx.webservice.pojo.XBook;
import com.xxx.webservice.service.BookService;
import com.xxx.webservice.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private XBookMapper bookMapper;

    // 新增留言反馈
    @Override
    public String addBook(XBook book) {
        try {
            book.setBookDatetime(ConvertUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
            bookMapper.addBook(book);
            return "1";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
