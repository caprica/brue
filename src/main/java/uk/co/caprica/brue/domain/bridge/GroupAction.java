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

package uk.co.caprica.brue.domain.bridge;

import java.util.Arrays;

import uk.co.caprica.brue.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class GroupAction {

    private final Boolean on;

    private final Integer brightness;

    private final Integer hue;

    private final Integer saturation;

    private final Integer ct;

    private final Float[] xy;

    private final String effect;

    private final String colorMode;

    @JsonCreator
    public GroupAction(
        @JsonProperty("on")        Boolean on        ,
        @JsonProperty("bri")       Integer brightness,
        @JsonProperty("hue")       Integer hue       ,
        @JsonProperty("sat")       Integer saturation,
        @JsonProperty("ct")        Integer ct        ,
        @JsonProperty("xy")        Float[] xy        ,
        @JsonProperty("effect")    String effect     ,
        @JsonProperty("colormode") String colorMode  ) {
        this.on         = on;
        this.brightness = brightness;
        this.hue        = hue;
        this.saturation = saturation;
        this.ct         = ct;
        this.xy         = xy != null ? Arrays.copyOf(xy, 2) : null;
        this.effect     = effect;
        this.colorMode  = colorMode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("on"        , on                 )
            .add("brightness", brightness         )
            .add("hue"       , hue                )
            .add("saturation", saturation         )
            .add("ct"        , ct                 )
            .add("xy"        , Arrays.toString(xy))
            .add("effect"    , effect             )
            .add("colorMode" , colorMode          )
            .toString();
    }
}
