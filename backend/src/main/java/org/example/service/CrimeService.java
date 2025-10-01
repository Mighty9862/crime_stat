package org.example.service;

import org.example.entity.CrimeRecord;
import org.example.repository.CrimeRepository;
import org.example.util.XMLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CrimeService {
    private final CrimeRepository repository;

    @Autowired
    private DataFetcherService dataFetcherService;

    public CrimeService(CrimeRepository repository) { this.repository = repository; }

    public void reloadData() {
        dataFetcherService.fetchData();

        repository.deleteAll();
        Map<String, CrimeRecord> records = new HashMap<>();
        processFile("data/extrem.xml", "extremism", records);
        processFile("data/osob.xml", "osob", records);
        processFile("data/terrorism.xml", "terrorism", records);
        processFile("data/weapon.xml", "weapon", records);
        for (CrimeRecord r : records.values()) {
            int tot = r.getExtremism() + r.getOsob() + r.getTerrorism() + r.getWeapon();
            r.setTotal(tot);
        }
        repository.saveAll(records.values());
    }

    private void processFile(String resourcePath, String type, Map<String, CrimeRecord> records) {
        Map<String, Integer> data = XMLReader.parseFileFromClasspath(resourcePath);
        for (Map.Entry<String, Integer> e : data.entrySet()) {
            records.putIfAbsent(e.getKey(), new CrimeRecord(e.getKey()));
            CrimeRecord rec = records.get(e.getKey());
            switch (type) {
                case "extremism" -> rec.addExtremism(e.getValue());
                case "osob" -> rec.addOsob(e.getValue());
                case "terrorism" -> rec.addTerrorism(e.getValue());
                case "weapon" -> rec.addWeapon(e.getValue());
            }
        }
    }

    public List<CrimeRecord> getAll() { return repository.findAll(); }
}
