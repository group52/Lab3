package com.group53.beans;

import java.sql.Date;
import java.util.Objects;

/** class EntityParameter is the class for the parameters of the entity */
public class EntityParameter {

    private Long parameterId;
    private Long entityId;
    private String stringValue;
    private int intValue;
    private double decimalValue;
    private Long idValue;
    private Date dateValue;

    private String dateString;

    /**
     * Empty constructor
     */
    public EntityParameter() {
    }

    /**
     * Constructor
      * @param parameterId - id of the parameter
     * @param entityId - id of the entity
     * @param stringValue - string value of the parameter
     * @param intValue - int value of the parameter
     * @param decimalValue - double value of the parameter
     * @param idValue - id value of the parameter
     * @param dateValue date value of the parameter
     */
    public EntityParameter(Long parameterId, Long entityId, String stringValue, int intValue, double decimalValue, Long idValue, Date dateValue) {
        this.parameterId = parameterId;
        this.entityId = entityId;
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.decimalValue = decimalValue;
        this.idValue = idValue;
        this.dateValue = dateValue;
    }

    /**
     * Return the id of the parameter
     * @return id of the parameter
     */
    public Long getParameterId() {
        return parameterId;
    }

    /**
     * Setup the id of the parameter
     * @param parameterId id of the parameter
     */
    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    /**
     * Return the id of the entity
     * @return id of the entity
     */
    public Long getEntityId() {
        return entityId;
    }

    /**
     * Setup the id of the entity
     * @param entityId id of the entity
     */
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    /**
     * Return the string value of the parameter
     * @return string value of the parameter
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Setup the string value of the parameter
     * @param stringValue string value of the parameter
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * Return the int value of the parameter
     * @return int value of the parameter
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Setup the int value of the parameter
     * @param intValue int value of the parameter
     */
    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    /**
     * Return the double value of the parameter
     * @return double value of the parameter
     */
    public double getDecimalValue() {
        return decimalValue;
    }

    /**
     * Setup the double value of the parameter
     * @param decimalValue double value of the parameter
     */
    public void setDecimalValue(double decimalValue) {
        this.decimalValue = decimalValue;
    }

    /**
     * Return the id value of the parameter
     * @return id value of the parameter
     */
    public Long getIdValue() {
        return idValue;
    }

    /**
     * Setup the id value of the parameter
     * @param idValue id value of the parameter
     */
    public void setIdValue(Long idValue) {
        this.idValue = idValue;
    }

    /**
     * Return the date value of the parameter
     * @return date value of the parameter
     */
    public Date getDateValue() {
        return dateValue;
    }

    /**
     * Setup the date value of the parameter
     * @param dateValue date value of the parameter
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * Return the date value of the parameter
     * @return date value of the parameter
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * Setup the date value of the parameter
     * @param dateString date value of the parameter
     */
    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityParameter)) return false;
        EntityParameter that = (EntityParameter) o;
        return getIntValue() == that.getIntValue() &&
                Double.compare(that.getDecimalValue(), getDecimalValue()) == 0 &&
                Objects.equals(getParameterId(), that.getParameterId()) &&
                Objects.equals(getEntityId(), that.getEntityId()) &&
                Objects.equals(getStringValue(), that.getStringValue()) &&
                Objects.equals(getIdValue(), that.getIdValue()) &&
                Objects.equals(getDateValue(), that.getDateValue()) &&
                Objects.equals(getDateString(), that.getDateString());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getParameterId(), getEntityId(), getStringValue(), getIntValue(), getDecimalValue(), getIdValue(), getDateValue(), getDateString());
    }

    @Override
    public String toString() {
        return "EntityParameter{" +
                "parameterId=" + parameterId +
                ", entityId=" + entityId +
                ", stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", decimalValue=" + decimalValue +
                ", idValue=" + idValue +
                ", dateValue=" + dateValue +
                ", dateString='" + dateString + '\'' +
                '}';
    }
}
