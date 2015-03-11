/*
 * 
 *               Panbox - encryption for cloud storage 
 *      Copyright (C) 2014-2015 by Fraunhofer SIT and Sirrix AG 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additonally, third party code may be provided with notices and open source
 * licenses from communities and third parties that govern the use of those
 * portions, and any licenses granted hereunder do not alter any rights and
 * obligations you may have under such open source licenses, however, the
 * disclaimer of warranty and limitation of liability provisions of the GPLv3 
 * will apply to all the product.
 * 
 */
package org.panbox.core.vfs.configs;

import java.util.ArrayList;
import java.util.List;

public abstract class VFSShareConfiguration {

	public enum ShareType { dropbox };

	protected final ShareType type;
	protected final String name;

	protected VFSShareConfiguration(ShareType type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ShareType getType() {
		return type;
	}

	public static String[] getShareTypes() {
		List<String> list = new ArrayList<String>();
		for (ShareType type : VFSShareConfiguration.ShareType.values()) {
			list.add(type.toString());
		}

		return list.toArray(new String[list.size()]);
	}
}
