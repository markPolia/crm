package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.ContactsActivityRelation;
import java.util.List;

public interface ContactsActivityRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ContactsActivityRelation row);

    ContactsActivityRelation selectByPrimaryKey(String id);

    List<ContactsActivityRelation> selectAll();

    int updateByPrimaryKey(ContactsActivityRelation row);
}