package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.ContactsRemark;
import java.util.List;

public interface ContactsRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ContactsRemark row);

    ContactsRemark selectByPrimaryKey(String id);

    List<ContactsRemark> selectAll();

    int updateByPrimaryKey(ContactsRemark row);
}