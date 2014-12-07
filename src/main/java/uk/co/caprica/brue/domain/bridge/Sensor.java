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

// FIXME There is a sub-classing going on for sensor...
// FIXME think there is also state: and config:

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Sensor {

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
}
