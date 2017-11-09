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

import com.testing9thnov_stage.viewsdb.Testnumbertypes;
import com.testing9thnov_stage.viewsdb.TestnumbertypesId;


/**
 * ServiceImpl object for domain model class Testnumbertypes.
 *
 * @see Testnumbertypes
 */
@Service("viewsdb.TestnumbertypesService")
@Validated
public class TestnumbertypesServiceImpl implements TestnumbertypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestnumbertypesServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.TestnumbertypesDao")
    private WMGenericDao<Testnumbertypes, TestnumbertypesId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Testnumbertypes, TestnumbertypesId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Testnumbertypes create(Testnumbertypes testnumbertypes) {
        LOGGER.debug("Creating a new Testnumbertypes with information: {}", testnumbertypes);
        Testnumbertypes testnumbertypesCreated = this.wmGenericDao.create(testnumbertypes);
        return testnumbertypesCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Testnumbertypes getById(TestnumbertypesId testnumbertypesId) throws EntityNotFoundException {
        LOGGER.debug("Finding Testnumbertypes by id: {}", testnumbertypesId);
        Testnumbertypes testnumbertypes = this.wmGenericDao.findById(testnumbertypesId);
        if (testnumbertypes == null){
            LOGGER.debug("No Testnumbertypes found with id: {}", testnumbertypesId);
            throw new EntityNotFoundException(String.valueOf(testnumbertypesId));
        }
        return testnumbertypes;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Testnumbertypes findById(TestnumbertypesId testnumbertypesId) {
        LOGGER.debug("Finding Testnumbertypes by id: {}", testnumbertypesId);
        return this.wmGenericDao.findById(testnumbertypesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Testnumbertypes update(Testnumbertypes testnumbertypes) throws EntityNotFoundException {
        LOGGER.debug("Updating Testnumbertypes with information: {}", testnumbertypes);
        this.wmGenericDao.update(testnumbertypes);

        TestnumbertypesId testnumbertypesId = new TestnumbertypesId();
        testnumbertypesId.setDeccol(testnumbertypes.getDeccol());
        testnumbertypesId.setNumericcol(testnumbertypes.getNumericcol());
        testnumbertypesId.setFloatcol(testnumbertypes.getFloatcol());
        testnumbertypesId.setRealcol(testnumbertypes.getRealcol());
        testnumbertypesId.setDoupcol(testnumbertypes.getDoupcol());

        return this.wmGenericDao.findById(testnumbertypesId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Testnumbertypes delete(TestnumbertypesId testnumbertypesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testnumbertypes with id: {}", testnumbertypesId);
        Testnumbertypes deleted = this.wmGenericDao.findById(testnumbertypesId);
        if (deleted == null) {
            LOGGER.debug("No Testnumbertypes found with id: {}", testnumbertypesId);
            throw new EntityNotFoundException(String.valueOf(testnumbertypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Testnumbertypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Testnumbertypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Testnumbertypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Testnumbertypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Testnumbertypes to {} format", exportType);
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
