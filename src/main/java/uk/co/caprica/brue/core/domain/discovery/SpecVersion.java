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

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;

@Immutable
public final class SpecVersion {

    @Element(name="major")
    private final Integer major;

    @Element(name="minor")
    private final Integer minor;

    public SpecVersion(
        @Element(name="major") Integer major,
        @Element(name="minor") Integer minor) {
        this.major = major;
        this.minor = minor;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("major", major)
            .add("minor", minor)
            .toString();
    }
}
