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

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

@Immutable
public final class Device {

    @Element(name="deviceType")
    private final String deviceType;

    @Element(name="friendlyName")
    private final String friendlyName;

    @Element(name="manufacturer")
    private final String manufacturer;

    @Element(name="manufacturerURL")
    private final String manufacturerUrl;

    @Element(name="modelDescription")
    private final String modelDescription;

    @Element(name="modelName")
    private final String modelName;

    @Element(name="modelNumber")
    private final String modelNumber;

    @Element(name="modelURL")
    private final String modelUrl;

    @Element(name="serialNumber")
    private final String serialNumber;

    @Element(name="UDN")
    private final String udn;

    @Element(name="presentationURL")
    private final String presentationUrl;

    @ElementList(entry="icon")
    private final List<Icon> iconList;

    public Device(
        @Element    (name="deviceType"            ) String     deviceType      ,
        @Element    (name="friendlyName"          ) String     friendlyName    ,
        @Element    (name="manufacturer"          ) String     manufacturer    ,
        @Element    (name="manufacturerURL"       ) String     manufacturerUrl ,
        @Element    (name="modelDescription"      ) String     modelDescription,
        @Element    (name="modelName"             ) String     modelName       ,
        @Element    (name="modelNumber"           ) String     modelNumber     ,
        @Element    (name="modelURL"              ) String     modelUrl        ,
        @Element    (name="serialNumber"          ) String     serialNumber    ,
        @Element    (name="UDN"                   ) String     udn             ,
        @Element    (name="presentationURL"       ) String     presentationUrl ,
        @ElementList(name="iconList", entry="icon") List<Icon> iconList        ) {
        this.deviceType       = deviceType;
        this.friendlyName     = friendlyName;
        this.manufacturer     = manufacturer;
        this.manufacturerUrl  = manufacturerUrl;
        this.modelDescription = modelDescription;
        this.modelName        = modelName;
        this.modelNumber      = modelNumber;
        this.modelUrl         = modelUrl;
        this.serialNumber     = serialNumber;
        this.udn              = udn;
        this.presentationUrl  = presentationUrl;
        this.iconList         = ImmutableList.copyOf(iconList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("deviceType"      , deviceType      )
            .add("friendlyName"    , friendlyName    )
            .add("manufacturer"    , manufacturer    )
            .add("manufacturerUrl" , manufacturerUrl )
            .add("modelDescription", modelDescription)
            .add("modelName"       , modelName       )
            .add("modelNumber"     , modelNumber     )
            .add("modelUrl"        , modelUrl        )
            .add("serialNumber"    , serialNumber    )
            .add("udn"             , udn             )
            .add("presentationUrl" , presentationUrl )
            .add("iconList"        , iconList        )
            .toString();
    }
}
