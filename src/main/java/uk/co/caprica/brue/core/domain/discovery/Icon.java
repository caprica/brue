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
public final class Icon {

    @Element(name="mimetype")
    private final String mimetype;

    @Element(name="height")
    private final Integer height;

    @Element(name="width")
    private final Integer width;

    @Element(name="depth")
    private final Integer depth;

    @Element(name="url")
    private final String url;

    public Icon(
        @Element(name="mimetype") String  mimetype,
        @Element(name="height"  ) Integer height  ,
        @Element(name="width"   ) Integer width   ,
        @Element(name="depth"   ) Integer depth   ,
        @Element(name="url"     ) String  url     ) {
        this.mimetype = mimetype;
        this.height   = height;
        this.width    = width;
        this.depth    = depth;
        this.url      = url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("mimetype", mimetype)
            .add("height"  , height  )
            .add("width"   , width   )
            .add("depth"   , depth   )
            .add("url"     , url     )
            .toString();
    }
}
