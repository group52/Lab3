package com.group53.beans;

public class StudyLoad extends Entity {

    public static final byte studyload_entity_type = 8;

    private Long groupId;
    private Long tutorId;

    public StudyLoad() {
    }

    public StudyLoad(Long id, String title, Long subjectId) {
        super(id, title, subjectId, studyload_entity_type);
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public static byte getStudyload_entity_type() {
        return studyload_entity_type;
    }
}
