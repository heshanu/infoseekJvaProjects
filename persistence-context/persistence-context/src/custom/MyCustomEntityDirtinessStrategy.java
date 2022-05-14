package custom;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.persister.entity.EntityPersister;

public class MyCustomEntityDirtinessStrategy implements CustomEntityDirtinessStrategy {

	@Override
	public boolean canDirtyCheck(Object entity, EntityPersister persister, Session session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirty(Object entity, EntityPersister persister, Session session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetDirty(Object entity, EntityPersister persister, Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findDirty(Object entity, EntityPersister persister, Session session, DirtyCheckContext dirtyCheckContext) {
		// TODO Auto-generated method stub
		
	}


}
