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

import java.util.Map;

import uk.co.caprica.brue.domain.bridge.Schedule;
import uk.co.caprica.brue.domain.bridge.builder.ScheduleBuilder;
import uk.co.caprica.brue.domain.bridge.result.CreateResult;
import uk.co.caprica.brue.domain.bridge.result.UpdateResult;

public interface ScheduleService {

    Map<Long, Schedule> schedules();

    Schedule schedule(Integer scheduleId);

    CreateResult create(ScheduleBuilder schedule);

    void delete(Integer scheduleId);

    UpdateResult attributes(Integer scheduleId, ScheduleBuilder schedule);
}
