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

package org.killbill.billing.jaxrs.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(value="NodeCommand")
public class NodeCommandJson {

    private final boolean isSystemCommandType;
    private final String nodeCommandType;
    private final List<NodeCommandPropertyJson> nodeCommandProperties;

    @JsonCreator
    public NodeCommandJson(@JsonProperty("isSystemCommandType") final boolean isSystemCommandType,
                           @JsonProperty("nodeCommandType") final String nodeCommandType,
                           @JsonProperty("nodeCommandProperties") final List<NodeCommandPropertyJson> nodeCommandProperties) {
        this.isSystemCommandType = isSystemCommandType;
        this.nodeCommandType = nodeCommandType;
        this.nodeCommandProperties = nodeCommandProperties;
    }

    @JsonProperty("isSystemCommandType")
    public boolean isSystemCommandType() {
        return isSystemCommandType;
    }

    public String getNodeCommandType() {
        return nodeCommandType;
    }

    public List<NodeCommandPropertyJson> getNodeCommandProperties() {
        return nodeCommandProperties;
    }
}
