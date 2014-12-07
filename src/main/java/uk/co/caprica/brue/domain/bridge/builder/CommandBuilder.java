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

package uk.co.caprica.brue.domain.bridge.builder;

import uk.co.caprica.brue.domain.Mutable;
import uk.co.caprica.brue.domain.bridge.Body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CommandBuilder {

    @JsonProperty
    private String address;

    @JsonProperty
    private String method;

    @JsonProperty
    private Body body;

    public static CommandBuilder command() {
        return new CommandBuilder();
    }

    private CommandBuilder() {
    }

    public CommandBuilder address(String address) {
        this.address = address;
        return this;
    }

    public CommandBuilder method(String method) {
        this.method = method;
        return this;
    }

    public CommandBuilder body(Body body) {
        this.body = body;
        return this;
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
