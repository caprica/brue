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

package uk.co.caprica.brue.core.domain.discovery;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;

@Immutable
@Root
public final class ServiceDescription {

    @Element(name="specVersion")
    private final SpecVersion specVersion;

    @Element(name="URLBase")
    private final String urlBase;

    @Element(name="device")
    private final Device device;

    public ServiceDescription(
        @Element(name="specVersion") SpecVersion specVersion,
        @Element(name="URLBase")     String      urlBase    ,
        @Element(name="device")      Device      device     ) {
        this.specVersion = specVersion;
        this.urlBase     = urlBase;
        this.device      = device;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("specVersion", specVersion)
            .add("urlBase"    , urlBase    )
            .add("device"     , device     )
            .toString();
    }
}
