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

import com.testing9thnov_stage.viewsdb.NumberView;
import com.testing9thnov_stage.viewsdb.NumberViewId;


/**
 * ServiceImpl object for domain model class NumberView.
 *
 * @see NumberView
 */
@Service("viewsdb.NumberViewService")
@Validated
public class NumberViewServiceImpl implements NumberViewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberViewServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.NumberViewDao")
    private WMGenericDao<NumberView, NumberViewId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<NumberView, NumberViewId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public NumberView create(NumberView numberView) {
        LOGGER.debug("Creating a new NumberView with information: {}", numberView);
        NumberView numberViewCreated = this.wmGenericDao.create(numberView);
        return numberViewCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public NumberView getById(NumberViewId numberviewId) throws EntityNotFoundException {
        LOGGER.debug("Finding NumberView by id: {}", numberviewId);
        NumberView numberView = this.wmGenericDao.findById(numberviewId);
        if (numberView == null){
            LOGGER.debug("No NumberView found with id: {}", numberviewId);
            throw new EntityNotFoundException(String.valueOf(numberviewId));
        }
        return numberView;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public NumberView findById(NumberViewId numberviewId) {
        LOGGER.debug("Finding NumberView by id: {}", numberviewId);
        return this.wmGenericDao.findById(numberviewId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public NumberView update(NumberView numberView) throws EntityNotFoundException {
        LOGGER.debug("Updating NumberView with information: {}", numberView);
        this.wmGenericDao.update(numberView);

        NumberViewId numberviewId = new NumberViewId();
        numberviewId.setId(numberView.getId());
        numberviewId.setIntegerCol(numberView.getIntegerCol());
        numberviewId.setShortCol(numberView.getShortCol());
        numberviewId.setLongCol(numberView.getLongCol());
        numberviewId.setBigintegerCol(numberView.getBigintegerCol());
        numberviewId.setByteCol(numberView.getByteCol());
        numberviewId.setFloatCol(numberView.getFloatCol());
        numberviewId.setDoubleCol(numberView.getDoubleCol());

        return this.wmGenericDao.findById(numberviewId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public NumberView delete(NumberViewId numberviewId) throws EntityNotFoundException {
        LOGGER.debug("Deleting NumberView with id: {}", numberviewId);
        NumberView deleted = this.wmGenericDao.findById(numberviewId);
        if (deleted == null) {
            LOGGER.debug("No NumberView found with id: {}", numberviewId);
            throw new EntityNotFoundException(String.valueOf(numberviewId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<NumberView> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all NumberViews");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<NumberView> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all NumberViews");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table NumberView to {} format", exportType);
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

