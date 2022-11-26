package com.powernode.web.settings.service.impl;

import com.powernode.web.settings.mapper.DicTypeMapper;
import com.powernode.web.settings.mapper.DicValueMapper;
import com.powernode.web.settings.service.DicService;
import jakarta.annotation.Resource;

public class DicServiceImpl implements DicService {
    @Resource(type = DicTypeMapper.class)
    private DicTypeMapper dicTypeMapper;
    @Resource(type = DicValueMapper.class)
    private DicValueMapper dicValueMapper;
}
