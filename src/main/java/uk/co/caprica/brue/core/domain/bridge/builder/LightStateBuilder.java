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

package uk.co.caprica.brue.core.domain.bridge.builder;

import uk.co.caprica.brue.core.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class LightStateBuilder extends StateBuilder<LightStateBuilder> {

    public static LightStateBuilder lightState() {
        return new LightStateBuilder();
    }

    private LightStateBuilder() {
    }

    @Override
    protected LightStateBuilder me() {
        return this;
    }

    @Override
    public String toString() {
        return toStringHelper()
            .toString();
    }
}
