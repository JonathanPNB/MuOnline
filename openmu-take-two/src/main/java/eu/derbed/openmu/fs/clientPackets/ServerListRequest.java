/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.derbed.openmu.fs.clientPackets;


import eu.derbed.openmu.fs.ClientBasePacket;
import eu.derbed.openmu.fs.FriendTheard;

/**
 * 
 * @author mikiones
 */
public class ServerListRequest extends ClientBasePacket {

	public ServerListRequest(byte[] data, FriendTheard _friend) {
		super(data);
		System.out.println("CS:> Request server list");
	}

}
