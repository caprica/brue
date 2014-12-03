/*
 * Copyright 2014 Caprica Software Limited
 * (http://www.capricasoftware.co.uk)
 *
 * This file is part of Brue.
 *
 * Brue is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * Brue is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Brue.  If not, see <http://www.gnu.org/licenses/>.
 */

package uk.co.caprica.brue.domain.result;

import java.util.List;

import uk.co.caprica.brue.domain.Immutable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/**
 * Base implementation for a result that contains a list of elements.
 *
 * @param <T> type of result list
 */
@Immutable
abstract class AbstractListResult<T> {

    /**
     * The results.
     */
    private final List<T> results;

    /**
     * Create a result.
     * <p>
     * An immutable copy of the results list is taken.
     *
     * @param results list of results
     */
    public AbstractListResult(List<T> results) {
        this.results = ImmutableList.copyOf(results);
    }

    /**
     * Convenience method to get the first result (the most common use-case).
     *
     * Null checks and optional here are debatable since i always expect one result - it's a bit defensive.
     *
     * @return first result
     */
    public final Optional<T> first() {
        return Optional.fromNullable(results.isEmpty() ? null : results.get(0));
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
            .add("results", results)
            .toString();
    }
}
