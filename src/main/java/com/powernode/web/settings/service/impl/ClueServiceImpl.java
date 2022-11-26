package com.powernode.web.settings.service.impl;

import com.powernode.web.settings.mapper.ClueMapper;
import com.powernode.web.settings.service.ClueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("clueService")
public class ClueServiceImpl implements ClueService {
    @Resource(type = ClueMapper.class)
    private ClueMapper clueMapper;
}
