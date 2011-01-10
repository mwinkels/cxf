/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.transport.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.transport.http.auth.HttpAuthHeader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpAuthHeaderTest {

    @Test
    public void testParse() {
        HttpAuthHeader authHeader = new HttpAuthHeader("Digest nonce=\"TUzZmQyYw==\", username=\"testUser\"");
        assertEquals("Digest", authHeader.getAuthType());
        Map<String, String> params = authHeader.getParams();
        Map<String, String> expectedParams = new HashMap<String, String>();
        expectedParams.put("username", "testUser");
        expectedParams.put("nonce", "TUzZmQyYw==");
        assertEquals(expectedParams, params);
    }
}
