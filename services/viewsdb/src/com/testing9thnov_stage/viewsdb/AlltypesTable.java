/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AlltypesTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`alltypes table`")
public class AlltypesTable implements Serializable {

    private Integer id;
    private Integer intCol;
    private Short shortCol;
    private BigDecimal doubleCol;
    private Long bigintCol;
    private BigDecimal bigdecCol;
    private String stringCol;
    private String charCol;
    private String clobCol;
    private Date dateCol;
    private Time timeCol;
    @Type(type = "DateTime")
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private Boolean booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    private Time timeWithoutTimezone;
    private Double floatCol;
    private Long longCol;
    private BigDecimal numericCol;
    private Short byteCol;
    private String textCol;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"alltypes table_Id column_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`Id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`Int col`", nullable = true, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`Short col`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`Double col`", nullable = true, scale = 17, precision = 17)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`Bigint Col`", nullable = true, scale = 0, precision = 19)
    public Long getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(Long bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Column(name = "`Bigdec col`", nullable = true, scale = 18, precision = 32)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    @Column(name = "`String Col`", nullable = true, length = 37)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`Char col`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`Clob col`", nullable = true, length = 2456789)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Column(name = "`Date Col`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`Time col`", nullable = true)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`Datetime col`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`Timestamp col`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`Boolean col`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`Blob col`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @Column(name = "`Time without timezone`", nullable = true)
    public Time getTimeWithoutTimezone() {
        return this.timeWithoutTimezone;
    }

    public void setTimeWithoutTimezone(Time timeWithoutTimezone) {
        this.timeWithoutTimezone = timeWithoutTimezone;
    }

    @Column(name = "`Float col`", nullable = true, scale = 4, precision = 9)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`Long col`", nullable = true, scale = 0, precision = 19)
    public Long getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Long longCol) {
        this.longCol = longCol;
    }

    @Column(name = "`Numeric col`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getNumericCol() {
        return this.numericCol;
    }

    public void setNumericCol(BigDecimal numericCol) {
        this.numericCol = numericCol;
    }

    @Column(name = "`Byte Col`", nullable = true, scale = 0, precision = 5)
    public Short getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Short byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`Text Col`", nullable = true, length = 2059)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlltypesTable)) return false;
        final AlltypesTable alltypesTable = (AlltypesTable) o;
        return Objects.equals(getId(), alltypesTable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

