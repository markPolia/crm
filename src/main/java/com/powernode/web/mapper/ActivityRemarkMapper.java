package com.powernode.web.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityRemarkMapper {
    long selectCountByActivityIds(@Param("aids") List<String> aids);

    long deleteByActivityIds(@Param("aids") List<String> aids);
}