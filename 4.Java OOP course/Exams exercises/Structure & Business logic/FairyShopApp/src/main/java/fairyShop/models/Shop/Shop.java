package fairyShop.models.Shop;

import fairyShop.models.Helpers.Helper;
import fairyShop.models.Presents.Present;

public interface Shop {
    void craft(Present present, Helper helper);
}
