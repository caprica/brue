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

package uk.co.caprica.brue.service;

import java.util.Map;

import uk.co.caprica.brue.domain.Group;
import uk.co.caprica.brue.domain.builder.GroupBuilder;
import uk.co.caprica.brue.domain.builder.StateBuilder;
import uk.co.caprica.brue.domain.result.CreateResult;
import uk.co.caprica.brue.domain.result.DeleteResult;
import uk.co.caprica.brue.domain.result.UpdateResult;

public interface GroupService {

    Map<Integer,Group> groups();

    Group group(Integer groupId);

    CreateResult create(GroupBuilder group);

    DeleteResult delete(Integer groupId);

    UpdateResult attributes(Integer groupId, GroupBuilder group);

    UpdateResult state(Integer groupId, StateBuilder state);
}