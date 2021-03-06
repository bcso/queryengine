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
package com.github.seqware.queryengine.plugins.plugins;

import com.github.seqware.queryengine.plugins.PrefilteredPlugin;
import com.github.seqware.queryengine.plugins.MapReducePlugin;

/**
 * Implements the generic queries which independently decide on whether a
 * Feature is included in a result. 
 *
 * @author dyuen
 * @version $Id: $Id
 */
public abstract class PrefilterByAttributesPlugin<MAPREDUCEKEY, MAPREDUCEVALUE, REDUCEKEYOUT, REDUCEVALUEOUT>
extends MapReducePlugin<MAPREDUCEKEY, MAPREDUCEVALUE, REDUCEKEYOUT, REDUCEVALUEOUT> implements PrefilteredPlugin{


    /**
     * <p>getFilter.</p>
     *
     * @return a
     * {@link com.github.seqware.queryengine.plugins.inmemory.FeatureFilter}
     * object.
     */
    @Override
    public FeatureFilter getFilter(){
        return new FeaturesByAttributesPlugin.FeaturesByAttributesFilter();
    }
}
