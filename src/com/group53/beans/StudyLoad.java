package com.group53.beans;

public class StudyLoad extends Entity {

    private Long groupId;
    private Long subjectId;
    private Long tutorId;

    public StudyLoad(Long id, String title) {
        super(id, title, null, 8);
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
}
