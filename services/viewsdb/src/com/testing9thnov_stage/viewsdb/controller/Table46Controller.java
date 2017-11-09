/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing9thnov_stage.viewsdb.Table46;
import com.testing9thnov_stage.viewsdb.service.Table46Service;


/**
 * Controller object for domain model class Table46.
 * @see Table46
 */
@RestController("viewsdb.Table46Controller")
@Api(value = "Table46Controller", description = "Exposes APIs to work with Table46 resource.")
@RequestMapping("/viewsdb/Table46")
public class Table46Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table46Controller.class);

    @Autowired
	@Qualifier("viewsdb.Table46Service")
	private Table46Service table46Service;

	@ApiOperation(value = "Creates a new Table46 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Table46 createTable46(@RequestBody Table46 table46) {
		LOGGER.debug("Create Table46 with information: {}" , table46);

		table46 = table46Service.create(table46);
		LOGGER.debug("Created Table46 with information: {}" , table46);

	    return table46;
	}

    @ApiOperation(value = "Returns the Table46 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table46 getTable46(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table46 with id: {}" , id);

        Table46 foundTable46 = table46Service.getById(id);
        LOGGER.debug("Table46 details with id: {}" , foundTable46);

        return foundTable46;
    }

    @ApiOperation(value = "Updates the Table46 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table46 editTable46(@PathVariable("id") Integer id, @RequestBody Table46 table46) throws EntityNotFoundException {
        LOGGER.debug("Editing Table46 with id: {}" , table46.getId());

        table46.setId(id);
        table46 = table46Service.update(table46);
        LOGGER.debug("Table46 details with id: {}" , table46);

        return table46;
    }

    @ApiOperation(value = "Deletes the Table46 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable46(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table46 with id: {}" , id);

        Table46 deletedTable46 = table46Service.delete(id);

        return deletedTable46 != null;
    }

    /**
     * @deprecated Use {@link #findTable46s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table46 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table46> searchTable46sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table46s list");
        return table46Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table46 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table46> findTable46s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table46s list");
        return table46Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table46 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table46> filterTable46s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table46s list");
        return table46Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable46s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table46Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table46 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable46s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table46s");
		return table46Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable46AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table46Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table46Service instance
	 */
	protected void setTable46Service(Table46Service service) {
		this.table46Service = service;
	}

}

