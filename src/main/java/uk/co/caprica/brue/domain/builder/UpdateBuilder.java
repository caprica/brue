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

import uk.co.caprica.brue.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UpdateBuilder {

    @JsonProperty("updatestate")
    private Integer updateState;

    @JsonProperty
    private String url;

    @JsonProperty
    private String text;

    @JsonProperty
    private Boolean notify;

    private UpdateBuilder() {
    }

    public static UpdateBuilder config() {
        return new UpdateBuilder();
    }

    public UpdateBuilder updateState(Integer updateState) {
        this.updateState = updateState;
        return this;
    }

    public UpdateBuilder url(String url) {
        this.url = url;
        return this;
    }

    public UpdateBuilder text(String text) {
        this.text = text;
        return this;
    }

    public UpdateBuilder notify(Boolean notify) {
        this.notify = notify;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("updateState", updateState)
            .add("url"        , url        )
            .add("text"       , text       )
            .add("notify"     , notify     )
            .toString();
    }
}
