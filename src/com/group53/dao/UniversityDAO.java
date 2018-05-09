package com.group53.dao;

import com.group53.beans.University;

import java.util.List;

public interface UniversityDAO {
    void insertUniversity(University university);
    void updateUniversityById(long university_id);
    void selectUniversityById(long university_id);
    University getUniversity();
    List<University> getAllUniversities();
}
