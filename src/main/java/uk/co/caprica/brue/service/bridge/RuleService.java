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

import uk.co.caprica.brue.domain.bridge.Rule;
import uk.co.caprica.brue.domain.bridge.builder.RuleBuilder;
import uk.co.caprica.brue.domain.bridge.result.CreateResult;
import uk.co.caprica.brue.domain.bridge.result.UpdateResult;

public interface RuleService {

    Map<Integer,Rule> rules();

    Rule rule(Integer ruleId);

    CreateResult create(RuleBuilder rule);

    void delete(Integer ruleId);

    UpdateResult update(Integer ruleId, RuleBuilder rule);
}
