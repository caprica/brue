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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.caprica.brue.core.domain.Mutable;

@Mutable
public final class ResultList extends ArrayList<Map<String,?>> {

    public Results results() {
        List<SuccessResult> successes = new ArrayList<>(size());
        List<ErrorResult> errors = new ArrayList<>(size());
        for (Map<String,?> map: this) {
            Map.Entry<String,?> entry = map.entrySet().iterator().next();
            String type = entry.getKey();
            Map<String,?> values = values(entry.getValue());
            switch (type) {
                case "success":
                    successes.add(new SuccessResult(values));
                    break;
                case "error":
                    errors.add(new ErrorResult(values));
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Don't know about result type '%s'", type));
            }
        }
        return new Results(successes, errors);
    }

    private Map<String,?> values(Object value) {
        if (value instanceof Map) {
            return cast(value);
        }
        else if (value instanceof String) {
            Map<String,Object> values = new HashMap<>();
            values.put("success", value);
            return values;
        }
        else {
            throw new IllegalArgumentException(String.format("Don't know about result value '%s'", value));
        }
    }
}
