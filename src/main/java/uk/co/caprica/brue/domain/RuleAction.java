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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class RuleAction {

    private final String address;

    private final String method;

    private final Map body; // FIXME what is this exactly... do i need sub-classes or must it be totally generic (e.g. map<string,object> ?)

    @JsonCreator
    public RuleAction(
        @JsonProperty("address") String address,
        @JsonProperty("method")  String method ,
        @JsonProperty("body")    Map    body   ) {
        this.address = address;
        this.method  = method;
        this.body    = ImmutableMap.copyOf(body);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("address", address)
            .add("method" , method )
            .add("body"   , body   )
            .toString();
    }
}
