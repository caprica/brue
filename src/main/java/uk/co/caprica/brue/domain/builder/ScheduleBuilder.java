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

package uk.co.caprica.brue.domain.builder;

import uk.co.caprica.brue.domain.Command;
import uk.co.caprica.brue.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ScheduleBuilder {

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private Command command;

    @JsonProperty
    private String time;

    @JsonProperty
    private String status;

    @JsonProperty(value="autoDelete")
    private Boolean autoDelete;

    private ScheduleBuilder() {
    }

    public static ScheduleBuilder schedule() {
        return new ScheduleBuilder();
    }

    public ScheduleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ScheduleBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ScheduleBuilder command(Command command) {
        this.command = command;
        return this;
    }

    // FIXME need to use a timebuilder? maybe not on the signature, but need a builder to produce the string at least
    public ScheduleBuilder time(String time) {
        this.time = time;
        return this;
    }

    public ScheduleBuilder status(String status) {
        this.status = status;
        return this;
    }

    public ScheduleBuilder autoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("description", description)
            .add("command"    , command    )
            .add("time"       , time       )
            .add("status"     , status     )
            .add("autoDelete" , autoDelete )
            .toString();
    }
}

