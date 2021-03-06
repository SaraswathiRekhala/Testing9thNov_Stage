/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Numberviews1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Numberviews1`")
@IdClass(Numberviews1Id.class)
public class Numberviews1 implements Serializable {

    private Integer id;
    private Short integerCol;
    private Short shortCol;
    private Integer longCol;
    private Integer bigintegerCol;
    private BigDecimal byteCol;
    private Short floatCol;
    private BigDecimal doubleCol;

    @Id
    @Column(name = "`id`", nullable = true, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "`integer col`", nullable = true, scale = 0, precision = 4)
    public Short getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Short integerCol) {
        this.integerCol = integerCol;
    }

    @Id
    @Column(name = "`short col`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Id
    @Column(name = "`long col`", nullable = true, scale = 0, precision = 8)
    public Integer getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Integer longCol) {
        this.longCol = longCol;
    }

    @Id
    @Column(name = "`biginteger col`", nullable = true, scale = 0, precision = 8)
    public Integer getBigintegerCol() {
        return this.bigintegerCol;
    }

    public void setBigintegerCol(Integer bigintegerCol) {
        this.bigintegerCol = bigintegerCol;
    }

    @Id
    @Column(name = "`byte col`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(BigDecimal byteCol) {
        this.byteCol = byteCol;
    }

    @Id
    @Column(name = "`float col`", nullable = true, scale = 0, precision = 4)
    public Short getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Short floatCol) {
        this.floatCol = floatCol;
    }

    @Id
    @Column(name = "`double col`", nullable = true, scale = 17, precision = 17)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numberviews1)) return false;
        final Numberviews1 numberviews1 = (Numberviews1) o;
        return Objects.equals(getId(), numberviews1.getId()) &&
                Objects.equals(getIntegerCol(), numberviews1.getIntegerCol()) &&
                Objects.equals(getShortCol(), numberviews1.getShortCol()) &&
                Objects.equals(getLongCol(), numberviews1.getLongCol()) &&
                Objects.equals(getBigintegerCol(), numberviews1.getBigintegerCol()) &&
                Objects.equals(getByteCol(), numberviews1.getByteCol()) &&
                Objects.equals(getFloatCol(), numberviews1.getFloatCol()) &&
                Objects.equals(getDoubleCol(), numberviews1.getDoubleCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getIntegerCol(),
                getShortCol(),
                getLongCol(),
                getBigintegerCol(),
                getByteCol(),
                getFloatCol(),
                getDoubleCol());
    }
}

