/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.deeplearning4j.ui.stats;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.deeplearning4j.api.storage.StatsStorageRouter;
import org.deeplearning4j.nn.api.Model;
import org.deeplearning4j.ui.stats.api.StatsReport;
import org.deeplearning4j.ui.stats.impl.CustomStatsReport;

/**
 * StatsListener: a general purpose listener for collecting and reporting system and model information.
 * <p>
 * Stats are collected and passed on to a {@link StatsStorageRouter} - for example, for storage and/or displaying in the UI,
 * use {@link org.deeplearning4j.ui.storage.InMemoryStatsStorage} or {@link org.deeplearning4j.ui.storage.FileStatsStorage}.
 *
 * @author Alex Black
 */
@Slf4j
public class CustomStatsListener extends StatsListener {

    @Setter
    @Getter
    String accuracy;

    StatsStorageRouter router;



    public CustomStatsListener(StatsStorageRouter router) {
        super(router);
        this.router = router;
    }



}
