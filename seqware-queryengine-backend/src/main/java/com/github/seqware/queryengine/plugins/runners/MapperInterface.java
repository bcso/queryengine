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
package com.github.seqware.queryengine.plugins.runners;


/**
 * This wraps the Hadoop context object, allowing us to hopefully cleanly transfer
 * our plugins to some other MapReduce-like framework.
 * 
 * @author dyuen
 */
public interface MapperInterface<KEYOUT, VALUEOUT> extends JobRunParameterInterface {

    /**
     * Emit keys and values for passing onto the reducer
     * @param textKey
     * @param text 
     */
    public void write(KEYOUT textKey, VALUEOUT text);

    /**
     * Counter enumeration to count the actual rows.
     */
    public static enum Counters {

        ROWS
    }

    /**
     * Increment the row counter
     */
    public void incrementCounter();
    

}
