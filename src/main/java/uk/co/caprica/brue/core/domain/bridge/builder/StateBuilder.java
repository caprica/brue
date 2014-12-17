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

import java.util.Arrays;

import uk.co.caprica.brue.core.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract class StateBuilder<T extends StateBuilder<T>> {

    @JsonProperty
    private Boolean on;

    @JsonProperty("bri")
    private Integer brightness;

    @JsonProperty
    private Integer hue;

    @JsonProperty("sat")
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

    protected StateBuilder() {
    }

    protected abstract T me();

    public T on(Boolean on) {
        this.on = on;
        return me();
    }

    public T brightness(Integer brightness) {
        this.brightness = brightness;
        return me();
    }

    public T hue(Integer hue) {
        this.hue = hue;
        return me();
    }

    public T saturation(Integer saturation) {
        this.saturation = saturation;
        return me();
    }

    public T xy(Float x, Float y) {
        this.xy = new Float[] {x, y};
        return me();
    }

    public T ct(Integer ct) {
        this.ct = ct;
        return me();
    }

    public T alert(String alert) {
        this.alert = alert;
        return me();
    }

    public T effect(String effect) {
        this.effect = effect;
        return me();
    }

    // Actual transition time is a multiple of 100ms
    // so 10 is 1s (which is really a pain in the arse)

    /**
     * Set the transition time.
     *
     * @param transitionTime time value, a multiple of 100ms (e.g. a value of 10 is 1 second)
     * @return
     */
    public T transitionTime(Integer transitionTime) {
        this.transitionTime = transitionTime;
        return me();
    }

    /**
     * Set the transition time (in seconds).
     *
     * @param transitionSeconds number of seconds
     * @return
     */
    public T transitionSeconds(Integer transitionSeconds) {
        this.transitionTime = transitionSeconds * 10;
        return me();
    }

    /**
     * Set the transition time (in milliseconds).
     * <p>
     * The value will be truncated by integer division to a multiple of 100ms.
     *
     * @param transitionMillis
     * @return
     */
    public T transitionMillis(Integer transitionMillis) {
        this.transitionTime = transitionMillis / 100;
        return me();
    }

    public final ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
            .add("on"            , on                 )
            .add("brightness"    , brightness         )
            .add("hue"           , hue                )
            .add("saturation"    , saturation         )
            .add("xy"            , Arrays.toString(xy))
            .add("ct"            , ct                 )
            .add("alert"         , alert              )
            .add("effect"        , effect             )
            .add("transitionTime", transitionTime     );
    }
}
