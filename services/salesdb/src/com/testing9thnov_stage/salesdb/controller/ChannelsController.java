/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.salesdb.controller;

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

import com.testing9thnov_stage.salesdb.Channels;
import com.testing9thnov_stage.salesdb.Reps;
import com.testing9thnov_stage.salesdb.service.ChannelsService;


/**
 * Controller object for domain model class Channels.
 * @see Channels
 */
@RestController("salesdb.ChannelsController")
@Api(value = "ChannelsController", description = "Exposes APIs to work with Channels resource.")
@RequestMapping("/salesdb/Channels")
public class ChannelsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelsController.class);

    @Autowired
	@Qualifier("salesdb.ChannelsService")
	private ChannelsService channelsService;

	@ApiOperation(value = "Creates a new Channels instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Channels createChannels(@RequestBody Channels channels) {
		LOGGER.debug("Create Channels with information: {}" , channels);

		channels = channelsService.create(channels);
		LOGGER.debug("Created Channels with information: {}" , channels);

	    return channels;
	}

    @ApiOperation(value = "Returns the Channels instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Channels getChannels(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Channels with id: {}" , id);

        Channels foundChannels = channelsService.getById(id);
        LOGGER.debug("Channels details with id: {}" , foundChannels);

        return foundChannels;
    }

    @ApiOperation(value = "Updates the Channels instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Channels editChannels(@PathVariable("id") Integer id, @RequestBody Channels channels) throws EntityNotFoundException {
        LOGGER.debug("Editing Channels with id: {}" , channels.getId());

        channels.setId(id);
        channels = channelsService.update(channels);
        LOGGER.debug("Channels details with id: {}" , channels);

        return channels;
    }

    @ApiOperation(value = "Deletes the Channels instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteChannels(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Channels with id: {}" , id);

        Channels deletedChannels = channelsService.delete(id);

        return deletedChannels != null;
    }

    /**
     * @deprecated Use {@link #findChannels(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Channels instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Channels> searchChannelsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Channels list");
        return channelsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Channels instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Channels> findChannels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Channels list");
        return channelsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Channels instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Channels> filterChannels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Channels list");
        return channelsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportChannels(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return channelsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Channels instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countChannels( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Channels");
		return channelsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getChannelsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return channelsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/repses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the repses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Reps> findAssociatedRepses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated repses");
        return channelsService.findAssociatedRepses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ChannelsService instance
	 */
	protected void setChannelsService(ChannelsService service) {
		this.channelsService = service;
	}

}

