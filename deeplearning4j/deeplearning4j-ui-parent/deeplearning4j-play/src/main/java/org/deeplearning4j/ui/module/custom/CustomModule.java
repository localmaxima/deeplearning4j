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
package org.deeplearning4j.ui.module.custom;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.api.storage.StatsStorageEvent;
import org.deeplearning4j.api.storage.StatsStorageListener;
import org.deeplearning4j.ui.api.FunctionType;
import org.deeplearning4j.ui.api.HttpMethod;
import org.deeplearning4j.ui.api.Route;
import org.deeplearning4j.ui.api.UIModule;
import org.deeplearning4j.ui.i18n.I18NResource;
import org.deeplearning4j.ui.module.train.TrainModule;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.CustomStatsStorage;
import org.deeplearning4j.ui.storage.InMemoryStatsStorage;
import org.deeplearning4j.ui.views.html.custom.test;
import org.nd4j.linalg.api.ops.impl.transforms.Log;


import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

@Slf4j
public class CustomModule extends TrainModule {

    String accuracy = null;

    public void setAccuracy(String accuracy) {
        log.info("Setting evaluation to value {}", accuracy);
        this.accuracy = accuracy;
    }



    @Override
    public List<Route> getRoutes() {
        Route r = new Route("/evaluation/evaluationoverview", HttpMethod.GET, FunctionType.Supplier,
                () -> ok(test.apply(getAccuracy())));
        return Collections.singletonList(r);
    }

    public String getAccuracy() {
        return  (accuracy == null)? "" : accuracy;

    }

    @Override
    public synchronized void reportStorageEvents(Collection<StatsStorageEvent> events) {
        super.reportStorageEvents(events);
        for (StatsStorageEvent sse : events) {
            log.info("statsstorage name {}",sse.getStatsStorage().getClass().getName());
            log.info("StatsListener.TYPE_ID.equals(sse.getTypeID()) {}",StatsListener.TYPE_ID.equals(sse.getTypeID()));
            log.info("sse.getStatsStorage() instanceof CustomStatsStorage {}",sse.getStatsStorage() instanceof CustomStatsStorage);
            if (StatsListener.TYPE_ID.equals(sse.getTypeID()) ) {
             if(sse.getStatsStorage() instanceof InMemoryStatsStorage){
                 try{
                     CustomStatsStorage customStatsStorage = (CustomStatsStorage)sse.getStatsStorage();
                     setAccuracy(customStatsStorage.getAccuracy());
                 }catch (Exception e){
                     log.error("Accuracy not set, cast failed!");
                     e.printStackTrace();
                 }


             }

            }
        }

    }



}
