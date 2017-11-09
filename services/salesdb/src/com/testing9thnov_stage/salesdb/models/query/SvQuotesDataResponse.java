/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.salesdb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvQuotesDataResponse implements Serializable {


    @ColumnAlias("ID")
    private BigInteger id;

    @ColumnAlias("LEAD_ID")
    private BigInteger leadId;

    @ColumnAlias("ENTRY_DATE")
    private Date entryDate;

    @ColumnAlias("REP_ID")
    private BigInteger repId;

    @ColumnAlias("ESTIMATED_SALE")
    private BigInteger estimatedSale;

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getLeadId() {
        return this.leadId;
    }

    public void setLeadId(BigInteger leadId) {
        this.leadId = leadId;
    }

    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigInteger getRepId() {
        return this.repId;
    }

    public void setRepId(BigInteger repId) {
        this.repId = repId;
    }

    public BigInteger getEstimatedSale() {
        return this.estimatedSale;
    }

    public void setEstimatedSale(BigInteger estimatedSale) {
        this.estimatedSale = estimatedSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvQuotesDataResponse)) return false;
        final SvQuotesDataResponse svQuotesDataResponse = (SvQuotesDataResponse) o;
        return Objects.equals(getId(), svQuotesDataResponse.getId()) &&
                Objects.equals(getLeadId(), svQuotesDataResponse.getLeadId()) &&
                Objects.equals(getEntryDate(), svQuotesDataResponse.getEntryDate()) &&
                Objects.equals(getRepId(), svQuotesDataResponse.getRepId()) &&
                Objects.equals(getEstimatedSale(), svQuotesDataResponse.getEstimatedSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getLeadId(),
                getEntryDate(),
                getRepId(),
                getEstimatedSale());
    }
}
