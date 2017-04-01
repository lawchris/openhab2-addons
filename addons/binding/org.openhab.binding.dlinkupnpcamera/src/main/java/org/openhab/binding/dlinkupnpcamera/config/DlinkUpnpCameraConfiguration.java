/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.dlinkupnpcamera.config;

import org.openhab.binding.dlinkupnpcamera.discovery.DlinkUpnpCameraDiscoveryParticipant;

/**
 * The {@link DlinkUpnpCameraDiscoveryParticipant} is responsible processing the
 * results of searches for UPNP devices
 *
 * @author Yacine Ndiaye
 * @author Antoine Blanc
 * @author Christopher Law
 */
public class DlinkUpnpCameraConfiguration {

    public static final String UDN = "udn";
    public static final String IP = "ip";
    public static final String NAME = "name";

    public String udn;
    public Integer refresh;

}
