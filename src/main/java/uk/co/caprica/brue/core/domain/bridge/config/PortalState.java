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

package uk.co.caprica.brue.core.domain.bridge.config;

import uk.co.caprica.brue.core.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class PortalState {

    private final Boolean signedOn;

    private final Boolean incoming;

    private final Boolean outgoing;

    private final String communication;

    @JsonCreator
    public PortalState(
        @JsonProperty("signedon"     ) Boolean signedOn     ,
        @JsonProperty("incoming"     ) Boolean incoming     ,
        @JsonProperty("outgoing"     ) Boolean outgoing     ,
        @JsonProperty("communication") String  communication) {
        this.signedOn      = signedOn;
        this.incoming      = incoming;
        this.outgoing      = outgoing;
        this.communication = communication;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("signedon"     , signedOn     )
            .add("incoming"     , incoming     )
            .add("outgoing"     , outgoing     )
            .add("communication", communication)
            .toString();
    }
}
