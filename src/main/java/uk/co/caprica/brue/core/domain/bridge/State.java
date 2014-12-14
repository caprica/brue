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

import java.util.Arrays;

import uk.co.caprica.brue.core.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class State {

    private final Boolean on;

    private final Integer brightness;

    private final Integer hue;

    private final Integer saturation;

    private final Float[] xy;

    private final Integer ct;

    private final String alert;

    private final String effect;

    private final String colorMode;

    private final Boolean reachable;

    @JsonCreator
    public State(
        @JsonProperty("on"       ) Boolean on        ,
        @JsonProperty("bri"      ) Integer brightness,
        @JsonProperty("hue"      ) Integer hue       ,
        @JsonProperty("sat"      ) Integer saturation,
        @JsonProperty("xy"       ) Float[] xy        ,
        @JsonProperty("ct"       ) Integer ct        ,
        @JsonProperty("alert"    ) String  alert     ,
        @JsonProperty("effect"   ) String  effect    ,
        @JsonProperty("colormode") String  colorMode ,
        @JsonProperty("reachable") Boolean reachable ) {
        this.on         = on;
        this.brightness = brightness;
        this.hue        = hue;
        this.saturation = saturation;
        this.xy         = xy != null ? Arrays.copyOf(xy, 2) : null;
        this.ct         = ct;
        this.alert      = alert;
        this.effect     = effect;
        this.colorMode  = colorMode;
        this.reachable  = reachable;
    }

    public Boolean on() {
        return on;
    }

    public Integer brightness() {
        return brightness;
    }

    public Integer hue() {
        return hue;
    }

    public Integer saturation() {
        return saturation;
    }

    public Float[] xy() {
        return xy != null ? Arrays.copyOf(xy, 2) : null;
    }

    public Integer ct() {
        return ct;
    }

    public String alert() {
        return alert;
    }

    public String effect() {
        return effect;
    }

    public String colorMode() {
        return colorMode;
    }

    public Boolean reachable() {
        return reachable;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("on"        , on                 )
            .add("brightness", brightness         )
            .add("hue"       , hue                )
            .add("saturation", saturation         )
            .add("xy"        , Arrays.toString(xy))
            .add("ct"        , ct                 )
            .add("alert"     , alert              )
            .add("effect"    , effect             )
            .add("colorMode" , colorMode          )
            .add("reachable" , reachable          )
            .toString();
    }
}
