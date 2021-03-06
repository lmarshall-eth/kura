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
package org.eclipse.kura.net.wifi;

import java.util.Arrays;

import org.eclipse.kura.configuration.Password;
import org.eclipse.kura.net.NetConfig;

/**
 * Configuration for a wifi interface based on IPv4 addresses.
 */
public class WifiConfig implements NetConfig {

	/** Mode for the configuration **/
	private WifiMode m_mode;
	
	/** SSID of the the wifi interface **/
	private String m_ssid;
	
	/** Channel(s) supported by the wifi interface **/
	private int[] m_channels;
	
	/** Security mode of the interface **/
	private WifiSecurity m_security;
	
	/** Supported pairwise ciphers **/
	private WifiCiphers m_pairwiseCiphers;
	
	/** Supported group ciphers **/
	private WifiCiphers m_groupCiphers;
	
	/** The passkey for the wifi interface **/
	private Password m_passkey;
	
	/** The hardware mode **/
	private String m_hwMode;
	
	/** Radio mode **/
	private WifiRadioMode m_radioMode;
	
	/** Whether or not to broadcast the SSID **/
	private boolean m_broadcast;
	
	/** Background scan **/
	private WifiBgscan m_bgscan;
	
	/** Ping Access Point **/
	private boolean m_pingAccessPoint = false;
	
	/** Ignore SSID **/
	private boolean m_ignoreSSID;
	
	/** The driver of the wifi interface **/
	private String m_driver;
	
	public WifiConfig() {
		super();
	}
	
	public WifiConfig(WifiMode mode, String ssid, int[] channels,
			WifiSecurity security, String passkey, String hwMode,
			boolean broadcast, WifiBgscan bgscan) {
		super();
		
		this.m_mode = mode;
		this.m_ssid = ssid;
		this.m_channels = channels;
		this.m_security = security;
		this.m_passkey = new Password(passkey);
		this.m_hwMode = hwMode;
		this.m_broadcast = broadcast;
		this.m_bgscan = bgscan;
	}
	
	public WifiMode getMode() {
		return this.m_mode;
	}
	
	public void setMode(WifiMode mode) {
		this.m_mode = mode;
	}
	
	public String getSSID() {
		return this.m_ssid;
	}
	
	public void setSSID(String ssid) {
		this.m_ssid = ssid;
	}
	
	public String getDriver() {
	    return this.m_driver;
	}
	
	public void setDriver(String driver) {
	    this.m_driver = driver;
	}
	
	public int[] getChannels() {
		return this.m_channels;
	}
	
	public void setChannels(int[] channels) {
		this.m_channels = channels;
	}
	
	public WifiSecurity getSecurity() {
		return this.m_security;
	}
	
	public void setSecurity(WifiSecurity security) {
		this.m_security = security;
	}
	
	public WifiCiphers getPairwiseCiphers() {
		return this.m_pairwiseCiphers;
	}
	
	public void setPairwiseCiphers(WifiCiphers pairwise) {
		this.m_pairwiseCiphers = pairwise;
	}
	
	public WifiCiphers getGroupCiphers() {
		return this.m_groupCiphers;
	}
	
	public void setGroupCiphers(WifiCiphers group) {
		this.m_groupCiphers = group;
	}
	
	public Password getPasskey() {
		return this.m_passkey;
	}
	
	public void setPasskey(String key) {
		Password psswd= new Password(key);
		this.m_passkey = psswd;
	}
	
	public String getHardwareMode() {
		return this.m_hwMode;
	}
	
	public void setHardwareMode(String hwMode) {
		this.m_hwMode = hwMode;
	}
	
	public WifiRadioMode getRadioMode() {
		return this.m_radioMode;
	}
	
	public void setRadioMode(WifiRadioMode radioMode) {
		this.m_radioMode = radioMode;
	}
	
	public boolean getBroadcast() {
		return this.m_broadcast;
	}
	
	public void setBroadcast(boolean broadcast) {
		this.m_broadcast = broadcast;
	}
	
	public WifiBgscan getBgscan() {
		return m_bgscan;
	}

	public void setBgscan(WifiBgscan m_bgscan) {
		this.m_bgscan = m_bgscan;
	}
	
	public boolean pingAccessPoint() {
		return this.m_pingAccessPoint;
	}
	
	public void setPingAccessPoint(boolean pingAP) {
		this.m_pingAccessPoint = pingAP;
	}
	
	public boolean ignoreSSID() {
		return m_ignoreSSID;
	}
	
	public void setIgnoreSSID(boolean ignoreSSID) {
		m_ignoreSSID = ignoreSSID;
	}

	@Override
	public int hashCode() {
		final int prime = 29;
		int result = super.hashCode();
		
		result = prime * result
				+ ((m_mode == null) ? 0 : m_mode.hashCode());
        result = prime * result
                + ((m_ssid == null) ? 0 : m_ssid.hashCode());
		result = prime * result
				+ ((m_driver == null) ? 0 : m_driver.hashCode());
		
		if (m_channels != null) {
			for (int channel : m_channels) {
				result = prime * result + channel;
			}
		} else {
			result = prime * result;
		}
		
		result = prime * result
				+ ((m_security == null) ? 0 : m_security.hashCode());
		result = prime * result
				+ ((m_passkey == null) ? 0 : m_passkey.hashCode());
        result = prime * result
                + ((m_hwMode == null) ? 0 : m_hwMode.hashCode());
		result = prime * result
				+ ((m_radioMode == null) ? 0 : m_radioMode.hashCode());
		result = prime * result
				+ ((m_broadcast) ? 1021 : 1031);
		
		result = prime
				* result
				+ ((m_pairwiseCiphers == null) ? 0 : WifiCiphers
						.getCode(m_pairwiseCiphers));
		
		result = prime
				* result
				+ ((m_groupCiphers == null) ? 0 : WifiCiphers
						.getCode(m_groupCiphers));
		
		if (m_bgscan != null) {

			result = prime
					* result
					+ ((m_bgscan.getModule() == null) ? 0 : WifiBgscanModule
							.getCode(m_bgscan.getModule()));

			result = prime * result + m_bgscan.getRssiThreshold();

			result = prime * result + m_bgscan.getShortInterval();

			result = prime * result + m_bgscan.getLongInterval();
		} else {
			result = prime * result;
		}
		
		result = prime * result + (m_pingAccessPoint? 1 : 0);
		
		result = prime * result + (m_ignoreSSID? 1 : 0);
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
        if(!(obj instanceof WifiConfig)) {
            return false;
        }
		
		WifiConfig other = (WifiConfig)obj;
		
		if(!compare(this.m_mode, other.m_mode)) {
		    return false;
		}
        if(!compare(this.m_ssid, other.m_ssid)) {
            return false;
        }
        if(!compare(this.m_driver, other.m_driver)) {
            return false;
        }
		if (!Arrays.equals(this.m_channels, other.m_channels)) {
			return false;
		}
        if(!compare(this.m_security, other.m_security)) {
            return false;
        }
        if(!compare(this.m_pairwiseCiphers, other.m_pairwiseCiphers)) {
            return false;
        }
        if(!compare(this.m_groupCiphers, other.m_groupCiphers)) {
            return false;
        }
        if(!compare(this.m_passkey, other.m_passkey)) {
            return false;
        }
        if(!compare(this.m_hwMode, other.m_hwMode)) {
            return false;
        }
        if(!compare(this.m_radioMode, other.m_radioMode)) {
            return false;
        }
        if(!compare(this.m_bgscan, other.m_bgscan)) {
            return false;
        }
		if (this.m_broadcast != other.m_broadcast) {
			return false;
		}
		if (this.m_pingAccessPoint != other.pingAccessPoint()) {
			return false;
		}
		if (this.m_ignoreSSID != other.ignoreSSID()) {
			return false;
		}
		
		return true;
	}
	
	private boolean compare(Object obj1, Object obj2) {
        return (obj1 == null) ? (obj2 == null) : (obj1.equals(obj2));
	}
	
	@Override
	public boolean isValid() {
		return (this.m_mode != null)? true : false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("WifiConfig [");
		if(m_mode != null) {
			sb.append("mode: ")
			.append(m_mode)
			.append(" :: ");
		}
        if(m_ssid != null) {
            sb.append("ssid: ")
            .append(m_ssid)
            .append(" :: ");
        }
        sb.append ("ignoreSSID: ")
        	.append(m_ignoreSSID)
        	.append(" :: ");
        
		if(m_driver != null) {
			sb.append("driver: ")
			.append(m_driver)
			.append(" :: ");
		}
		if(m_channels != null && m_channels.length > 0) {
			sb.append("channels: ");
			for(int i=0; i<m_channels.length; i++) {
				sb.append(m_channels[i]);
				if(i+i < m_channels.length) {
					sb.append(",");
				}
			}
			sb.append(" :: ");
		}
		if(m_security != null) {
			sb.append("security: ")
			.append(m_security)
			.append(" :: ");
		}
		if(m_pairwiseCiphers != null) {
			sb.append("pairwiseCiphers: ")
			.append(m_pairwiseCiphers)
			.append(" :: ");
		}
		if(m_groupCiphers != null) {
			sb.append("groupCiphers: ")
			.append(m_groupCiphers)
			.append(" :: ");
		}
		if(m_passkey != null) {
			sb.append("passkey: ")
			.append(m_passkey)
			.append(" :: ");
		}
        if(m_hwMode != null) {
            sb.append("hwMode: ")
            .append(m_hwMode)
            .append(" :: ");
        }
		if(m_radioMode != null) {
			sb.append("radioMode: ")
			.append(m_radioMode)
			.append(" :: ");
		}
		sb.append("broadcast: ")
		.append(m_broadcast)
		.append(" :: ");
		if(m_bgscan != null) {
			sb.append("bgscan: ")
			.append(m_bgscan);
		}
		
		sb.append("]");		
		return sb.toString();
	}
}
