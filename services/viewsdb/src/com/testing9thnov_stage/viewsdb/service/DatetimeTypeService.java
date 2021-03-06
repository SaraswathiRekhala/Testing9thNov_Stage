/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.joda.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.viewsdb.DatetimeType;

/**
 * Service object for domain model class {@link DatetimeType}.
 */
public interface DatetimeTypeService {

    /**
     * Creates a new DatetimeType. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DatetimeType if any.
     *
     * @param datetimeTypeInstance Details of the DatetimeType to be created; value cannot be null.
     * @return The newly created DatetimeType.
     */
	DatetimeType create(@Valid DatetimeType datetimeTypeInstance);


	/**
	 * Returns DatetimeType by given id if exists.
	 *
	 * @param datetimetypeId The id of the DatetimeType to get; value cannot be null.
	 * @return DatetimeType associated with the given datetimetypeId.
     * @throws EntityNotFoundException If no DatetimeType is found.
	 */
	DatetimeType getById(Integer datetimetypeId) throws EntityNotFoundException;

    /**
	 * Find and return the DatetimeType by given id if exists, returns null otherwise.
	 *
	 * @param datetimetypeId The id of the DatetimeType to get; value cannot be null.
	 * @return DatetimeType associated with the given datetimetypeId.
	 */
	DatetimeType findById(Integer datetimetypeId);

    /**
	 * Find and return the DatetimeType for given id  anddatetimeType  if exists.
	 *
	 * @param id value of id; value cannot be null.
	 * @param datetimeType value of datetimeType; value cannot be null.
	 * @return DatetimeType associated with the given inputs.
     * @throws EntityNotFoundException if no matching DatetimeType found.
	 */
    DatetimeType getByIdAndDatetimeType(int id, LocalDateTime datetimeType)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing DatetimeType. It replaces all fields of the existing DatetimeType with the given datetimeTypeInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on DatetimeType if any.
     *
	 * @param datetimeTypeInstance The details of the DatetimeType to be updated; value cannot be null.
	 * @return The updated DatetimeType.
	 * @throws EntityNotFoundException if no DatetimeType is found with given input.
	 */
	DatetimeType update(@Valid DatetimeType datetimeTypeInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing DatetimeType with the given id.
	 *
	 * @param datetimetypeId The id of the DatetimeType to be deleted; value cannot be null.
	 * @return The deleted DatetimeType.
	 * @throws EntityNotFoundException if no DatetimeType found with the given id.
	 */
	DatetimeType delete(Integer datetimetypeId) throws EntityNotFoundException;

	/**
	 * Find all DatetimeTypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DatetimeTypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<DatetimeType> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all DatetimeTypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DatetimeTypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<DatetimeType> findAll(String query, Pageable pageable);

    /**
	 * Exports all DatetimeTypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the DatetimeTypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the DatetimeType.
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

