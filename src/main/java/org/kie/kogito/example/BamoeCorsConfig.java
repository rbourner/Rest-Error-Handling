// Copyright IBM Corp. 2025.
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.example;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
* Configures the {@link CorsFilter} that enables the Business Service handling requests from external applications.
* It is required to have it correctly configured to allow BAMOE Management Console interact with the Business Service.
*/
@Configuration
public class BamoeCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);

        // Explicitly setting the list of the supported origin patterns (required when setting Allow Credentials to true).
        // In all BAMOE examples BAMOE Management Console by default runs in port 8280 or 8380.
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("http://*:8080", "http://*:8280", "http://*:8380"));

        // Enabling all HTTP methods since BAMOE Management Console will make use of all of them for different purposes (POST, GET, PATCH, PUT, DELETE, OPTIONS)
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);

        // Path patterns where the cors configuration should be applied to. It's mandatory to include the endpoints for the different subsystems Processes, Tasks, Data-Index (graphql), Jobs...
        // For Simplicity this example enables all the paths.
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
