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

package uk.co.caprica.brue.core.domain.bridge;

import uk.co.caprica.brue.core.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

// FIXME There is a sub-classing going on for sensor...
// FIXME think there is also state: and config:

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Sensor implements Comparable<Sensor> {

    private final String type;

    private final String name;

    private final String modelId;

    private final String manufacturerName;

    private final String swVersion;

    @JsonCreator
    public Sensor(
        @JsonProperty("type"            ) String type            ,
        @JsonProperty("name"            ) String name            ,
        @JsonProperty("modelid"         ) String modelId         ,
        @JsonProperty("manufacturername") String manufacturerName,
        @JsonProperty("swversion"       ) String swVersion       ) {
        this.type             = type;
        this.name             = name;
        this.modelId          = modelId;
        this.manufacturerName = manufacturerName;
        this.swVersion        = swVersion;
    }

    public String type() {
        return type;
    }

    public String name() {
        return name;
    }

    public String modelId() {
        return modelId;
    }

    public String manufacturerName() {
        return manufacturerName;
    }

    public String swVersion() {
        return swVersion;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("type"            , type            )
            .add("name"            , name            )
            .add("modelId"         , modelId         )
            .add("manufacturerName", manufacturerName)
            .add("swVersion"       , swVersion       )
            .toString();
    }


    @Override
    public int compareTo(Sensor another) {
        return ComparisonChain.start()
            .compare(name, another.name, Ordering.natural().nullsLast())
            .compare(type, another.type                                )
            .result();
    }
}
