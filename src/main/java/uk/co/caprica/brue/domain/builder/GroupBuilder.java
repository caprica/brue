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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import uk.co.caprica.brue.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GroupBuilder {

    @JsonProperty
    private Optional<String> name;

    @JsonProperty
    private List<String> lights;

    private GroupBuilder() {
    }

    public static GroupBuilder group() {
        return new GroupBuilder();
    }

    public GroupBuilder name(String name) {
        this.name = Optional.of(name);
        return this;
    }

    public GroupBuilder lights(Collection<String> lights) {
        if (this.lights == null) {
            this.lights = new ArrayList<>(lights);
        }
        else {
            this.lights.addAll(lights);
        }
        return this;
    }

    public GroupBuilder lights(String... lights) {
        return lights(Arrays.asList(lights));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"  , name  )
            .add("lights", lights)
            .toString();
    }
}
