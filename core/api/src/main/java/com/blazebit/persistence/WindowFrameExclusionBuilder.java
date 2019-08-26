/*
 * Copyright 2014 - 2019 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.persistence;

/**
 * An interface for building a window frame exclusion clause for analytics functions.
 *
 * @param <T> The builder return type
 * @author Christian Beikov
 * @since 1.4.0
 */
public interface WindowFrameExclusionBuilder<T> {

    /**
     * Finishes the window builder.
     *
     * @return The parent query builder
     */
    T excludeNoOthers();

    /**
     * Finishes the window builder.
     *
     * @return The parent query builder
     */
    T excludeCurrentRow();

    /**
     * Finishes the window builder.
     *
     * @return The parent query builder
     */
    T excludeGroup();

    /**
     * Finishes the window builder.
     *
     * @return The parent query builder
     */
    T excludeTies();

    /**
     * Synonym for {@link #excludeNoOthers()}.
     *
     * @return The parent query builder
     */
    public T end();
}
