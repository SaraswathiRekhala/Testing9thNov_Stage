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

import com.testing9thnov_stage.viewsdb.ClobTable;


/**
 * ServiceImpl object for domain model class ClobTable.
 *
 * @see ClobTable
 */
@Service("viewsdb.ClobTableService")
@Validated
public class ClobTableServiceImpl implements ClobTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClobTableServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.ClobTableDao")
    private WMGenericDao<ClobTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ClobTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public ClobTable create(ClobTable clobTable) {
        LOGGER.debug("Creating a new ClobTable with information: {}", clobTable);
        ClobTable clobTableCreated = this.wmGenericDao.create(clobTable);
        return clobTableCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public ClobTable getById(Integer clobtableId) throws EntityNotFoundException {
        LOGGER.debug("Finding ClobTable by id: {}", clobtableId);
        ClobTable clobTable = this.wmGenericDao.findById(clobtableId);
        if (clobTable == null){
            LOGGER.debug("No ClobTable found with id: {}", clobtableId);
            throw new EntityNotFoundException(String.valueOf(clobtableId));
        }
        return clobTable;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public ClobTable findById(Integer clobtableId) {
        LOGGER.debug("Finding ClobTable by id: {}", clobtableId);
        return this.wmGenericDao.findById(clobtableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public ClobTable update(ClobTable clobTable) throws EntityNotFoundException {
        LOGGER.debug("Updating ClobTable with information: {}", clobTable);
        this.wmGenericDao.update(clobTable);

        Integer clobtableId = clobTable.getId();

        return this.wmGenericDao.findById(clobtableId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public ClobTable delete(Integer clobtableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ClobTable with id: {}", clobtableId);
        ClobTable deleted = this.wmGenericDao.findById(clobtableId);
        if (deleted == null) {
            LOGGER.debug("No ClobTable found with id: {}", clobtableId);
            throw new EntityNotFoundException(String.valueOf(clobtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<ClobTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ClobTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<ClobTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ClobTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table ClobTable to {} format", exportType);
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

