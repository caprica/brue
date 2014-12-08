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

package uk.co.caprica.brue.domain.bridge;

import uk.co.caprica.brue.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Condition {

    private final String address;

    private final String operator;

    private final String value;

    @JsonCreator
    public Condition(
        @JsonProperty("address" ) String address ,
        @JsonProperty("operator") String operator,
        @JsonProperty("value"   ) String value   ) {
        this.address  = address;
        this.operator = operator;
        this.value    = value;
    }

    public String address() {
        return address;
    }

    public String operator() {
        return operator;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("address" , address )
            .add("operator", operator)
            .add("value"   , value   )
            .toString();
    }
}
