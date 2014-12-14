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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigBuilder {

    @JsonProperty
    private String name;

    @JsonProperty
    private Boolean dhcp;

    @JsonProperty("ipaddress")
    private String ipAddress;

    @JsonProperty
    private String netmask;

    @JsonProperty
    private String gateway;

    @JsonProperty("proxyaddress")
    private String proxyAddress;

    @JsonProperty("proxyport")
    private Integer proxyPort;

    @JsonProperty("linkbutton")
    private Boolean linkButton;

    @JsonProperty("swupdate")
    private UpdateBuilder swUpdate;

    public static ConfigBuilder config() {
        return new ConfigBuilder();
    }

    private ConfigBuilder() {
    }

    public ConfigBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ConfigBuilder dhcp(Boolean dhcp) {
        this.dhcp = dhcp;
        return this;
    }

    public ConfigBuilder ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public ConfigBuilder netmask(String netmask) {
        this.netmask = netmask;
        return this;
    }

    public ConfigBuilder gateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public ConfigBuilder proxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
        return this;
    }

    public ConfigBuilder proxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }

    public ConfigBuilder linkButton(Boolean linkButton) {
        this.linkButton = linkButton;
        return this;
    }

    public ConfigBuilder update(UpdateBuilder update) {
        this.swUpdate = update;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"        , name        )
            .add("dhcp"        , dhcp        )
            .add("ipAddress"   , ipAddress   )
            .add("netmask"     , netmask     )
            .add("gateway"     , gateway     )
            .add("proxyAddress", proxyAddress)
            .add("proxyPort"   , proxyPort   )
            .add("linkButton"  , linkButton  )
            .add("swUpdate"    , swUpdate    )
            .toString();
    }
}
