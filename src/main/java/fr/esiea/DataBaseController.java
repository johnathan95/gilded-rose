package fr.esiea;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class DataBaseController {

    private final BiMap<Integer, Item> db = HashBiMap.create();
    private final AtomicInteger sequenceGenerator = new AtomicInteger();
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringWebApp.class);
    private static DataBaseController INSTANCE;

    private DataBaseController() { }

    public int addItem(Item item) {
        final int id;
        if (!db.containsValue(item)) {
            id = sequenceGenerator.incrementAndGet();
            item.setId(id);
            db.put(id, item);
            LOGGER.info(item + " created with ID: " + id);
        } else {
            this.updateItem(item);
            id = db.inverse().get(item);
            LOGGER.info(item + " already exists with ID: " + id);
        }
        return id;
    }

    public List<Item> getItems() {
        return db.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }

    public void updateItem(Item item) {
        this.db.forcePut(item.getId(), item);
    }

    public boolean removeItem(Item item) {
        if (db.containsValue(item)) {
            LOGGER.info(item + " removed");
            db.remove(item.getId(), item);
        }
        return true;
    }
    public void setItems(Item[] items) {
        for (Item item : items) {
            this.addItem(item);
        }
    }

    public Item getItem(int id) {
        return db.getOrDefault(id, null);
    }

    public static DataBaseController getInstance() {
        if (INSTANCE == null) {
            synchronized (DataBaseController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataBaseController();
                }
            }
        }
        return INSTANCE;
    }
}