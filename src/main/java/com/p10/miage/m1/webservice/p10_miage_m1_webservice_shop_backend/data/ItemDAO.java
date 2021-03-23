package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemDAO implements DAO<Item> {

    private static final AtomicInteger idCounter = new AtomicInteger();
    private static final Map<Integer, Item> data = new HashMap<>();
    private static ItemDAO instance;

    static {
        data.put(idCounter.getAndIncrement(), new Item("XPS 13", "Dell", "pc-portable", 1500, "https://i.dell.com/is/image/DellContent//content/dam/global-site-design/product_images/dell_client_products/notebooks/xps_notebooks/xps_13_7390/general/111-xps-product-imagery-notebook-xps-13-7390-4000x4000-campaign.jpg?fmt=pjpg&pscan=auto&scl=1&hei=402&wid=644&qlt=85,0&resMode=sharp2&op_usm=1.75,0.3,2,0&size=644,402"));
        data.put(idCounter.getAndIncrement(), new Item("Blade Stealth 13", "Razer", "pc-portable", 2000, "https://assets3.razerzone.com/i6Blkk6mtq6R4F-IEG8wyHOumVA=/1500x1000/https%3A%2F%2Fhybrismediaprod.blob.core.windows.net%2Fsys-master-phoenix-images-container%2Fh57%2Fh3b%2F9090938077214%2Frazer-blade-stealth-13-gallery-01.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("iMac", "Apple", "pc-bureau", 3000, "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/imac-og-202008?wid=600&hei=315&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1594849639000"));
        data.put(idCounter.getAndIncrement(), new Item("Cable USB - USB-C", "RAMPOW", "pc-accessoire", 15, "https://images-na.ssl-images-amazon.com/images/I/71uN-pwbusL._AC_SX679_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Disque Dur WD Elements 1TB", "WD Elements", "stock-dd", 50, "https://static.fnac-static.com/multimedia/Images/A5/A5/3A/66/418725-1505-1540-1/tsp20210224130514/Disque-Dur-WD-Elements-2-To-Noir.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Clé USB SanDisk 128Go", "SandDisk", "stock-usb", 40, "https://static.fnac-static.com/multimedia/Images/FR/MDM/ee/6f/2f/3108846/1540-1/tsp20200718130428/Cle-USB-2-0-Sandisk-Cruzer-Blade-128-Go.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("iPhone 12", "Apple", "tel-smartphones", 949, "https://images-na.ssl-images-amazon.com/images/I/71ZOtNdaZCL._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Galaxy M11", "Samsung", "tel-smartphones", 159, "https://images-na.ssl-images-amazon.com/images/I/71QwUqqdGIL._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Redmi Note 9", "Xiaomi", "tel-smartphones", 150, "https://images-na.ssl-images-amazon.com/images/I/612rtTjNMGL._AC_SL1000_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("F530", "Alcatel", "tel-fixes", 24, "https://images-na.ssl-images-amazon.com/images/I/715Lmz02LbL._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("CL660 Solo", "Gigaset", "tel-fixes", 58, "https://images-na.ssl-images-amazon.com/images/I/81LUDdVPb6L._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("VEGA 250 Duo", "Logicom", "tel-fixes", 30, "https://images-na.ssl-images-amazon.com/images/I/61OLCpLdUAL._AC_SL1200_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Support Téléphone Voiture 360°", "Aukey", "tel-accessoire", 15, "https://images-na.ssl-images-amazon.com/images/I/71Yh650M5BL._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Chargeur secteur USB C", "UGREEN", "tel-accessoire", 17, "https://images-na.ssl-images-amazon.com/images/I/61r0q--Ax9L._AC_SL1500_.jpg"));
        data.put(idCounter.getAndIncrement(), new Item("Coque Iphone 8", "Rhinoshield", "tel-accessoire", 30, "https://images-na.ssl-images-amazon.com/images/I/81%2BB9-8y-pL._AC_SL1500_.jpg"));
    }

    private ItemDAO() {
    }

    public static ItemDAO getInstance() {
        if (instance == null)
            instance = new ItemDAO();
        return instance;
    }

    @Override
    public Map<Integer, Item> all() {
        return data;
    }

    @Override
    public Optional<Item> get(int id) {
        Item item = data.get(id);
        return Optional.ofNullable(item);
    }

    public Map<Integer, Item> getByCategory(String category) {
        Map<Integer, Item> res = new HashMap<>();
        data.forEach((integer, item) -> {
            if (item.getCategory().equals(category))
                res.put(integer, item);
        });
        return res;
    }

    public Map<Integer, Item> getByMainCategory(String category) {
        Map<Integer, Item> res = new HashMap<>();
        data.forEach((integer, item) -> {
            if (item.getCategory().startsWith(category))
                res.put(integer, item);
        });
        return res;
    }

    @Override
    public int save(Item item) {
        int newId = idCounter.getAndIncrement();
        data.put(newId, item);
        return newId;
    }

    @Override
    public boolean update(int id, Item newItem) {
        Item oldItem = data.put(id, newItem);
        if (oldItem != null) {
            return !oldItem.equals(newItem);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return data.remove(id) != null;
    }
}
