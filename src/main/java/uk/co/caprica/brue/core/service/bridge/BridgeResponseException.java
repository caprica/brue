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

package uk.co.caprica.brue.core.service.bridge;

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;

@Immutable
public final class BridgeResponseException extends RuntimeException {

    private final int code;

    private final String message;

    public BridgeResponseException(int code, String message) {
        super(message);
        this.code    = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("code"   , code   )
            .add("message", message)
            .toString();
    }
}
