/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
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

package org.killbill.billing.entitlement.api;

import java.util.List;

import org.killbill.billing.catalog.api.PlanPhasePriceOverride;
import org.killbill.billing.catalog.api.PlanPhaseSpecifier;

public class DefaultEntitlementSpecifier implements EntitlementSpecifier {

    private final PlanPhaseSpecifier planPhaseSpecifier;
    private final List<PlanPhasePriceOverride> overrides;
    private final Integer billCycleDay;
    private final String externalKey;

    public DefaultEntitlementSpecifier(final PlanPhaseSpecifier planPhaseSpecifier) {
        this(planPhaseSpecifier, null, null, null);
    }

    public DefaultEntitlementSpecifier(final PlanPhaseSpecifier planPhaseSpecifier, final Integer billCycleDay, final String externalKey, final List<PlanPhasePriceOverride> overrides) {
        this.planPhaseSpecifier = planPhaseSpecifier;
        this.externalKey = externalKey;
        this.billCycleDay = billCycleDay;
        this.overrides = overrides;
    }

    @Override
    public PlanPhaseSpecifier getPlanPhaseSpecifier() {
        return planPhaseSpecifier;
    }

    @Override
    public Integer getBillCycleDay() {
        return billCycleDay;
    }

    @Override
    public String getExternalKey() {
        return externalKey;
    }

    @Override
    public List<PlanPhasePriceOverride> getOverrides() {
        return overrides;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultEntitlementSpecifier{");
        sb.append("planName=").append(planPhaseSpecifier.getPlanName());
        sb.append(", productName=").append(planPhaseSpecifier.getProductName());
        sb.append(", billingPeriod=").append(planPhaseSpecifier.getBillingPeriod());
        sb.append(", phaseType=").append(planPhaseSpecifier.getPhaseType());
        sb.append(", priceListName=").append(planPhaseSpecifier.getPriceListName());
        sb.append(", billCycleDay=").append(billCycleDay);
        sb.append(", externalKey=").append(externalKey);
        sb.append(", overrides=").append(overrides);
        sb.append('}');
        return sb.toString();
    }
}
