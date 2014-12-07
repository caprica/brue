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

package uk.co.caprica.brue.domain.bridge.authorisation;

import uk.co.caprica.brue.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Authorisation {

    private static final int MIN_USERNAME = 10;

    @JsonProperty("devicetype")
    private final String deviceType;

    @JsonProperty("username")
    private final String username;

    public Authorisation(String deviceType, String username) {
        // We don't ordinarily validate parameters, but this one is an easy one to trip up on
        if (username.length() < MIN_USERNAME) {
            throw new IllegalArgumentException(String.format("Username minimum length is %d", MIN_USERNAME));
        }
        this.deviceType = deviceType;
        this.username = username;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("deviceType", deviceType)
            .add("username"  , username  )
            .toString();
    }
}
