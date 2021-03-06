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

import com.testing9thnov_stage.viewsdb.Table17;


/**
 * ServiceImpl object for domain model class Table17.
 *
 * @see Table17
 */
@Service("viewsdb.Table17Service")
@Validated
public class Table17ServiceImpl implements Table17Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table17ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table17Dao")
    private WMGenericDao<Table17, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table17, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table17 create(Table17 table17) {
        LOGGER.debug("Creating a new Table17 with information: {}", table17);
        Table17 table17Created = this.wmGenericDao.create(table17);
        return table17Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table17 getById(Integer table17Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table17 by id: {}", table17Id);
        Table17 table17 = this.wmGenericDao.findById(table17Id);
        if (table17 == null){
            LOGGER.debug("No Table17 found with id: {}", table17Id);
            throw new EntityNotFoundException(String.valueOf(table17Id));
        }
        return table17;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table17 findById(Integer table17Id) {
        LOGGER.debug("Finding Table17 by id: {}", table17Id);
        return this.wmGenericDao.findById(table17Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table17 update(Table17 table17) throws EntityNotFoundException {
        LOGGER.debug("Updating Table17 with information: {}", table17);
        this.wmGenericDao.update(table17);

        Integer table17Id = table17.getId();

        return this.wmGenericDao.findById(table17Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table17 delete(Integer table17Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table17 with id: {}", table17Id);
        Table17 deleted = this.wmGenericDao.findById(table17Id);
        if (deleted == null) {
            LOGGER.debug("No Table17 found with id: {}", table17Id);
            throw new EntityNotFoundException(String.valueOf(table17Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table17> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table17s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table17> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table17s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table17 to {} format", exportType);
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

