package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.MenuMapper;
import com.laycoding.cms.pojo.Menu;
import com.laycoding.cms.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
   @Resource
   private MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    @Override
    public List<Menu> getMenu() {
        return menuMapper.getMenu();
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }
}
