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

import com.github.seqware.queryengine.model.Feature;
import com.github.seqware.queryengine.model.FeatureSet;

/**
 * Interface for matching functions that we can quickly use in both in-memory and M/R plug-ins.
 *
 * @author dyuen
 * @version $Id: $Id
 */
public interface FeatureFilter {
    
    /**
     * <p>featurePasses.</p>
     *
     * @param set the value of set
     * @param f a {@link com.github.seqware.queryengine.model.Feature} object.
     * @param parameters a {@link java.lang.Object} object.
     * @return a boolean.
     */
    
    public boolean featurePasses(FeatureSet set, Feature f, Object... parameters);
    
}
