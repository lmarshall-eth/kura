/**
 * Copyright (c) 2011, 2014 Eurotech and/or its affiliates
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Eurotech
 */
package org.eclipse.kura.core.data.transport.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class MqttClientConfiguration {
	private String brokerUrl;
	private String clientId;
	private PersistenceType persistenceType;
	private MqttConnectOptions connectOptions;
	
	public enum PersistenceType {
		FILE,
		MEMORY
	};

	public MqttClientConfiguration(String brokerUrl, String clientId,
			PersistenceType persistenceType,
			MqttConnectOptions connectOptions) {
		super();
		this.brokerUrl = brokerUrl;
		this.clientId = clientId;
		this.persistenceType = persistenceType;
		this.connectOptions = connectOptions;
	}

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public String getClientId() {
		return clientId;
	}
	
	public PersistenceType getPersistenceType() {
		return this.persistenceType;
	}

	public MqttConnectOptions getConnectOptions() {
		return connectOptions;
	}
}
