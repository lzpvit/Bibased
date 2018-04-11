package com.lzp.app1.services;

import com.lzp.app1.dao.History_warning;

import java.util.List;

/**
 * Created by LZP on 2018/4/10.
 */
public interface History_warningService {
    public void insert_history_warning(History_warning history_warning);
    public List select_history_warning();
}
