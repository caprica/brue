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

import java.util.List;

import uk.co.caprica.brue.core.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Scene implements Comparable<Scene> {

    private final String name;

    private final List<String> lights;

    private final Boolean active;

    @JsonCreator
    public Scene(
        @JsonProperty("name"  ) String       name  ,
        @JsonProperty("lights") List<String> lights,
        @JsonProperty("active") Boolean      active) {
        this.name   = name;
        this.lights = ImmutableList.copyOf(lights);
        this.active = active;
    }

    public String name() {
        return name;
    }

    public List<String> lights() {
        return lights;
    }

    public Boolean active() {
        return active;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"  , name  )
            .add("lights", lights)
            .add("active", active)
            .toString();
    }

    @Override
    public int compareTo(Scene another) {
        return ComparisonChain.start()
            .compare(name, another.name , Ordering.natural().nullsLast())
            .result();
    }
}
