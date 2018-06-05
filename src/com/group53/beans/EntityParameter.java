package com.group53.beans;


import java.beans.Transient;
import java.sql.Date;

public class EntityParameter {

    private Long parameterId;
    private Long entityId;
    private String stringValue;
    private int intValue;
    private double decimalValue;
    private Long idValue;
    private Date dateValue;

    private String dateString;

    public EntityParameter() {
    }

     public EntityParameter(Long parameterId, Long entityId, String stringValue, int intValue, double decimalValue, Long idValue, Date dateValue) {
        this.parameterId = parameterId;
        this.entityId = entityId;
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.decimalValue = decimalValue;
        this.idValue = idValue;
        this.dateValue = dateValue;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public double getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(double decimalValue) {
        this.decimalValue = decimalValue;
    }

    public Long getIdValue() {
        return idValue;
    }

    public void setIdValue(Long idValue) {
        this.idValue = idValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
