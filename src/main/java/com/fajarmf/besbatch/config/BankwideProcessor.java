package com.fajarmf.besbatch.config;

import com.fajarmf.besbatch.entity.BankwideData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BankwideProcessor implements ItemProcessor<BankwideData, BankwideData> {
    @Override
    public BankwideData process(BankwideData bankwideData) {
        log.info("asu deh {}", bankwideData);
        return bankwideData;
    }
}
