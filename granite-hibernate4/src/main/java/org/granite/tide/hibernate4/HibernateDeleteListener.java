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

package org.granite.tide.hibernate4;

import java.util.Set;

import org.granite.hibernate4.HibernateOptimisticLockException;
import org.hibernate.HibernateException;
import org.hibernate.StaleObjectStateException;
import org.hibernate.event.spi.DeleteEvent;
import org.hibernate.event.internal.DefaultDeleteEventListener;


public class HibernateDeleteListener extends DefaultDeleteEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void onDelete(DeleteEvent event) throws HibernateException {
		try {
			super.onDelete(event);
		}
		catch (StaleObjectStateException e) {
			HibernateOptimisticLockException.rethrowOptimisticLockException(event.getSession(), e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void onDelete(DeleteEvent event, Set transientEntities) throws HibernateException {
		try {
			super.onDelete(event, transientEntities);
		}
		catch (StaleObjectStateException e) {
			HibernateOptimisticLockException.rethrowOptimisticLockException(event.getSession(), e);
		}
	}
}
