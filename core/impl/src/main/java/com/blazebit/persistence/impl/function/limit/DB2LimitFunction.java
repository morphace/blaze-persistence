/*
 * Copyright 2015 Blazebit.
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
package com.blazebit.persistence.impl.function.limit;

/**
 *
 * @author Christian Beikov
 * @since 1.0.1
 */
public class DB2LimitFunction extends LimitFunction {

    public DB2LimitFunction() {
        super(
            "(?1 fetch first ?2 rows only)",
            // TODO: This is selecting the rownum too...
            "select * from ( select db2limit2_.*, rownumber() over(order by order of db2limit2_) as rownumber_ from ( ?1 fetch first ?2 rows only ) as db2limit2_ ) as db2limit1_ where rownumber_ > ?3 order by rownumber_"
        );
    }
    
}
