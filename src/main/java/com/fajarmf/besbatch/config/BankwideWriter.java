package com.fajarmf.besbatch.config;

import com.fajarmf.besbatch.entity.BankwideData;
import com.fajarmf.besbatch.entity.BankwideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class BankwideWriter implements ItemWriter<BankwideData> {
    @Autowired
    BankwideRepository repository;

    @Override
    public void write(List<? extends BankwideData> list) throws Exception {
        log.info("hehehehei");

        list.forEach(bankwideData -> {
            log.info("bankwide {}", bankwideData);
            repository.save(bankwideData);
        });
    }
}
