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
package org.apache.cxf.rs.security.oauth2.tokens.refresh;

import java.util.HashSet;
import java.util.Set;

import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.utils.OAuthConstants;
import org.apache.cxf.rs.security.oauth2.utils.OAuthUtils;

/**
 * Simple Refresh Token implementation
 */
public class RefreshToken extends ServerAccessToken {
    
    private Set<String> accessTokens = new HashSet<String>();
    
    public RefreshToken(Client client, 
                        long lifetime) {
        super(client, 
              OAuthConstants.REFRESH_TOKEN_TYPE, 
              OAuthUtils.generateRandomTokenKey(), 
              lifetime, 
              System.currentTimeMillis() / 1000);
    }
    
    public RefreshToken(Client client, 
                             String tokenKey,
                             long lifetime, 
                             long issuedAt) {
        super(client, 
              OAuthConstants.REFRESH_TOKEN_TYPE, 
              tokenKey, 
              lifetime, 
              issuedAt);
    }

    public Set<String> getAccessTokens() {
        return accessTokens;
    }

    public void setAccessTokens(Set<String> accessTokens) {
        this.accessTokens = accessTokens;
    }
    
    public void addAccessToken(String token) {
        accessTokens.add(token);
    }
    
    public boolean removeAccessToken(String token) {
        return accessTokens.remove(token);
    }
}