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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import uk.co.caprica.brue.core.domain.Mutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@Mutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RuleBuilder {

    @JsonProperty
    private String name;

    @JsonProperty
    private List<ConditionBuilder> conditions;

    @JsonProperty
    private List<CommandBuilder> actions;

    public static RuleBuilder rule() {
        return new RuleBuilder();
    }

    private RuleBuilder() {
    }

    public RuleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RuleBuilder conditions(Collection<ConditionBuilder> conditions) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<>(conditions);
        }
        else {
            this.conditions.addAll(conditions);
        }
        return this;
    }

    public RuleBuilder conditions(ConditionBuilder... conditions) {
        return conditions(Arrays.asList(conditions));
    }

    public RuleBuilder actions(Collection<CommandBuilder> actions) {
        if (this.actions == null) {
            this.actions = new ArrayList<>(actions);
        }
        else {
            this.actions.addAll(actions);
        }
        return this;
    }

    public RuleBuilder actions(CommandBuilder... actions) {
        return actions(Arrays.asList(actions));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name"         , name         )
            .add("conditions"   , conditions   )
            .add("actions"      , actions      )
            .toString();
    }
}
