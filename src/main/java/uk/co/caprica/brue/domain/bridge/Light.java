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
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Light implements Comparable<Light> {

    private final State state;

    private final String type;

    private final String name;

    private final String modelId;

    private final String uniqueId;

    private final String swVersion;

    @JsonCreator
    public Light(
        @JsonProperty("state"    ) State  state    ,
        @JsonProperty("type"     ) String type     ,
        @JsonProperty("name"     ) String name     ,
        @JsonProperty("modelid"  ) String modelId  ,
        @JsonProperty("uniqueid" ) String uniqueId ,
        @JsonProperty("swversion") String swVersion) {
        this.state     = state;
        this.type      = type;
        this.name      = name;
        this.modelId   = modelId;
        this.uniqueId  = uniqueId;
        this.swVersion = swVersion;
    }

    public String type() {
        return type;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("state"    , state    )
            .add("type"     , type     )
            .add("name"     , name     )
            .add("modelId"  , modelId  )
            .add("uniqueId" , uniqueId )
            .add("swVersion", swVersion)
            .toString();
    }

    @Override
    public int compareTo(Light another) {
        return ComparisonChain.start()
            .compare(name, another.name, Ordering.natural().nullsLast())
            .compare(type, another.type                                )
            .result();
    }
}
