/*Generated by WaveMaker Studio*/
package com.testing9thnov_stage.db123__.service;

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

import com.testing9thnov_stage.db123__.ShortseqtServerdef;

/**
 * Service object for domain model class {@link ShortseqtServerdef}.
 */
public interface ShortseqtServerdefService {

    /**
     * Creates a new ShortseqtServerdef. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ShortseqtServerdef if any.
     *
     * @param shortseqtServerdef Details of the ShortseqtServerdef to be created; value cannot be null.
     * @return The newly created ShortseqtServerdef.
     */
	ShortseqtServerdef create(@Valid ShortseqtServerdef shortseqtServerdef);


	/**
	 * Returns ShortseqtServerdef by given id if exists.
	 *
	 * @param shortseqtserverdefId The id of the ShortseqtServerdef to get; value cannot be null.
	 * @return ShortseqtServerdef associated with the given shortseqtserverdefId.
     * @throws EntityNotFoundException If no ShortseqtServerdef is found.
	 */
	ShortseqtServerdef getById(Integer shortseqtserverdefId) throws EntityNotFoundException;

    /**
	 * Find and return the ShortseqtServerdef by given id if exists, returns null otherwise.
	 *
	 * @param shortseqtserverdefId The id of the ShortseqtServerdef to get; value cannot be null.
	 * @return ShortseqtServerdef associated with the given shortseqtserverdefId.
	 */
	ShortseqtServerdef findById(Integer shortseqtserverdefId);


	/**
	 * Updates the details of an existing ShortseqtServerdef. It replaces all fields of the existing ShortseqtServerdef with the given shortseqtServerdef.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on ShortseqtServerdef if any.
     *
	 * @param shortseqtServerdef The details of the ShortseqtServerdef to be updated; value cannot be null.
	 * @return The updated ShortseqtServerdef.
	 * @throws EntityNotFoundException if no ShortseqtServerdef is found with given input.
	 */
	ShortseqtServerdef update(@Valid ShortseqtServerdef shortseqtServerdef) throws EntityNotFoundException;

    /**
	 * Deletes an existing ShortseqtServerdef with the given id.
	 *
	 * @param shortseqtserverdefId The id of the ShortseqtServerdef to be deleted; value cannot be null.
	 * @return The deleted ShortseqtServerdef.
	 * @throws EntityNotFoundException if no ShortseqtServerdef found with the given id.
	 */
	ShortseqtServerdef delete(Integer shortseqtserverdefId) throws EntityNotFoundException;

	/**
	 * Find all ShortseqtServerdefs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ShortseqtServerdefs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<ShortseqtServerdef> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all ShortseqtServerdefs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ShortseqtServerdefs.
     *
     * @see Pageable
     * @see Page
	 */
    Page<ShortseqtServerdef> findAll(String query, Pageable pageable);

    /**
	 * Exports all ShortseqtServerdefs matching the given input query to the given exportType format.
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
	 * Retrieve the count of the ShortseqtServerdefs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the ShortseqtServerdef.
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

