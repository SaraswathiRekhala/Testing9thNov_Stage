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

import com.testing9thnov_stage.viewsdb.TestUpdate;
import com.testing9thnov_stage.viewsdb.service.TestUpdateService;


/**
 * Controller object for domain model class TestUpdate.
 * @see TestUpdate
 */
@RestController("viewsdb.TestUpdateController")
@Api(value = "TestUpdateController", description = "Exposes APIs to work with TestUpdate resource.")
@RequestMapping("/viewsdb/TestUpdate")
public class TestUpdateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUpdateController.class);

    @Autowired
	@Qualifier("viewsdb.TestUpdateService")
	private TestUpdateService testUpdateService;

	@ApiOperation(value = "Creates a new TestUpdate instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TestUpdate createTestUpdate(@RequestBody TestUpdate testUpdate) {
		LOGGER.debug("Create TestUpdate with information: {}" , testUpdate);

		testUpdate = testUpdateService.create(testUpdate);
		LOGGER.debug("Created TestUpdate with information: {}" , testUpdate);

	    return testUpdate;
	}

    @ApiOperation(value = "Returns the TestUpdate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestUpdate getTestUpdate(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Getting TestUpdate with id: {}" , id);

        TestUpdate foundTestUpdate = testUpdateService.getById(id);
        LOGGER.debug("TestUpdate details with id: {}" , foundTestUpdate);

        return foundTestUpdate;
    }

    @ApiOperation(value = "Updates the TestUpdate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestUpdate editTestUpdate(@PathVariable("id") Short id, @RequestBody TestUpdate testUpdate) throws EntityNotFoundException {
        LOGGER.debug("Editing TestUpdate with id: {}" , testUpdate.getId());

        testUpdate.setId(id);
        testUpdate = testUpdateService.update(testUpdate);
        LOGGER.debug("TestUpdate details with id: {}" , testUpdate);

        return testUpdate;
    }

    @ApiOperation(value = "Deletes the TestUpdate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTestUpdate(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestUpdate with id: {}" , id);

        TestUpdate deletedTestUpdate = testUpdateService.delete(id);

        return deletedTestUpdate != null;
    }

    /**
     * @deprecated Use {@link #findTestUpdates(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TestUpdate instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestUpdate> searchTestUpdatesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TestUpdates list");
        return testUpdateService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TestUpdate instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestUpdate> findTestUpdates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TestUpdates list");
        return testUpdateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TestUpdate instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestUpdate> filterTestUpdates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TestUpdates list");
        return testUpdateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTestUpdates(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return testUpdateService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TestUpdate instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTestUpdates( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TestUpdates");
		return testUpdateService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTestUpdateAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return testUpdateService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestUpdateService instance
	 */
	protected void setTestUpdateService(TestUpdateService service) {
		this.testUpdateService = service;
	}

}

