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

import java.util.List;

import uk.co.caprica.brue.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Rule implements Comparable<Rule> {

    private final String name;

    private final String owner;

    private final String created;

    private final String lastTriggered;

    private final String status;

    private final List<Condition> conditions;

    private final List<Command> actions;

    @JsonCreator
    public Rule(
        @JsonProperty("name"         ) String           name         ,
        @JsonProperty("owner"        ) String           owner        ,
        @JsonProperty("created"      ) String           created      ,
        @JsonProperty("lastTriggered") String           lastTriggered,
        @JsonProperty("status"       ) String           status       ,
        @JsonProperty("conditions"   ) List<Condition>  conditions   ,
        @JsonProperty("actions"      ) List<Command>    actions      ) {
        this.name          = name;
        this.owner         = owner;
        this.created       = created;
        this.lastTriggered = lastTriggered;
        this.status        = status;
        this.conditions    = ImmutableList.copyOf(conditions);
        this.actions       = ImmutableList.copyOf(actions);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"         , name         )
            .add("owner"        , owner        )
            .add("created"      , created      )
            .add("lastTriggered", lastTriggered)
            .add("status"       , status       )
            .add("conditions"   , conditions   )
            .add("actions"      , actions      )
            .toString();
    }

    @Override
    public int compareTo(Rule another) {
        return ComparisonChain.start()
            .compare(name , another.name , Ordering.natural().nullsLast())
            .compare(owner, another.owner                                )
            .result();
    }
}
