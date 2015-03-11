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
package org.panbox.desktop.common.gui.addressbook;

import org.panbox.Settings;

import javax.swing.*;
import java.awt.*;

public class ContactListCellRenderer implements ListCellRenderer<PanboxGUIContact> {

	public ContactListCellRenderer() {
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends PanboxGUIContact> list, PanboxGUIContact contact,
			int index, boolean isSelected, boolean cellHasFocus) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JLabel label;
		if (contact instanceof PanboxMyContact) {
			java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/panbox/desktop/common/gui/Messages", Settings.getInstance().getLocale()); // NOI18N
			label = new JLabel(bundle.getString("contactlist.my.identity"), contact.getIcon(), JLabel.LEFT);
		} else {
			label = new JLabel(contact.getFirstName() + " " + contact.getName(), contact.getIcon(), JLabel.LEFT);
		}
		label.setIconTextGap(10);
		panel.add(label);
		if (isSelected) {
			panel.setBackground(Color.LIGHT_GRAY);
		} else {
			panel.setBackground(Color.WHITE);
		}
		if (cellHasFocus) {
			panel.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 1, 2));
		} else {
			panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		}
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
}
