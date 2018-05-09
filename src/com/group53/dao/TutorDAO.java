package com.group53.dao;

import com.group53.beans.Tutor;

import java.util.List;

public interface TutorDAO {
    void insertTutor(Tutor tutor);
    void updateTutorById(long tutor_id);
    void selectTutorById(long tutor_id);
    Tutor getTutor();
    List<Tutor> getAllTutors();
}
