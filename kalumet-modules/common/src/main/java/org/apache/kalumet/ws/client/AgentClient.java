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
package org.apache.kalumet.ws.client;

/**
 * WebService client dedicated to Kalumet agent operations.
 */
public class AgentClient
    extends AbstractClient
{

    /**
     * Default constructor.
     *
     * @param host the hostname or IP address of the Kalumet agent WS server.
     * @param port the port number of the Kalumet agent WS server.
     * @throws ClientException in case of connection failure.
     */
    public AgentClient( String host, int port )
        throws ClientException
    {
        super( "http://" + host + ":" + port + "/axis/services/AgentService" );
    }

    /**
     * Wrapper method to the get agent version.
     *
     * @return the agent version.
     * @throws ClientException in case of communication failure.
     */
    public String getVersion()
        throws ClientException
    {
        String version = null;
        try
        {
            version = (String) call.invoke( "getVersion", null );
        }
        catch ( Exception e )
        {
            throw new ClientException( "Can't get agent version", e );
        }
        return version;
    }

    // TODO update method to fully update an agent

}
