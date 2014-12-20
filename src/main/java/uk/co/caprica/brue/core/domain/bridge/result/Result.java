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

package uk.co.caprica.brue.core.domain.bridge.result;

import static uk.co.caprica.brue.core.util.Cast.cast;

import java.util.Map;

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

@Immutable
abstract class Result {

    private final Map<String,?> result;

    public Result(Map<String,?> result) {
        this.result = ImmutableMap.copyOf(result);
    }

    public Map<String,?> result() {
        return result;
    }

    public <T> T get(String key, Class<T> type) {
        return cast(result.get(key));
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
            .add("result", result)
            .toString();
    }
}
