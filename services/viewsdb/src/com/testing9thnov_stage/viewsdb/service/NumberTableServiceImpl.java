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
import org.springframework.context.annotation.Lazy;
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

import com.testing9thnov_stage.viewsdb.NumberTable;
import com.testing9thnov_stage.viewsdb.Table2;


/**
 * ServiceImpl object for domain model class NumberTable.
 *
 * @see NumberTable
 */
@Service("viewsdb.NumberTableService")
@Validated
public class NumberTableServiceImpl implements NumberTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberTableServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("viewsdb.Table2Service")
	private Table2Service table2Service;

    @Autowired
    @Qualifier("viewsdb.NumberTableDao")
    private WMGenericDao<NumberTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<NumberTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public NumberTable create(NumberTable numberTable) {
        LOGGER.debug("Creating a new NumberTable with information: {}", numberTable);
        NumberTable numberTableCreated = this.wmGenericDao.create(numberTable);
        if(numberTableCreated.getTable2() != null) {
            Table2 table2 = numberTableCreated.getTable2();
            LOGGER.debug("Creating a new child Table2 with information: {}", table2);
            table2.setNumberTable(numberTableCreated);
            table2Service.create(table2);
        }
        return numberTableCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public NumberTable getById(Integer numbertableId) throws EntityNotFoundException {
        LOGGER.debug("Finding NumberTable by id: {}", numbertableId);
        NumberTable numberTable = this.wmGenericDao.findById(numbertableId);
        if (numberTable == null){
            LOGGER.debug("No NumberTable found with id: {}", numbertableId);
            throw new EntityNotFoundException(String.valueOf(numbertableId));
        }
        return numberTable;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public NumberTable findById(Integer numbertableId) {
        LOGGER.debug("Finding NumberTable by id: {}", numbertableId);
        return this.wmGenericDao.findById(numbertableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public NumberTable update(NumberTable numberTable) throws EntityNotFoundException {
        LOGGER.debug("Updating NumberTable with information: {}", numberTable);
        this.wmGenericDao.update(numberTable);

        Integer numbertableId = numberTable.getId();

        return this.wmGenericDao.findById(numbertableId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public NumberTable delete(Integer numbertableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting NumberTable with id: {}", numbertableId);
        NumberTable deleted = this.wmGenericDao.findById(numbertableId);
        if (deleted == null) {
            LOGGER.debug("No NumberTable found with id: {}", numbertableId);
            throw new EntityNotFoundException(String.valueOf(numbertableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<NumberTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all NumberTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<NumberTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all NumberTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table NumberTable to {} format", exportType);
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


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table2Service instance
	 */
	protected void setTable2Service(Table2Service service) {
        this.table2Service = service;
    }

}

