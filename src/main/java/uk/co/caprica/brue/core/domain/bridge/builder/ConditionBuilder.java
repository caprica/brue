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

package uk.co.caprica.brue.core.domain.bridge.builder;

import uk.co.caprica.brue.core.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConditionBuilder {

    @JsonProperty
    private String address;

    @JsonProperty
    private String operator;

    @JsonProperty
    private String value;

    public static ConditionBuilder condition() {
        return new ConditionBuilder();
    }

    private ConditionBuilder() {
    }

    public ConditionBuilder address(String address) {
        this.address = address;
        return this;
    }

    public ConditionBuilder operator(String operator) {
        this.operator = operator;
        return this;
    }

    public ConditionBuilder value(String value) {
        this.value = value;
        return this;
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
