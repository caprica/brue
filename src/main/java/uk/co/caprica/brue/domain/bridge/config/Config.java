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

package uk.co.caprica.brue.domain.bridge.config;

import java.util.Map;

import uk.co.caprica.brue.domain.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

@Immutable
@JsonIgnoreProperties(ignoreUnknown=true)
public final class Config {

    private final String name;

    private final Update swUpdate;

    private final Map<String,User> whitelist;

    private final String apiVersion;

    private final String swVersion;

    private final String proxyAddress;

    private final Integer proxyPort;

    private final Boolean linkButton;

    private final String ipAddress;

    private final String mac;

    private final String netmask;

    private final String gateway;

    private final Boolean dhcp;

    private final Boolean portalServices;

    private final String portalConnection;

    private final PortalState portalState;

    private final String UTC;

    private final String localtime;

    private final String timezone;

    private final Integer zigbeeChannel;

    @JsonCreator
    public Config(
        @JsonProperty(value="name"            ) String            name            ,
        @JsonProperty(value="swupdate"        ) Update            swUpdate,
        @JsonProperty(value="whitelist"       ) Map<String, User> whitelist       ,
        @JsonProperty(value="apiversion"      ) String            apiVersion      ,
        @JsonProperty(value="swversion"       ) String            swVersion       ,
        @JsonProperty(value="proxyaddress"    ) String            proxyAddress    ,
        @JsonProperty(value="proxyport"       ) Integer           proxyPort       ,
        @JsonProperty(value="linkbutton"      ) Boolean           linkButton      ,
        @JsonProperty(value="ipaddress"       ) String            ipAddress       ,
        @JsonProperty(value="mac"             ) String            mac             ,
        @JsonProperty(value="netmask"         ) String            netmask         ,
        @JsonProperty(value="gateway"         ) String            gateway         ,
        @JsonProperty(value="dhcp"            ) Boolean           dhcp            ,
        @JsonProperty(value="portalservices"  ) Boolean           portalServices  ,
        @JsonProperty(value="portalconnection") String            portalConnection,
        @JsonProperty(value="portalstate"     ) PortalState       portalState     ,
        @JsonProperty(value="utc"             ) String            utc             ,
        @JsonProperty(value="localtime"       ) String            localtime       ,
        @JsonProperty(value="timezone"        ) String            timezone        ,
        @JsonProperty(value="zigbeechannel"   ) Integer           zigbeeChannel) {
        this.name             = name;
        this.swUpdate         = swUpdate;
        this.whitelist        = ImmutableMap.copyOf(whitelist);
        this.apiVersion       = apiVersion;
        this.swVersion        = swVersion;
        this.proxyAddress     = proxyAddress;
        this.proxyPort        = proxyPort;
        this.linkButton       = linkButton;
        this.ipAddress        = ipAddress;
        this.mac              = mac;
        this.netmask          = netmask;
        this.gateway          = gateway;
        this.dhcp             = dhcp;
        this.portalServices   = portalServices;
        this.portalConnection = portalConnection;
        this.portalState      = portalState;
        this.UTC              = utc;
        this.localtime        = localtime;
        this.timezone         = timezone;
        this.zigbeeChannel    = zigbeeChannel;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"            , name            )
            .add("swUpdate"        , swUpdate        )
            .add("whitelist"       , whitelist       )
            .add("apiVersion"      , apiVersion      )
            .add("swVersion"       , swVersion       )
            .add("proxyAddress"    , proxyAddress    )
            .add("proxyPort"       , proxyPort       )
            .add("linkButton"      , linkButton      )
            .add("ipAddress"       , ipAddress       )
            .add("mac"             , mac             )
            .add("netMask"         , netmask         )
            .add("gateway"         , gateway         )
            .add("dhcp"            , dhcp            )
            .add("portalServices"  , portalServices  )
            .add("portalConnection", portalConnection)
            .add("portalState"     , portalState     )
            .add("utc"             , UTC             )
            .add("localTime"       , localtime       )
            .add("timeZone"        , timezone        )
            .add("zigbeeChannel"   , zigbeeChannel   )
            .toString();
    }
}
