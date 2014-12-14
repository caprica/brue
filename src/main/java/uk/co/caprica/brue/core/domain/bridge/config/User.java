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

package uk.co.caprica.brue.core.domain.bridge.config;

import uk.co.caprica.brue.core.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class User {

    private final String lastUseDate;

    private final String createDate;

    private final String name;

    @JsonCreator
    public User(
        @JsonProperty("last use date") String lastUseDate,
        @JsonProperty("create date"  ) String createDate ,
        @JsonProperty("name"         ) String name       ) {
        this.lastUseDate = lastUseDate;
        this.createDate  = createDate;
        this.name        = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("lastUseDate", lastUseDate)
            .add("createDate" , createDate )
            .add("name"       , name       )
            .toString();
    }
}
