/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing9thnov_stage.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.salesdb.Reps;
import com.testing9thnov_stage.salesdb.models.query.*;

@Service
public class SalesdbQueryExecutorServiceImpl implements SalesdbQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesdbQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("salesdbWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<SvRepsOrderByResponse> executeSV_RepsOrderBy(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("SV_RepsOrderBy", params, SvRepsOrderByResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Downloadable exportSV_RepsOrderBy(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("SV_RepsOrderBy", params, exportType, SvRepsOrderByResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<HqlCustomreps1Response> executeHQL_CUSTOMREPS1(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("HQL_CUSTOMREPS1", params, HqlCustomreps1Response.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Downloadable exportHQL_CUSTOMREPS1(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("HQL_CUSTOMREPS1", params, exportType, HqlCustomreps1Response.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<SvCustomrepsResponse> executeSV_CUSTOMREPS(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("SV_CUSTOMREPS", params, SvCustomrepsResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Downloadable exportSV_CUSTOMREPS(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("SV_CUSTOMREPS", params, exportType, SvCustomrepsResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Reps> executeHQL_INOperator(List<Integer> channelType, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("channelType", channelType);

        return queryExecutor.executeNamedQuery("HQL_INOperator", params, Reps.class, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Downloadable exportHQL_INOperator(ExportType exportType, List<Integer> channelType, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("channelType", channelType);

        return queryExecutor.exportNamedQueryData("HQL_INOperator", params, exportType, Reps.class, pageable);
    }

}

