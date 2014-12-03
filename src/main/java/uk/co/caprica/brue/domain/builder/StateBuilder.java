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

import java.util.Arrays;

import uk.co.caprica.brue.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StateBuilder {

    @JsonProperty
    private Boolean on;

    @JsonProperty("brightness")
    private Integer brightness;

    @JsonProperty
    private Integer hue;

    @JsonProperty("saturation")
    private Integer saturation;

    @JsonProperty
    private Float[] xy;

    @JsonProperty
    private Integer ct;

    @JsonProperty
    private String alert;

    @JsonProperty
    private String effect;

    @JsonProperty("transitiontime")
    private Integer transitionTime;

    private StateBuilder() {
    }

    public static StateBuilder state() {
        return new StateBuilder();
    }

    public StateBuilder on(Boolean on) {
        this.on = on;
        return this;
    }

    public StateBuilder brightness(Integer brightness) {
        this.brightness = brightness;
        return this;
    }

    public StateBuilder hue(Integer hue) {
        this.hue = hue;
        return this;
    }

    public StateBuilder saturation(Integer saturation) {
        this.saturation = saturation;
        return this;
    }

    public StateBuilder xy(Float x, Float y) {
        this.xy = new Float[] {x, y};
        return this;
    }

    public StateBuilder ct(Integer ct) {
        this.ct = ct;
        return this;
    }

    public StateBuilder alert(String alert) {
        this.alert = alert;
        return this;
    }

    public StateBuilder effect(String effect) {
        this.effect = effect;
        return this;
    }

    // Actual transition time is a multiple of 100ms
    // so 10 is 1s (which is really a pain in the arse)

    /**
     * Set the transition time.
     *
     * @param transitionTime time value, a multiple of 100ms (e.g. a value of 10 is 1 second)
     * @return
     */
    public StateBuilder transitionTime(Integer transitionTime) {
        this.transitionTime = transitionTime;
        return this;
    }

    /**
     * Set the transition time (in seconds).
     *
     * @param transitionSeconds number of seconds
     * @return
     */
    public StateBuilder transitionSeconds(Integer transitionSeconds) {
        this.transitionTime = transitionSeconds * 10;
        return this;
    }

    /**
     * Set the transition time (in milliseconds).
     * <p>
     * The value will be truncated by integer division to a multiple of 100ms.
     *
     * @param transitionMillis
     * @return
     */
    public StateBuilder transitionMillis(Integer transitionMillis) {
        this.transitionTime = transitionMillis / 100;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("on"            , on                 )
            .add("brightness"    , brightness         )
            .add("hue"           , hue                )
            .add("saturation"    , saturation         )
            .add("xy"            , Arrays.toString(xy))
            .add("ct"            , ct                 )
            .add("alert"         , alert              )
            .add("effect"        , effect             )
            .add("transitionTime", transitionTime     )
            .toString();
    }
}
