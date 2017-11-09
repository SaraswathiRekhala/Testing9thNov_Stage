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
 * Testnumbertypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`testnumbertypes`")
@IdClass(TestnumbertypesId.class)
public class Testnumbertypes implements Serializable {

    private BigDecimal deccol;
    private BigDecimal numericcol;
    private BigDecimal floatcol;
    private Double realcol;
    private BigDecimal doupcol;

    @Id
    @Column(name = "`deccol`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getDeccol() {
        return this.deccol;
    }

    public void setDeccol(BigDecimal deccol) {
        this.deccol = deccol;
    }

    @Id
    @Column(name = "`numericcol`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getNumericcol() {
        return this.numericcol;
    }

    public void setNumericcol(BigDecimal numericcol) {
        this.numericcol = numericcol;
    }

    @Id
    @Column(name = "`floatcol`", nullable = true, scale = 17, precision = 17)
    public BigDecimal getFloatcol() {
        return this.floatcol;
    }

    public void setFloatcol(BigDecimal floatcol) {
        this.floatcol = floatcol;
    }

    @Id
    @Column(name = "`realcol`", nullable = true, scale = 8, precision = 8)
    public Double getRealcol() {
        return this.realcol;
    }

    public void setRealcol(Double realcol) {
        this.realcol = realcol;
    }

    @Id
    @Column(name = "`doupcol`", nullable = true, scale = 17, precision = 17)
    public BigDecimal getDoupcol() {
        return this.doupcol;
    }

    public void setDoupcol(BigDecimal doupcol) {
        this.doupcol = doupcol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testnumbertypes)) return false;
        final Testnumbertypes testnumbertypes = (Testnumbertypes) o;
        return Objects.equals(getDeccol(), testnumbertypes.getDeccol()) &&
                Objects.equals(getNumericcol(), testnumbertypes.getNumericcol()) &&
                Objects.equals(getFloatcol(), testnumbertypes.getFloatcol()) &&
                Objects.equals(getRealcol(), testnumbertypes.getRealcol()) &&
                Objects.equals(getDoupcol(), testnumbertypes.getDoupcol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeccol(),
                getNumericcol(),
                getFloatcol(),
                getRealcol(),
                getDoupcol());
    }
}

