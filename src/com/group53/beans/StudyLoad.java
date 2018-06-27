package com.group53.beans;

import java.util.Objects;

/** class StudyLoad is the class for describe connection between the subject, the tutor and the group */
public class StudyLoad extends Entity {

    public static final byte studyloadEntityType = 8;

    private Long groupId;
    private Long tutorId;

    /**
     * Empty constructor
     */
    public StudyLoad() {
    }

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity
     * @param subjectId  is id of the entity parent
     */
    public StudyLoad(Long id, String title, Long subjectId) {
        super(id, title, subjectId, studyloadEntityType);
    }

    /**
     * Return the group id
     * @return group id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * Setup the group id
     * @param groupId group id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * Return the tutor id
     * @return tutor id
     */
    public Long getTutorId() {
        return tutorId;
    }

    /**
     * Setup the tutor id
     * @param tutorId tutor id
     */
    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    /**
     * Return the studyload type
     * @return the studyload type
     */
    public static byte getStudyloadEntityType() {
        return studyloadEntityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyLoad)) return false;
        if (!super.equals(o)) return false;
        StudyLoad studyLoad = (StudyLoad) o;
        return Objects.equals(getGroupId(), studyLoad.getGroupId()) &&
                Objects.equals(getTutorId(), studyLoad.getTutorId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getGroupId(), getTutorId());
    }

    @Override
    public String toString() {
        return "StudyLoad{" +
                "groupId=" + groupId +
                ", tutorId=" + tutorId +
                '}';
    }
}
