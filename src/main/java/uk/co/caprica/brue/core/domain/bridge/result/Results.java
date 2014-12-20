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

package uk.co.caprica.brue.core.domain.bridge.result;

import java.util.List;

import uk.co.caprica.brue.core.domain.Immutable;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

@Immutable
public final class Results {

    private final List<SuccessResult> successes;

    private final List<ErrorResult> errors;

    public Results(List<SuccessResult> successes, List<ErrorResult> errors) {
        this.successes = ImmutableList.copyOf(successes);
        this.errors = ImmutableList.copyOf(errors);
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    public int successCount() {
        return successes.size();
    }

    public int errorCount() {
        return errors.size();
    }

    public List<SuccessResult> successes() {
        return successes;
    }

    public List<ErrorResult> errors() {
        return errors;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("successes", successes)
            .add("errors", errors)
            .toString();
    }
}
