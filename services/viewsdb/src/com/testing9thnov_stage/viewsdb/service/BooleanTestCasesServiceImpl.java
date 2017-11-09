/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.viewsdb.BooleanTestCases;


/**
 * ServiceImpl object for domain model class BooleanTestCases.
 *
 * @see BooleanTestCases
 */
@Service("viewsdb.BooleanTestCasesService")
@Validated
public class BooleanTestCasesServiceImpl implements BooleanTestCasesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanTestCasesServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.BooleanTestCasesDao")
    private WMGenericDao<BooleanTestCases, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BooleanTestCases, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public BooleanTestCases create(BooleanTestCases booleanTestCases) {
        LOGGER.debug("Creating a new BooleanTestCases with information: {}", booleanTestCases);
        BooleanTestCases booleanTestCasesCreated = this.wmGenericDao.create(booleanTestCases);
        return booleanTestCasesCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCases getById(Integer booleantestcasesId) throws EntityNotFoundException {
        LOGGER.debug("Finding BooleanTestCases by id: {}", booleantestcasesId);
        BooleanTestCases booleanTestCases = this.wmGenericDao.findById(booleantestcasesId);
        if (booleanTestCases == null){
            LOGGER.debug("No BooleanTestCases found with id: {}", booleantestcasesId);
            throw new EntityNotFoundException(String.valueOf(booleantestcasesId));
        }
        return booleanTestCases;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCases findById(Integer booleantestcasesId) {
        LOGGER.debug("Finding BooleanTestCases by id: {}", booleantestcasesId);
        return this.wmGenericDao.findById(booleantestcasesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCases update(BooleanTestCases booleanTestCases) throws EntityNotFoundException {
        LOGGER.debug("Updating BooleanTestCases with information: {}", booleanTestCases);
        this.wmGenericDao.update(booleanTestCases);

        Integer booleantestcasesId = booleanTestCases.getBooleanId();

        return this.wmGenericDao.findById(booleantestcasesId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCases delete(Integer booleantestcasesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting BooleanTestCases with id: {}", booleantestcasesId);
        BooleanTestCases deleted = this.wmGenericDao.findById(booleantestcasesId);
        if (deleted == null) {
            LOGGER.debug("No BooleanTestCases found with id: {}", booleantestcasesId);
            throw new EntityNotFoundException(String.valueOf(booleantestcasesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<BooleanTestCases> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BooleanTestCases");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<BooleanTestCases> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BooleanTestCases");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table BooleanTestCases to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

