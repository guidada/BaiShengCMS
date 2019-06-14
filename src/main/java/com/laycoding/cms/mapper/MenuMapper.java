package com.laycoding.cms.mapper;

import com.laycoding.cms.pojo.Menu;
import java.util.List;

public interface MenuMapper {
   public List<Menu> getAllMenu();
   public List<Menu> getMenu();
   int addMenu(Menu menu);
}
