/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.viewsdb.Testnumbertypes;
import com.testing9thnov_stage.viewsdb.TestnumbertypesId;

/**
 * Service object for domain model class {@link Testnumbertypes}.
 */
public interface TestnumbertypesService {

    /**
     * Creates a new Testnumbertypes. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Testnumbertypes if any.
     *
     * @param testnumbertypes Details of the Testnumbertypes to be created; value cannot be null.
     * @return The newly created Testnumbertypes.
     */
	Testnumbertypes create(@Valid Testnumbertypes testnumbertypes);


	/**
	 * Returns Testnumbertypes by given id if exists.
	 *
	 * @param testnumbertypesId The id of the Testnumbertypes to get; value cannot be null.
	 * @return Testnumbertypes associated with the given testnumbertypesId.
     * @throws EntityNotFoundException If no Testnumbertypes is found.
	 */
	Testnumbertypes getById(TestnumbertypesId testnumbertypesId) throws EntityNotFoundException;

    /**
	 * Find and return the Testnumbertypes by given id if exists, returns null otherwise.
	 *
	 * @param testnumbertypesId The id of the Testnumbertypes to get; value cannot be null.
	 * @return Testnumbertypes associated with the given testnumbertypesId.
	 */
	Testnumbertypes findById(TestnumbertypesId testnumbertypesId);


	/**
	 * Updates the details of an existing Testnumbertypes. It replaces all fields of the existing Testnumbertypes with the given testnumbertypes.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Testnumbertypes if any.
     *
	 * @param testnumbertypes The details of the Testnumbertypes to be updated; value cannot be null.
	 * @return The updated Testnumbertypes.
	 * @throws EntityNotFoundException if no Testnumbertypes is found with given input.
	 */
	Testnumbertypes update(@Valid Testnumbertypes testnumbertypes) throws EntityNotFoundException;

    /**
	 * Deletes an existing Testnumbertypes with the given id.
	 *
	 * @param testnumbertypesId The id of the Testnumbertypes to be deleted; value cannot be null.
	 * @return The deleted Testnumbertypes.
	 * @throws EntityNotFoundException if no Testnumbertypes found with the given id.
	 */
	Testnumbertypes delete(TestnumbertypesId testnumbertypesId) throws EntityNotFoundException;

	/**
	 * Find all Testnumbertypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testnumbertypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Testnumbertypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Testnumbertypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testnumbertypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Testnumbertypes> findAll(String query, Pageable pageable);

    /**
	 * Exports all Testnumbertypes matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Testnumbertypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Testnumbertypes.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

