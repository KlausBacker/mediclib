package App.dao.MedSpeciality;

import App.dao.AbstractDaoHibernate;
import App.model.MedSpeciality;

public class MedSpecialitydaoHibernate extends AbstractDaoHibernate<MedSpeciality> implements IMedSpecialityDao {
    public MedSpecialitydaoHibernate(){
        super(MedSpeciality.class );
        }
}
