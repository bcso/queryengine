/*
 * Copyright (C) 2012 SeqWare
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.seqware.queryengine.plugins;

import com.github.seqware.queryengine.plugins.plugins.FeatureFilter;

/**
 * Implements the generic queries which independently decide on whether a
 * Feature is included in a result. This kind of plugin is generic and allows
 * the implementor to specify an output format.
 *
 * @author dyuen
 * @version $Id: $Id
 */
public interface PrefilteredPlugin{

    /**
     * <p>getFilter.</p>
     *
     * @return a
     * {@link com.github.seqware.queryengine.plugins.inmemory.FeatureFilter}
     * object.
     */
    public abstract FeatureFilter getFilter();
}
