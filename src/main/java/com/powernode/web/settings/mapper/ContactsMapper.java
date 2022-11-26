package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.Contacts;
import java.util.List;

public interface ContactsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contacts row);

    Contacts selectByPrimaryKey(String id);

    List<Contacts> selectAll();

    int updateByPrimaryKey(Contacts row);
}