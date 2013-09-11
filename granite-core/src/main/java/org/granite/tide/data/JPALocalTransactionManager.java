/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2013 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of Granite Data Services.
 *
 *   Granite Data Services is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or (at your
 *   option) any later version.
 *
 *   Granite Data Services is distributed in the hope that it will be useful, but
 *   WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *   FITNESS FOR A PARTICULAR PURPOSE. See the GNU Library General Public License
 *   for more details.
 *
 *   You should have received a copy of the GNU Library General Public License
 *   along with this library; if not, see <http://www.gnu.org/licenses/>.
 */

package org.granite.tide.data;

import javax.persistence.EntityTransaction;

import org.granite.tide.TideTransactionManager;


/**
 * Responsible for attaching a entity with the entity mangager
 * @author cingram
 *
 */
public class JPALocalTransactionManager implements TideTransactionManager {
	
	public Object begin(TideTransactionPersistenceManager pm) {
		if (pm != null)
			return pm.getCurrentTransaction();
		return null;
	}
	
	public void commit(Object tx) throws Exception {
        ((EntityTransaction)tx).commit();
	}
	
	public void rollback(Object tx) {
        ((EntityTransaction)tx).rollback();
	}
}
