package com.group53.dao;

import com.group53.beans.Group;

import java.util.List;

public interface GroupDAO {

    void insertGroup(Group group);
    void updateGroupById(long group_id);
    void selectGroupById(long group_id);
    Group getGroup();
    List<Group> getAllGroups();
}
