package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.ItemsDao;
import com.wlh.ssm.domain.Items;
import com.wlh.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ItemsServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 10:58
 **/

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;
    @Override
    public List<Items> findAll() {
        return itemsDao.findAll();
    }
}
