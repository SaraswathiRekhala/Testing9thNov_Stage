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

import com.testing9thnov_stage.viewsdb.BooleanTestCase;
import com.testing9thnov_stage.viewsdb.service.BooleanTestCaseService;


/**
 * Controller object for domain model class BooleanTestCase.
 * @see BooleanTestCase
 */
@RestController("viewsdb.BooleanTestCaseController")
@Api(value = "BooleanTestCaseController", description = "Exposes APIs to work with BooleanTestCase resource.")
@RequestMapping("/viewsdb/BooleanTestCase")
public class BooleanTestCaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanTestCaseController.class);

    @Autowired
	@Qualifier("viewsdb.BooleanTestCaseService")
	private BooleanTestCaseService booleanTestCaseService;

	@ApiOperation(value = "Creates a new BooleanTestCase instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public BooleanTestCase createBooleanTestCase(@RequestBody BooleanTestCase booleanTestCase) {
		LOGGER.debug("Create BooleanTestCase with information: {}" , booleanTestCase);

		booleanTestCase = booleanTestCaseService.create(booleanTestCase);
		LOGGER.debug("Created BooleanTestCase with information: {}" , booleanTestCase);

	    return booleanTestCase;
	}

    @ApiOperation(value = "Returns the BooleanTestCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BooleanTestCase getBooleanTestCase(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting BooleanTestCase with id: {}" , id);

        BooleanTestCase foundBooleanTestCase = booleanTestCaseService.getById(id);
        LOGGER.debug("BooleanTestCase details with id: {}" , foundBooleanTestCase);

        return foundBooleanTestCase;
    }

    @ApiOperation(value = "Updates the BooleanTestCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BooleanTestCase editBooleanTestCase(@PathVariable("id") Integer id, @RequestBody BooleanTestCase booleanTestCase) throws EntityNotFoundException {
        LOGGER.debug("Editing BooleanTestCase with id: {}" , booleanTestCase.getId());

        booleanTestCase.setId(id);
        booleanTestCase = booleanTestCaseService.update(booleanTestCase);
        LOGGER.debug("BooleanTestCase details with id: {}" , booleanTestCase);

        return booleanTestCase;
    }

    @ApiOperation(value = "Deletes the BooleanTestCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBooleanTestCase(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting BooleanTestCase with id: {}" , id);

        BooleanTestCase deletedBooleanTestCase = booleanTestCaseService.delete(id);

        return deletedBooleanTestCase != null;
    }

    /**
     * @deprecated Use {@link #findBooleanTestCases(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of BooleanTestCase instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanTestCase> searchBooleanTestCasesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering BooleanTestCases list");
        return booleanTestCaseService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BooleanTestCase instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanTestCase> findBooleanTestCases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BooleanTestCases list");
        return booleanTestCaseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BooleanTestCase instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanTestCase> filterBooleanTestCases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BooleanTestCases list");
        return booleanTestCaseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBooleanTestCases(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return booleanTestCaseService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of BooleanTestCase instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBooleanTestCases( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting BooleanTestCases");
		return booleanTestCaseService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBooleanTestCaseAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return booleanTestCaseService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BooleanTestCaseService instance
	 */
	protected void setBooleanTestCaseService(BooleanTestCaseService service) {
		this.booleanTestCaseService = service;
	}

}

