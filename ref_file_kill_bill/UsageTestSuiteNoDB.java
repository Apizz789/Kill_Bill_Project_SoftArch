/*
 * Copyright 2010-2013 Ning, Inc.
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.usage;

import org.killbill.clock.ClockMock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.killbill.billing.GuicyKillbillTestSuiteNoDB;
import org.killbill.billing.usage.glue.TestUsageModuleNoDB;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class UsageTestSuiteNoDB extends GuicyKillbillTestSuiteNoDB {

    private final ClockMock clock;

    public UsageTestSuiteNoDB(final ClockMock clock) {
        this.clock = clock;
    }

    @BeforeClass(groups = "fast")
    protected void beforeClass() throws Exception {
        if (hasFailed()) {
            return;
        }

        final Injector injector = Guice.createInjector(new TestUsageModuleNoDB(configSource, clock));
        injector.injectMembers(this);
    }
}
