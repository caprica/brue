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

package uk.co.caprica.brue.service.bridge;

import uk.co.caprica.brue.domain.bridge.builder.ConfigBuilder;
import uk.co.caprica.brue.domain.bridge.config.Config;
import uk.co.caprica.brue.domain.bridge.result.DeleteResult;
import uk.co.caprica.brue.domain.bridge.result.UpdateResult;


//  can automatically push the link button by setting config {"linkbutton": true})

/**
 *
 *
 * <strong>Be very careful, it is possible to leave the bridge in an inoperable state with bad configuration.</strong>
 */
public interface ConfigService {

    Config config();

    UpdateResult update(ConfigBuilder config);

    DeleteResult deleteUser(String username);
}
