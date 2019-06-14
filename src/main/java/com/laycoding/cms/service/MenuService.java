package com.laycoding.cms.service;

import com.laycoding.cms.pojo.Menu;

import java.util.List;


public interface MenuService {
    public List<Menu> getAllMenu();
    public List<Menu> getMenu();
    int addMenu(Menu menu);
}
