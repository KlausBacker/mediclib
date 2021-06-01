package App.dao.Address;

import App.dao.AbstractDaoHibernate;
import App.model.Address;
import App.model.Patient;

public class AddressDaoHibernate extends AbstractDaoHibernate<Address> implements IAddressDAO {
    public AddressDaoHibernate() {
        super(Address.class);
    }
}
