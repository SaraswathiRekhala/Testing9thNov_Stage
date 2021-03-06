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

import com.testing9thnov_stage.viewsdb.Table64;
import com.testing9thnov_stage.viewsdb.service.Table64Service;


/**
 * Controller object for domain model class Table64.
 * @see Table64
 */
@RestController("viewsdb.Table64Controller")
@Api(value = "Table64Controller", description = "Exposes APIs to work with Table64 resource.")
@RequestMapping("/viewsdb/Table64")
public class Table64Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table64Controller.class);

    @Autowired
	@Qualifier("viewsdb.Table64Service")
	private Table64Service table64Service;

	@ApiOperation(value = "Creates a new Table64 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Table64 createTable64(@RequestBody Table64 table64) {
		LOGGER.debug("Create Table64 with information: {}" , table64);

		table64 = table64Service.create(table64);
		LOGGER.debug("Created Table64 with information: {}" , table64);

	    return table64;
	}

    @ApiOperation(value = "Returns the Table64 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table64 getTable64(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table64 with id: {}" , id);

        Table64 foundTable64 = table64Service.getById(id);
        LOGGER.debug("Table64 details with id: {}" , foundTable64);

        return foundTable64;
    }

    @ApiOperation(value = "Updates the Table64 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table64 editTable64(@PathVariable("id") Integer id, @RequestBody Table64 table64) throws EntityNotFoundException {
        LOGGER.debug("Editing Table64 with id: {}" , table64.getId());

        table64.setId(id);
        table64 = table64Service.update(table64);
        LOGGER.debug("Table64 details with id: {}" , table64);

        return table64;
    }

    @ApiOperation(value = "Deletes the Table64 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable64(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table64 with id: {}" , id);

        Table64 deletedTable64 = table64Service.delete(id);

        return deletedTable64 != null;
    }

    /**
     * @deprecated Use {@link #findTable64s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table64 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table64> searchTable64sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table64s list");
        return table64Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table64 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table64> findTable64s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table64s list");
        return table64Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table64 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table64> filterTable64s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table64s list");
        return table64Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable64s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table64Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table64 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable64s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table64s");
		return table64Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable64AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table64Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table64Service instance
	 */
	protected void setTable64Service(Table64Service service) {
		this.table64Service = service;
	}

}

