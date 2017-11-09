/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TestnumbertypesId implements Serializable {

    private BigDecimal deccol;
    private BigDecimal numericcol;
    private BigDecimal floatcol;
    private Double realcol;
    private BigDecimal doupcol;

    public BigDecimal getDeccol() {
        return this.deccol;
    }

    public void setDeccol(BigDecimal deccol) {
        this.deccol = deccol;
    }

    public BigDecimal getNumericcol() {
        return this.numericcol;
    }

    public void setNumericcol(BigDecimal numericcol) {
        this.numericcol = numericcol;
    }

    public BigDecimal getFloatcol() {
        return this.floatcol;
    }

    public void setFloatcol(BigDecimal floatcol) {
        this.floatcol = floatcol;
    }

    public Double getRealcol() {
        return this.realcol;
    }

    public void setRealcol(Double realcol) {
        this.realcol = realcol;
    }

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
