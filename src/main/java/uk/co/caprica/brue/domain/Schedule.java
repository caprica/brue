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

package uk.co.caprica.brue.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Schedule implements Comparable<Schedule> {

    private final String name;

    private final String description;

    private final Command command;

    private final String localTime;

    private final String time;

    private final String created;

    private final String status;

    @JsonCreator
    public Schedule(
        @JsonProperty("name"       ) String  name       ,
        @JsonProperty("description") String  description,
        @JsonProperty("command"    ) Command command    ,
        @JsonProperty("localtime"  ) String  localTime  ,
        @JsonProperty("time"       ) String  time       ,
        @JsonProperty("created"    ) String  created    ,
        @JsonProperty("status"     ) String  status     ) {
        this.name        = name;
        this.description = description;
        this.command     = command;
        this.localTime   = localTime;
        this.time        = time;
        this.created     = created;
        this.status      = status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"       , name       )
            .add("description", description)
            .add("command"    , command    )
            .add("localTime"  , localTime  )
            .add("time"       , time       )
            .add("created"    , created    )
            .add("status"     , status     )
            .toString();
    }

    @Override
    public int compareTo(Schedule another) {
        return ComparisonChain.start()
            .compare(name, another.name, Ordering.natural().nullsLast())
            .result();
    }
}

