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

import com.testing9thnov_stage.viewsdb.Nullrecordsview;
import com.testing9thnov_stage.viewsdb.NullrecordsviewId;

/**
 * Service object for domain model class {@link Nullrecordsview}.
 */
public interface NullrecordsviewService {

    /**
     * Creates a new Nullrecordsview. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Nullrecordsview if any.
     *
     * @param nullrecordsview Details of the Nullrecordsview to be created; value cannot be null.
     * @return The newly created Nullrecordsview.
     */
	Nullrecordsview create(@Valid Nullrecordsview nullrecordsview);


	/**
	 * Returns Nullrecordsview by given id if exists.
	 *
	 * @param nullrecordsviewId The id of the Nullrecordsview to get; value cannot be null.
	 * @return Nullrecordsview associated with the given nullrecordsviewId.
     * @throws EntityNotFoundException If no Nullrecordsview is found.
	 */
	Nullrecordsview getById(NullrecordsviewId nullrecordsviewId) throws EntityNotFoundException;

    /**
	 * Find and return the Nullrecordsview by given id if exists, returns null otherwise.
	 *
	 * @param nullrecordsviewId The id of the Nullrecordsview to get; value cannot be null.
	 * @return Nullrecordsview associated with the given nullrecordsviewId.
	 */
	Nullrecordsview findById(NullrecordsviewId nullrecordsviewId);


	/**
	 * Updates the details of an existing Nullrecordsview. It replaces all fields of the existing Nullrecordsview with the given nullrecordsview.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Nullrecordsview if any.
     *
	 * @param nullrecordsview The details of the Nullrecordsview to be updated; value cannot be null.
	 * @return The updated Nullrecordsview.
	 * @throws EntityNotFoundException if no Nullrecordsview is found with given input.
	 */
	Nullrecordsview update(@Valid Nullrecordsview nullrecordsview) throws EntityNotFoundException;

    /**
	 * Deletes an existing Nullrecordsview with the given id.
	 *
	 * @param nullrecordsviewId The id of the Nullrecordsview to be deleted; value cannot be null.
	 * @return The deleted Nullrecordsview.
	 * @throws EntityNotFoundException if no Nullrecordsview found with the given id.
	 */
	Nullrecordsview delete(NullrecordsviewId nullrecordsviewId) throws EntityNotFoundException;

	/**
	 * Find all Nullrecordsviews matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Nullrecordsviews.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Nullrecordsview> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Nullrecordsviews matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Nullrecordsviews.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Nullrecordsview> findAll(String query, Pageable pageable);

    /**
	 * Exports all Nullrecordsviews matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Nullrecordsviews in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Nullrecordsview.
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

