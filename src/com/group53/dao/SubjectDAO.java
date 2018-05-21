package com.group53.dao;

import com.group53.beans.Subject;

import java.util.List;

public interface SubjectDAO {
    void insertSubject(Subject subject);
    void updateSubjectById(long subject_id, Subject subject);
    void removeSubjectById(long subject_id);
    Subject selectSubjectById(long subject_id);
    Subject selectSubjectByTitle(String title);
    List<Subject> getAllSubjects();
}
