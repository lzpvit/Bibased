package com.lzp.app1.controller;


import com.lzp.app1.dao.History_warning;
import com.lzp.app1.dao.Message_board;
import com.lzp.app1.dao.User;
import com.lzp.app1.pojo.Status;
import com.lzp.app1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lzp.app1.pojo.Message;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by LZP on 2018/3/28.
 */
@Controller
public class BiboardController {
    @Autowired
    Status status;
    @Autowired
    BiasedService biasedService;
    @Autowired
    Message_boardService message_boardService;
    @Autowired
    UserService userService;
    @Autowired
    History_warningService history_warningService;

    @RequestMapping({"/index","/"})
    public String add(){
       return "index";
    }
    @RequestMapping({"/map"})
    public String biboard(){

        return "map";
    }

    @RequestMapping(value = {"/ajax"})
    @ResponseBody
    public Status ajax(@RequestBody Message message){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date.getTime());
        System.out.println(message.getContent());
        User user =userService.select_user(message.getEmail());
        Message_board message_board = new Message_board(message.getContent(),user.getId(),date);
//        System.out.println(message_board.getContent());
        message_boardService.message_board_insert(message_board);
        status.setMessage_board_insert(true);
        return status;
    }
    @RequestMapping(value = {"/history"})
    @ResponseBody
    public List<History_warning> history_warnings(){
        List <History_warning> list = history_warningService.select_history_warning();
        System.out.println(list.get(0).getId());
        return list;
    }
    @RequestMapping(value = {"/biboard"})
    public String bi(){
        return "biboard";
    }
    @RequestMapping(value = {"/update"})
    public void update_file(){

    }
}
