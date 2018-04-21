package pages.admin;

import org.testng.Assert;
import pages.AbstractElementsContainer;
import pages.admin.common.LeftMenu;
import pages.admin.common.MenuItem;

public abstract class AbstractAdminPage extends AbstractElementsContainer{

    private LeftMenu leftMenu;

    public AbstractAdminPage(){
        leftMenu = new LeftMenu();
    }

    public MenuItem findItemByName(String name){
        leftMenu = new LeftMenu();
        return leftMenu.findItemByName(name);
    }

}
